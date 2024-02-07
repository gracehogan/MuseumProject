import React, { useState } from 'react';
import '../resources/css/SpanishContactUs.css';
import '@fortawesome/fontawesome-free/css/all.min.css';
import { Link } from 'react-router-dom';

const SpanishContactUs = () => {
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
  
      alert('Se ha enviado una confirmación por correo electrónico a la dirección proporcionada.');
  
      setFormData({
          name: '',
          email: '',
          enquiry: ''
      });
  };

    return (
        <div>
            <div className='heading-container'>
                <h2>Póngase en contacto con nosotros</h2>
                <div className="language-buttons">
                    <Link to="/contact-us" className="language-button">EN</Link>
                    <Link to="/hindi" className="language-button">HI</Link>
                    <Link to="/french" className="language-button">FR</Link>
                    <Link to="/catalan" className="language-button">CA</Link>
                </div>
            </div>
            <div className='enquiry-container'>
                <form onSubmit={handleSubmit} className='form-container'>
                    <div className='enquiry-heading-container'>
                        <h2>Formulario de consulta</h2>
                    </div>
                    <div className='form-group'>
                        <label htmlFor='name'><i className="fas fa-user"></i> Nombre:</label>
                        <div className='text-container'>
                            <input type='text' id='name' name='name' value={formData.name} onChange={handleChange} />
                        </div>
                    </div>
                    <div className='form-group'>
                        <label htmlFor='email'><i className="fas fa-envelope"></i> Correo electrónico:</label>
                        <div className='text-container'>
                            <input type='email' id='email' name='email' value={formData.email} onChange={handleChange} />
                        </div>
                    </div>
                    <div className='form-group'>
                        <label htmlFor='enquiry'><i className="fas fa-comment"></i> Pregunta:</label>
                        <div className='text-container'>
                            <textarea id='enquiry' name='enquiry' value={formData.enquiry} onChange={handleChange} />
                        </div>
                    </div>
                    <button type='submit'><i className="fas fa-paper-plane"></i> Enviar</button>
                </form>
            </div>
            <div className='heading-container'>
                <h3>Información de contacto</h3>
            </div>
            <div className='contact-info-and-opening-hours-container'>
                <div className='contact-info-container'>
                    <p>Nombre: Grupo PAGES</p>
                    <p>Número de teléfono: 7828122</p>
                    <p>Correo electrónico: pages@bootcamp.com</p>
                    <p>Dirección: Grupo PAGES Ltd, Planta 16, Northampton</p>
                </div>
                <div className='opening-hour-container'>
                    <div className='contact-hours-container'>
                        <h5>Horario de la oficina de PAGES:</h5>
                        <p>De lunes a viernes de 9.00 a 18.00h</p>
                    </div>
                </div>
            </div>
            <div className='image-container'>
                <img src="/map.jpg" alt="Mapa" className="map-image" style={{ width: '50%', height: 'auto' }} />
            </div>
        </div>
    );
};

export default SpanishContactUs;
