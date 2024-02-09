import React, { useContext } from "react";
import "../resources/css/SearchBar.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { PaintingSearchBarContext } from "./PaintingSearchBarContext";

const PaintingSearchBar = () => {
    const {paintingSearchBarContents, setPaintingSearchBarContents } = useContext(PaintingSearchBarContext);

    const handleSearchBarChange = (value) => {
        setPaintingSearchBarContents(value);
    };
    
    return (
        <div className="search-box" id = "painting-search-bar">
            <form name="search">
                <input 
                className="input" type="text" name="filter" value={paintingSearchBarContents}
                onMouseLeave= {
                    (e) => {
                        e.target.value = "";
                        e.target.blur();
                    }
                } 
                onChange={(e) => handleSearchBarChange(e.target.value)}
                />
            </form>
            <FontAwesomeIcon className="search-icon" icon={faSearch} />
        </div>
    );
};

export default PaintingSearchBar;