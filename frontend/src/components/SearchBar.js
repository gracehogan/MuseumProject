import "../resources/css/SearchBar.css";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch } from '@fortawesome/free-solid-svg-icons';

const SearchBar = () => {
    return (
        <div className="search-box">
            <form name="search">
                <input 
                className="input" type="text" name="filter"
                onMouseLeave= {
                    (e) => {
                        e.target.value = "";
                        e.target.blur();
                    }
                } 
                />
            </form>
            <FontAwesomeIcon className="search-icon" icon={faSearch} />
        </div>
    );
};

export default SearchBar;