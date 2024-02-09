import React, { useEffect, useState, useContext } from "react";
import '../resources/css/ImageGrid.css';
import { PaintingButtonContext } from "./PaintingButtonContext";
import { PaintingSearchBarContext } from "./PaintingSearchBarContext";

const PaintingGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [paintingData, setPaintingData] = useState(null);
  const {paintingButtonClicked, setPaintingButtonClicked} = useContext(PaintingButtonContext);
  const {paintingSearchBarContents, setPaintingSearchBarContents} = useContext(PaintingSearchBarContext);
  const [url, setURL] = useState("http://localhost:8080/paintings");

  useEffect(() => {
    const filterSearch = () => {
      console.log(paintingSearchBarContents);
      if (paintingSearchBarContents === "") {
        setURL("http://localhost:8080/paintings");
      }
      else {
        setURL("http://localhost:8080/paintings/getByAllFields/" + paintingSearchBarContents);
      }
    }
    filterSearch();
  }, [paintingSearchBarContents]);

  useEffect(() => {
    const selectButton = () => {
      if (paintingButtonClicked === "title-asc") {
        setURL("http://localhost:8080/paintings/sortAllByTitle/asc");
      }
      else if (paintingButtonClicked === "title-desc") {
        setURL("http://localhost:8080/paintings/sortAllByTitle/desc");
      }
      else if (paintingButtonClicked === "year-asc") {
        setURL("http://localhost:8080/paintings/sortAllByYearCompleted/asc");
      }
      else if (paintingButtonClicked === "year-desc") {
        setURL("http://localhost:8080/paintings/sortAllByYearCompleted/desc");
      }
      else if (paintingButtonClicked === "sort-by") {
        setURL("http://localhost:8080/paintings");
      }
    };
    selectButton();
  }, [paintingButtonClicked]); // Update URL when buttonClicked changes

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(url);
        const data = await response.json();
        setPaintingData(data);
        console.log(paintingData);
      } catch (error) {
        console.error("Error fetching painting data:", error);
      }
    };
    fetchData();
  }, [url]); // Only refetch data when URL changes

  return (
    <div className="image-grid">
      {paintingData && Array.isArray(paintingData) && paintingData.map((painting, index) => {
        return (
          <div
            key={index}
            className={`image-container ${hoveredIndex === index ? 'hovered' : ''}`}
            onMouseEnter={() => setHoveredIndex(index)}
            onMouseLeave={() => setHoveredIndex(null)}
          >
            <img src={painting.src} alt="Painting" />
            <div className="image-text">
            <center>
              <b><font size="+40">{painting.title}</font></b>
              <br/>
              <font size="+5">({painting.yearCompleted})</font>
              <br />
              <font size="+5">by</font>
              <br />
              <b><font size="+5">{painting.artistName}</font></b>
              <br />
              <br/>
              <br/>
              <b>Medium: </b>{painting.medium}
              <br/>
              <br/>
              <b>Style:</b> {painting.style}
              <br/>
              <br/>
              <b>Description:</b> {painting.backstory}
              </center>
            </div>
          </div>
        );
      })}
    </div>
  );
  
};

export default PaintingGrid;