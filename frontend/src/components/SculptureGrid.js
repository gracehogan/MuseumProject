import React, { useEffect, useState, useContext } from "react";
import '../resources/css/ImageGrid.css';
import { SculptureButtonContext } from "./SculptureButtonContext";
import { SculptureSearchBarContext } from "./SculptureSearchBarContext";

const SculptureGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [sculptureData, setSculptureData] = useState(null);
  const {sculptureButtonClicked, setSculptureButtonClicked} = useContext(SculptureButtonContext);
  const {sculptureSearchBarContents, setSculptureSearchBarContents} = useContext(SculptureSearchBarContext);
  const [url, setURL] = useState("http://localhost:8080/sculptures");

  
  useEffect(() => {
    const filterSearch = () => {
      console.log(sculptureSearchBarContents);
      if (sculptureSearchBarContents === "") {
        setURL("http://localhost:8080/sculptures");
      }
      else {
        setURL("http://localhost:8080/sculptures/getByAllFields/" + sculptureSearchBarContents);
      }
    }
    filterSearch();
  }, [sculptureSearchBarContents]);

  useEffect(() => {
    const selectButton = () => {
      if (sculptureButtonClicked === "title-asc") {
        setURL("http://localhost:8080/sculptures/sortAllByTitle/asc");
      }
      else if (sculptureButtonClicked === "title-desc") {
        setURL("http://localhost:8080/sculptures/sortAllByTitle/desc");
      }
      else if (sculptureButtonClicked === "year-asc") {
        setURL("http://localhost:8080/sculptures/sortAllByYearCompleted/asc");
      }
      else if (sculptureButtonClicked === "year-desc") {
        setURL("http://localhost:8080/sculptures/sortAllByYearCompleted/desc");
      }
      else if (sculptureButtonClicked === "sort-by") {
        setURL("http://localhost:8080/sculptures");
      }
    };
    selectButton();
  }, [sculptureButtonClicked]); // Update URL when buttonClicked changes

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);
        const data = await response.json();
        setSculptureData(data);
      } catch (error) {
        console.error("Error fetching sculpture data:", error);
      }
    };
    fetchData();
  }, [url]); // Only refetch data when URL changes

return (
    <div className="image-grid">
      {sculptureData && Array.isArray(sculptureData) && sculptureData.map((sculpture, index) => {
        return (
          <div
            key={index}
            className={`image-container ${hoveredIndex === index ? 'hovered' : ''}`}
            onMouseEnter={() => setHoveredIndex(index)}
            onMouseLeave={() => setHoveredIndex(null)}
          >
            <img src={sculpture.src} alt="Sculpture" />
            <div className="image-text">
            <center>
              <b><font size="+40">{sculpture.title}</font></b>
              <br/>
              <font size="+5">({sculpture.yearCompleted})</font>
              <br />
              <font size="+5">by</font>
              <br />
              <b><font size="+5">{sculpture.artistName}</font></b>
              <br />
              <br/>
              <br/>
              <b>Medium: </b>{sculpture.medium}
              <br/>
              <br/>
              <br/>
              <b>Description:</b> {sculpture.backstory}
              </center>
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default SculptureGrid;