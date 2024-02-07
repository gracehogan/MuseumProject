import React, { useEffect, useState } from "react";
import './ImageGrid.css';

const PaintingGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [paintingData, setPaintingData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/paintings");
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
              Artist: {painting.artistName}
              <br />
              Title: {painting.title}
              <br/>
              Year Completed: {painting.yearCompleted}
              <br/>
              Medium: {painting.medium}
              <br/>
              Style: {painting.style}
              <br/>
              Backstory: {painting.backstory}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default PaintingGrid;