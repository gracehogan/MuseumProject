import '../resources/css/VisitPage.css';
import "../resources/css/BookingPage.css";
import Exhibitions from '../components/Exhibitions';
import { Link } from 'react-router-dom';

const VisitPage = () => {
    return (
        <div>
            <h2 className="page-heading margin-align" id="visit-page">Plan Your Visit</h2>
            <section className="link-container">
            <p className="link-container">
                Embark on a captivating journey through time and culture at our museum. As you step into our hallowed halls, 
                you are about to embark on an immersive exploration of the past, present, and future. 
                Our carefully curated exhibits offer a tapestry of human history, artistry, and innovation, 
                inviting you to witness the echoes of bygone eras and the enduring legacies that have shaped our world. 
                Welcome to a museum where character is birthed, and every visit is a voyage into the extraordinary.
            </p>
                <div className="booking-button">
                    <Link to="/book">
                    Book your tickets <i className="fas fa-arrow-right"></i>
                    </Link>
                </div>
                <hr style={{"width" : "30%", "marginLeft" : "35%", "marginRight" : "35%", "marginTop" : "20px"}}/>
                <h3 className="page-heading margin-align">Exhibitions</h3>
                <div className="exhibitions-container">
                    <Exhibitions />                
                </div>
            </section>
        </div>
    );
};

export default VisitPage;
