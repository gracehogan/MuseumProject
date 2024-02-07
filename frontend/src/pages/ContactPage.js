import React, { useState } from 'react';
import '../resources/css/ContactPage.css';
import '@fortawesome/fontawesome-free/css/all.min.css';


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
        </div>
    );
};

export default ContactPage;
