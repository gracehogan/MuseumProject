import React, { useContext } from "react";
import '../resources/css/Menu.css';
import { PaintingButtonContext } from "./PaintingButtonContext";

const PaintingSortByDropdown = () => {
    const {paintingButtonClicked, setPaintingButtonClicked} = useContext(PaintingButtonContext);

    const handleButtonClick = (id) => {
        setPaintingButtonClicked(id);
    };

    return (
        <div className="dropdown">
            <li className="list-inline-item dropbtn">
              <button className="dropbtn" id="sort-by" onClick={() => handleButtonClick("sort-by")}>Sort By</button>
            </li>
            <div className="dropdown-content">
              <li className="list-inline-item dropbtn">
                <button className="dropbtn" id="title-asc" onClick={() => handleButtonClick("title-asc")}>Title (A-Z)</button>
              </li>
              <li className="list-inline-item dropbtn">
              <button className="dropbtn" id="title-desc" onClick={() => handleButtonClick("title-desc")}>Title (Z-A)</button>
              </li>
              <li className="list-inline-item dropbtn">
              <button className="dropbtn" id="year-asc" onClick={() => handleButtonClick("year-asc")}>Year Completed (asc)</button>
              </li>
              <li className="list-inline-item dropbtn">
              <button className="dropbtn" id="year-desc" onClick={() => handleButtonClick("year-desc")}>Year Completed (desc)</button>
              </li>
            </div>
        </div>
    );
};

export default PaintingSortByDropdown;

