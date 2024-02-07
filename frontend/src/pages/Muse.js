import React from 'react';
import { Link } from 'react-router-dom';
import "../resources/css/Muse.css";

const MuseMuseum = () => {
    return (
        <div>
            <div className='muse-box'>
                <h1 className="museum-heading">Muse Museum</h1>
            </div>
            <div className='visit-container'>
                <Link to="/visit" className="arrow-link">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
                </div>
                <div className='exhibition-container'>
                <Link to="/exhibitions" className="arrow-link">
                    See upcoming exhibitions<i className="fas fa-arrow-right"></i>
                </Link>
            </div>
        </div>
    );
};

export default MuseMuseum;