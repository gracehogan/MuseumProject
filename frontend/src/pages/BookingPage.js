import React, { useState } from 'react';
import '../resources/css/BookingPage.css';
import axios from 'axios';
import { useTranslation } from 'react-i18next';
import i18n from '../i18n';
const BookingPage = () => {
  const { t } = useTranslation();

  const changeLanguage = (lng) => {
    i18n.changeLanguage(lng); // Use the changeLanguage function from the i18n instance
  };
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    bookingDate: '',
    bookedMuseum: '',
    cost:'',
  });
  
  const [selectedOption, setSelectedOption] = useState('');
  const [selectedTicket, setselectedTicket] = useState('');
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    setSelectedOption(value); // Update selectedOption when a radio button is selected

  };
  const handleNumberChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };
  
  
  
  const handleTicketChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    setselectedTicket(value);
  };
  const handleSubmit = async(e) => {
    e.preventDefault();
  try {
      const response = await axios.post('http://localhost:8080/saveBooking', formData);
      console.log('Enquiry saved successfully:', response.data);
    } catch (error) {
      console.error('Error saving enquiry:', error);
    }
  
      console.log(formData);
  
      alert(t('Booking was successful 🙂'));
      setFormData({
        name: '',
        email: '',
        bookingDate: '',
        bookedMuseum: '',
        cost:'',
      });
    };
  return (
    <div className='booking-container'  >
      <h2 className="page-heading margin-align">Book your tickets</h2>
      <section className="margin-align">
        <form onSubmit={handleSubmit}>
          <label htmlFor="name">Name</label>
          <input type="text" name="name" id="name" required minLength="5" value={formData.name} onChange={handleChange} />
          <br />

          <label htmlFor="email">Email address</label>
          <input type="text" name="email" id="email" required minLength="9" value={formData.email} onChange={handleChange}/>
          <br />

          <label htmlFor="bookingDate">Date</label>
          <input type="datetime-local" name="bookingDate" id="bookingDate" value={formData.bookingDate} onChange={handleChange}/>
          <br />

          <label>Museum</label>
          <input type="radio" name="bookedMuseum" value="Horizons" id="horizons" checked={selectedOption === 'Horizons'} onChange={handleChange}/>
          <label htmlFor="horizons">Horizons</label>
          <input type="radio" name="bookedMuseum" value="MUSE" id="muse" checked={selectedOption === 'MUSE'} onChange={handleChange} />
          <label htmlFor="muse">Muse </label>
          <input type="radio" name="bookedMuseum" value="PAGES" id="pages" checked={selectedOption === 'PAGES'} onChange={handleChange}/>
          <label htmlFor="pages">PAGES</label>
          <input type="radio" name="bookedMuseum" value="Xplore" id="xplore" checked={selectedOption === 'Xplore'} onChange={handleChange}/>
          <label htmlFor="xplore">Xplore</label>
          <br />

          
          <label>Ticket type</label>
            <input type="radio" name="bookingType" value="GROUP_ADULT" id="adult" checked={selectedTicket === 'GROUP_ADULT'} onChange={handleTicketChange}/>
            <label >Group Adult (>4 Adults)</label>
            <input type="radio" name="bookingType" value="SINGLE_ADULT" id="adult"checked={selectedTicket === 'SINGLE_ADULT'} onChange={handleTicketChange} />
            <label >Single Adult (18+)</label>
            <input type="radio" name="bookingType" value="GROUP_ADULT" id="adult" checked={selectedTicket === 'GROUP_ADULT'} onChange={handleTicketChange}/>
            <label >Single Child</label>
            <input type="radio" name="bookingType" value="GROUP_CHILD" id="child" checked={selectedTicket === 'GROUP_CHILD'} onChange={handleTicketChange}/>
            <label >Group Child(>4 Kids)</label>
            <br />
            <label for="numberOfPersons">How many people are in your group?</label>
            <input type="number" name="numberOfPersons" id="numberOfPersons" step="1" min="1" value={formData['numberOfPersons']} onChange={handleNumberChange}/>

            <br />

            <label for="total">Total</label>
            <br />            

          <input type="submit" value="Book"/>
        </form>
      </section>
    </div>
  );
};

export default BookingPage;
