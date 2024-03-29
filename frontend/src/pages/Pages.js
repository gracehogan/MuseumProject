import React from 'react';
import { Link } from 'react-router-dom';
import "../resources/css/Pages.css";
import "../resources/css/BookingPage.css";
import PagesPaintingGrid from '../components/PagesPaintingGrid';
import PagesSculptureGrid from '../components/PagesSculptureGrid';

const PagesMuseum = () => {
    return (
        <div>
            <nav aria-label="breadcrumb">
                <ol className="breadcrumb">
                    <li className="breadcrumb-item"><Link to="/">Home</Link></li>
                    <li className="breadcrumb-item"><Link to="/museums">Museums</Link></li>
                    <li className="breadcrumb-item"><Link to="/museum/Pages">Pages</Link></li>
                </ol>
            </nav>

            <h2 className="page-heading margin-align">Pages Museum</h2>
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
                <PagesPaintingGrid/>
                <h2 className="page-heading margin-align">Our Sculptures</h2>
                <PagesSculptureGrid/>
            </div>
            <br/>
            </section>
        </div>
    );
};

export default PagesMuseum;
