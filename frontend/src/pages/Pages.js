import React from 'react';
import { Link } from 'react-router-dom';
import "../resources/css/Pages.css";

const Pages = () => {
    return (
        <div>
            <div className='pages-box'>
                <h1 className="museum-heading">Pages Museum</h1>
            </div>
            <div>
                <Link to="/booking" className="arrow-link">
                    Go to Booking Page <i className="fas fa-arrow-right"></i>
                </Link>
            </div>
            <div>
                <Link to="/visit" className="arrow-link">
                     Visit us <i className="fas fa-arrow-right"></i>
                </Link>
            </div>
        </div>
    );
};

export default Pages;
