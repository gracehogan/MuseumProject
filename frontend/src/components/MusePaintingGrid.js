import React, { useEffect, useState } from "react";
import '../resources/css/ImageGrid.css';

const MusePaintingGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [paintingData, setPaintingData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/paintings/getByMuseum/muse");
        const data = await response.json();
        setPaintingData(data);
      } catch (error) {
        console.error("Error fetching painting data:", error);
      }
    };
    fetchData();
  }, []);

  return (
    <div className="image-grid">
      {paintingData && paintingData.map((painting, index) => {
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

export default MusePaintingGrid;