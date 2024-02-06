import React from 'react';
import '../resources/css/Menu.css';
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom"; 


const Menu = () => {
  return (
    <div className="bg1">
      <nav>
        <ul className='list-inline'>
          <li className="list-inline-item">
            <Link to="/home">Home</Link>
          </li>
          <li className="list-inline-item">
            <Link to="/museums">Museums</Link>
          </li>
          <li className="list-inline-item">
            <Link to="/visit-us">Plan Your Visit</Link>
          </li>
          <li className="list-inline-item">
            <Link>Help</Link>
          </li>
        </ul>
        {/* Search bar added here */}
      </nav>
    </div>
  );
};

export default Menu;