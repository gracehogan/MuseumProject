import React from 'react';
import '../resources/css/Menu.css';
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom"; 


const Menu = () => {
  return (
    <div className="bg1">
      <nav>
        <ul className="list-inline">
          <li className="list-inline-item">
            <Link to="/">Home</Link>
          </li>

          <div className="dropdown">
            <li className="list-inline-item dropbtn">
              <Link to="/museums">Museums</Link>
            </li>
            <div className="dropdown-content">
              <Link to="/museum/Muse">MUSE</Link>
              <Link to="/museum/Pages">PAGES</Link>
            </div>
          </div>

          <li className="list-inline-item">
            <Link to="/visit">Plan Your Visit</Link>
          </li>

          <div className="dropdown">
            <li className="list-inline-item dropbtn">
              <Link>Help</Link>
            </li>
            <div className="dropdown-content">
              <Link to="/help/contact-us">Contact us</Link>
              <Link to="/help/faq">FAQs</Link>
            </div>
          </div>

        </ul>
        {/* Search bar added here */}
      </nav>
    </div>
  );
};

export default Menu;