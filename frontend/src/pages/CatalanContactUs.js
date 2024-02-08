// import React, { useState } from 'react';
// import '../resources/css/ContactPage.css';
// import '@fortawesome/fontawesome-free/css/all.min.css';
// import { Link } from 'react-router-dom';
// import "../resources/css/CatalanContactUs.css";

// const CatalanAboutUs = () => {
//     const [formData, setFormData] = useState({
//         name: '',
//         email: '',
//         enquiry: ''
//     });

//     const handleChange = (e) => {
//         setFormData({
//             ...formData,
//             [e.target.name]: e.target.value
//         });
//     };

//     const handleSubmit = (e) => {
//       e.preventDefault();

//       console.log(formData);
  
//       alert('S\'ha enviat una confirmació per correu electrònic a l\'adreça proporcionada.');
  
//       setFormData({
//           name: '',
//           email: '',
//           enquiry: ''
//       });
//   };

//     return (
//         <div>
//             <div className='heading-container'>
//                 <h2>Posa’t en contacte amb nosaltres</h2>
//                 <div className="language-buttons">
//                     <Link to="/spanish" className="language-button">ES</Link>
//                     <Link to="/hindi" className="language-button">HI</Link>
//                     <Link to="/french" className="language-button">FR</Link>
//                     <Link to="/contact-us" className="language-button">EN</Link>
//                 </div>
//             </div>
//             <div className='enquiry-container'>
//             <form onSubmit={handleSubmit} className='form-container'>
//               <div className='enquiry-heading-container'>
//                 <h2>Formulari de consulta</h2>
//               </div>
//                 <div className='form-group'>
//                     <label htmlFor='name'><i className="fas fa-user"></i> Nom :</label>
//                     <div className='text-container'>
//                       <input type='text' id='name' name='name' value={formData.name} onChange={handleChange} />
//                     </div>
//                 </div>
//                 <div className='form-group'>
//                     <label htmlFor='email'><i className="fas fa-envelope"></i> Correu electrònic :</label>
//                     <div className='text-container'>
//                       <input type='email' id='email' name='email' value={formData.email} onChange={handleChange} />
//                     </div>
//                 </div>
//                 <div className='form-group'>
//                     <label htmlFor='enquiry'><i className="fas fa-comment"></i> Pregunta :</label>
//                     <div className='text-container'>
//                       <textarea id='enquiry' name='enquiry' value={formData.enquiry} onChange={handleChange} />
//                     </div>
//                 </div>
//                 <button type='submit'><i className="fas fa-paper-plane"></i> Enviar</button>
//             </form>
//             </div>
//             <div className='heading-container'>
//               <h3>Informació de contacte</h3>
//             </div>
//             <div className='contact-info-and-opening-hours-container'>
//               <div className='contact-info-container'>
//                   <p>Nom : Grup PAGES</p>
//                   <p>Número de telèfon : 7828122</p>
//                   <p>Correu electrònic : pages@bootcamp.com</p>
//                   <p>Adreça : Grup PAGES Ltd, Planta 16, Northampton</p>
//               </div>
//               <div className='opening-hour-container'>
//                 <div className='contact-hours-container'>
//                   <h5>Horari de l’oficina de PAGES :</h5>
//                   <p>Dill - Div : 9h a 18h</p>
//                 </div>
//               </div>
//             </div>
//               <div>
//                 <iframe 
//                     src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2444.341023648357!2d-0.8759537000000001!3d52.2190218!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x48770f32bbd38fbd%3A0x392de42e1f2dc215!2sBarclays%2C%201234%20Pavilion%20Dr%2C%20Northampton%20NN4%207SG!5e0!3m2!1sen!2suk!4v1707332240025!5m2!1sen!2suk" 
//                     width="100%" 
//                     height="500"
//                     allowfullscreen="" 
//                     loading="lazy" 
//                     referrerpolicy="no-referrer-when-downgrade">
//                   </iframe>
//             </div>
//         </div>
//     );
// };

// export default CatalanAboutUs;
