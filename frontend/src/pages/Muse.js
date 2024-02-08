import React from 'react';
import { Link } from 'react-router-dom';
import "../resources/css/Muse.css";
import "../resources/css/BookingPage.css";
import MusePaintingGrid from '../components/MusePaintingGrid';
import MuseSculptureGrid from '../components/MuseSculptureGrid';


const MuseMuseum = () => {
    return (
        <div>
            <h2 className="page-heading margin-align">Muse Museum</h2>
            <section className="link-container">
            <div className="arrow-link">
                <Link to="/visit">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
            </div>
            <br />
            <div className="arrow-link">
                <Link to="/exhibitions">
                    See upcoming exhibitions<i className="fas fa-arrow-right"></i>
                </Link>
            </div>
            <div>
            <h2 className="page-heading margin-align">Our Paintings</h2>
                <MusePaintingGrid/>
                <h2 className="page-heading margin-align">Our Sculptures</h2>
                <MuseSculptureGrid/>
            </div>
            <br/>
            </section>
        </div>
    );
};

export default MuseMuseum;