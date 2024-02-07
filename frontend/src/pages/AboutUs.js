import React from 'react';
import '../resources/css/AboutUs.css';

const AboutUs = () => {
    return (
        <div>
            <div className="about-us-container">
                <img src="/museum.jpg" alt="Museum" className="about-us-image" />
            <div className="overlay-text">About Us</div>
        </div>
        <div className='content-container'>
            <p>Welcome to PAGES, where art meets history and creativity knows no bounds. Established in August 2023 by a group of passionate individuals including Pelumi, Ani, Grace, Edward, and Shona, PAGES stands as a testament to their dedication and love for art.</p>
            <h4>Our Museums</h4>
            <p>With four distinct museums under our umbrella, PAGES offers a diverse array of paintings and sculptures for enthusiasts and connoisseurs alike. Each museum boasts its own unique collection, ensuring there's something for everyone to explore and admire.</p>
            <h4>Exhibitions</h4>
            <p>At PAGES, we believe in the power of exhibitions to inspire, educate, and entertain. From traditional masterpieces to contemporary installations, our exhibitions showcase the rich tapestry of human expression. Whether you're an art aficionado or a curious visitor, our exhibitions promise to captivate and intrigue.</p>
            <h4>Our Journey</h4>
            <p>Since our inception, the PAGES group has tirelessly worked to elevate the cultural landscape of our community. Through dedication, innovation, and unwavering passion, we have earned recognition and acclaim within the museum fraternity.</p>
            <h4>Explore Further</h4>
            <p>If you're eager to learn more about the museums within our reach, we invite you to explore our website for detailed information, upcoming events, and booking options.</p>
            <p>Thank you for choosing PAGES as your gateway to the world of art and culture.</p>
            <h6>Regards,</h6>
            <h6>PAGES</h6>
        </div>
      </div>
    );
  };
  
  export default AboutUs;