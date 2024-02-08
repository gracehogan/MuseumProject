import React from 'react';
import { Link } from 'react-router-dom';
import "../resources/css/Muse.css";
import "../resources/css/BookingPage.css";


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
            </section>
        </div>
    );
};

export default MuseMuseum;