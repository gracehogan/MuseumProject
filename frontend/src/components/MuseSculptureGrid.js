import React, { useEffect, useState } from "react";
import '../resources/css/ImageGrid.css';

const MuseSculptureGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [sculptureData, setSculptureData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/sculptures/getByMuseum/muse");
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

export default MuseSculptureGrid;