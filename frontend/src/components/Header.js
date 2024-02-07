import React from 'react';
import '../resources/css/Header.css';
import SearchBar from './SearchBar';

const Header = () => {
  return (
    <div>
      <header className="heading-box flex-container">
        <div>
          <h1 className="heading flex-heading">PAGES GROUP</h1>
        </div>
        <div className="search-container flex-search">
          <SearchBar />
        </div>
    </header>
    </div>
  );
};

export default Header;