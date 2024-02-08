import React, { useEffect, useState } from "react";
import '../resources/css/ImageGrid.css';

const SculptureGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [sculptureData, setSculptureData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/sculptures");
        const data = await response.json();
        setSculptureData(data);
      } catch (error) {
        console.error("Error fetching sculpture data:", error);
      }
    };
    fetchData();
  }, []);

return (
    <div className="image-grid">
      {sculptureData && sculptureData.map((sculpture, index) => {
        return (
          <div
            key={index}
            className={`image-container ${hoveredIndex === index ? 'hovered' : ''}`}
            onMouseEnter={() => setHoveredIndex(index)}
            onMouseLeave={() => setHoveredIndex(null)}
          >
            <img src={sculpture.src} alt="Sculpture" />
            <div className="image-text">
              Artist: {sculpture.artistName}
              <br />
              Title: {sculpture.title}
              <br/>
              Year Completed: {sculpture.yearCompleted}
              <br/>
              Medium: {sculpture.medium}
              <br/>
              Style: {sculpture.style}
              <br/>
              Backstory: {sculpture.backstory}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default SculptureGrid;