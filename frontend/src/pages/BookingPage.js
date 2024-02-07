import React from 'react';
import '../resources/css/BookingPage.css';

const BookingPage = () => {
    return (
      <div>
        <h2 className="book-heading book-margin">Book your tickets</h2>
        <section className="book-margin">
          <form>
            <label for="name">Name</label>
            <input type="text" name="customer-name" id="name" required minLength="5" />
            <br />

            <label for="email">Email address</label>
            <input type="text" name="customer-email" id="email" required minLength="9" />
            <br />

            <label for="date">Date</label>
            <input type="datetime-local" name="" id="date"/>
            <br />

            <label>Museum</label>
            <input type="radio" name="museum-name" value="Horizons" id="horizons" />
            <label for="pages">Horizons</label>
            <input type="radio" name="museum-name" value="Muse" id="muse" />
            <label for="muse">Muse</label>
            <input type="radio" name="museum-name" value="Pages" id="pages" />
            <label for="pages">PAGES</label>
            <input type="radio" name="museum-name" value="Xplore" id="xplore" />
            <label for="pages">Xplore</label>
            <br />

            <label>Ticket type</label>
            <input type="radio" name="ticket-type" value="Adult" id="adult" />
            <label for="pages">Adult (18+)</label>
            <input type="radio" name="ticket-type" value="Child" id="child" />
            <label for="muse">Child</label>
            <br />

            <label for="group-size">How many people are in your group?</label>
            <input type="number" name="group-size" id="group-size" step="1" min="1"/>
            <br />

            <label for="total">Total</label>
            <br />            

            <input type="submit" value="Book"/>

          </form>
        </section>
      </div>
  );
};

//name value will need to match to the column name in our db
// double check if case in PAGES' value matters

export default BookingPage;