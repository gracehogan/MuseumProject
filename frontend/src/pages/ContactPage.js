import React, { useState } from 'react';
import { useTranslation } from 'react-i18next';
import i18n from '../i18n';
import '@fortawesome/fontawesome-free/css/all.min.css';
import '../resources/css/ContactPage.css';
import { Link } from 'react-router-dom';

function ContactPage() {
  const { t } = useTranslation();

  const [activeLanguage, setActiveLanguage] = useState(null);
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    enquiry: '',
  });

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const handleButtonClick = (lng) => {
    setActiveLanguage(lng);
    i18n.changeLanguage(lng);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
    alert(t('Confirmation'));
    setFormData({
      name: '',
      email: '',
      enquiry: '',
    });
  };

  return (
    <div>
      <div className='heading-container'>
        <div className="language-buttons">
          <button onClick={() => handleButtonClick('en')} className={activeLanguage === 'en' ? 'clicked-button' : 'language-button'}>English</button>
          <button onClick={() => handleButtonClick('fr')} className={activeLanguage === 'fr' ? 'clicked-button' : 'language-button'}>French</button>
          <button onClick={() => handleButtonClick('ca')} className={activeLanguage === 'ca' ? 'clicked-button' : 'language-button'}>Catalan</button>
          <button onClick={() => handleButtonClick('hi')} className={activeLanguage === 'hi' ? 'clicked-button' : 'language-button'}>Hindi</button>
          <button onClick={() => handleButtonClick('es')} className={activeLanguage === 'es' ? 'clicked-button' : 'language-button'}>Spanish</button>
        </div>
        <nav aria-label="breadcrumb">
          <ol className="breadcrumb">
            <li className="breadcrumb-item"><Link to="/">Home</Link></li>
            <li className="breadcrumb-item"><Link to="/help/contact-us">Contact us</Link></li>
          </ol>
        </nav>
        <h2>{t('GetInTouch')}</h2>
      </div>
      <div className='enquiry-container'>
        <form onSubmit={handleSubmit} className='form-container'>
          <div className='enquiry-heading-container'>
            <h2>{t('Form')}</h2>
          </div>
          <div className='form-group'>
            <label htmlFor='name'><i className="fas fa-user"></i> {t('Name')}</label>
            <div className='text-container'>
              <input type='text' id='name' name='name' value={formData.name} onChange={handleChange} />
            </div>
          </div>
          <div className='form-group'>
            <label htmlFor='email'><i className="fas fa-envelope"></i> {t('Email')}:</label>
            <div className='text-container'>
              <input type='email' id='email' name='email' value={formData.email} onChange={handleChange} />
            </div>
          </div>
          <div className='form-group'>
            <label htmlFor='enquiry'><i className="fas fa-comment"></i> {t('Enquiry')}</label>
            <div className='text-container'>
              <textarea id='enquiry' name='enquiry' value={formData.enquiry} onChange={handleChange} />
            </div>
          </div>
          <button 
            type='submit' 
            className='language-button'
          >
            <i className="fas fa-paper-plane"></i> {t('Submit')}
          </button>
        </form>
      </div>
      <div className='heading-container'>
        <h3>{t('Information')}</h3>
      </div>
      <div className='contact-info-and-opening-hours-container'>
        <div className='contact-info-container'>
          <p>{t('PAGESName')}</p>
          <p>{t('PhoneNumber')}</p>
          <p>{t('PAGESEmail')}</p>
          <p>{t('Address')}</p>
        </div>
        <div className='opening-hour-container'>
          <div className='contact-hours-container'>
            <h5>{t('OpeningTime')}</h5>
            <p>{t('OfficeHours')}</p>
          </div>
        </div>
      </div>
      <div className='map-container'>
        <iframe 
          src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.341023648357!2d-0.8759537000000001!3d52.2190218!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48770f32bbd38fbd%3A0x392de42e1f2dc215!2sBarclays%2C%201234%20Pavilion%20Dr%2C%20Northampton%20NN4%207SG!5e0!3m2!1sen!2suk!4v1707332240025!5m2!1sen!2suk" 
          width="100%" 
          height="500"
          allowfullscreen="" 
          loading="lazy" 
          referrerpolicy="no-referrer-when-downgrade">
        </iframe>
      </div>
    </div>
  );
}

export default ContactPage;
