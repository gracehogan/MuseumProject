import React, { useState } from 'react';
import '../resources/css/ContactPage.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Link } from 'react-router-dom';

const ContactPage = () => {
    const [formData, setFormData] = useState({
        name: '',
        email: '',
        enquiry: ''
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
      e.preventDefault();

      console.log(formData);
  
      alert('An email confirmation has been sent to the provided email ID.');
  
      setFormData({
          name: '',
          email: '',
          enquiry: ''
      });
  };

    return (
        <div>
            <div className='heading-container'>
                <h2>Get in touch with us</h2>
                <div className="language-buttons">
                    <Link to="/spanish" className="language-button">Spanish</Link>
                    <button className="language-button">Hindi</button>
                    <button className="language-button">French</button>
                    <button className="language-button">Catalan</button>
                </div>
            </div>
            <div className='enquiry-container'>
            <form onSubmit={handleSubmit} className='form-container'>
              <div className='enquiry-heading-container'>
                <h2>Enquiry Form</h2>
              </div>
                <div className='form-group'>
                    <label htmlFor='name'><i className="fas fa-user"></i> Name:</label>
                    <div className='text-container'>
                      <input type='text' id='name' name='name' value={formData.name} onChange={handleChange} />
                    </div>
                </div>
                <div className='form-group'>
                    <label htmlFor='email'><i className="fas fa-envelope"></i> Email:</label>
                    <div className='text-container'>
                      <input type='email' id='email' name='email' value={formData.email} onChange={handleChange} />
                    </div>
                </div>
                <div className='form-group'>
                    <label htmlFor='enquiry'><i className="fas fa-comment"></i> Enquiry:</label>
                    <div className='text-container'>
                      <textarea id='enquiry' name='enquiry' value={formData.enquiry} onChange={handleChange} />
                    </div>
                </div>
                <button type='submit'><i className="fas fa-paper-plane"></i> Submit</button>
            </form>
            </div>
            <div className='heading-container'>
              <h3>Contact information</h3>
            </div>
            <div className='contact-info-and-opening-hours-container'>
              <div className='contact-info-container'>
                  <p>Name: PAGES Group</p>
                  <p>Phone Number: 7828122</p>
                  <p>Email: pages@bootcamp.com</p>
                  <p>Address: PAGES Group Ltd, Floor 16, Northampton</p>
              </div>
              <div className='opening-hour-container'>
                <div className='contact-hours-container'>
                  <h5>PAGES office opening time:</h5>
                  <p>Monday- Friday: 9am to 6pm</p>
                </div>
              </div>
            </div>
            <div className='image-container'>
              <img src="/map.jpg" alt="Map" className="map-image" style={{ width: '50%', height: 'auto' }} />
            </div>
        </div>
    );
};

export default ContactPage;
