import React, { useContext } from "react";
import "../resources/css/SearchBar.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch } from '@fortawesome/free-solid-svg-icons';
import { SculptureSearchBarContext } from "./SculptureSearchBarContext";

const SculptureSearchBar = () => {
    const {sculptureSearchBarContents, setSculptureSearchBarContents } = useContext(SculptureSearchBarContext);

    const handleSearchBarChange = (value) => {
        setSculptureSearchBarContents(value);
    };
    
    return (
        <div className="search-box" id = "sculpture-search-bar">
            <form name="search">
                <input 
                className="input" type="text" name="filter" value={sculptureSearchBarContents}
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

export default SculptureSearchBar;