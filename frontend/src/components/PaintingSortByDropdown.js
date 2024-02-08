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
              <button id="sort-by" onClick={() => handleButtonClick("sort-by")}>Sort By</button>
            </li>
            <div className="dropdown-content">
              <button id="title-asc" onClick={() => handleButtonClick("title-asc")}>Title (asc)</button>
              <button id="title-desc" onClick={() => handleButtonClick("title-desc")}>Title (desc)</button>
              <button id="year-asc" onClick={() => handleButtonClick("year-asc")}>Year Completed (asc)</button>
              <button id="year-desc" onClick={() => handleButtonClick("year-desc")}>Year Completed (desc)</button>
            </div>
        </div>
    );
};

export default PaintingSortByDropdown;

