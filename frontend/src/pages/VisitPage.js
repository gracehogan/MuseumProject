import '../resources/css/VisitPage.css';
import Exhibitions from '../components/Exhibitions';
import { Link } from 'react-router-dom';

const VisitPage = () => {
    return (
        <div>
            <div className="heading-container">
                <h2>Plan Your Visit</h2>
                <p>Find everything you need for your next visit to one of our museums</p>
            </div>
            <div className="booking-link-container">
                <Link to="/booking" className="booking-link">
                    Go to Booking Page <i className="fas fa-arrow-right"></i>
                </Link>
            </div>
            <div className="exhibitions-container">
                <h2>Exhibitions</h2>
                <Exhibitions />
            </div>
        </div>
    );
};

export default VisitPage;
