import React, { useEffect, useState } from "react";
import './ImageGrid.css';

const SculptureGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [sculptureData, setSculptureData] = useState(null);
  const [artistData, setArtistData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/sculptures");
        const data = await response.json();
        setSculptureData(data);
      } catch (error) {
        console.error("Error fetching painting data:", error);
      }
    };
    fetchData();
  }, []);

  useEffect(() => {
    const fetchArtistData = async () => {
      try {
        const response = await fetch("http://localhost:8080/artists");
        const data = await response.json();
        setArtistData(data);
      } catch (error) {
        console.error("Error fetching artist data:", error);
      }
    };
    fetchArtistData();
  }, []);

return (
    <div className="image-grid">
      {sculptureData && artistData && sculptureData.map((sculpture, index) => {
        // Find the corresponding artist for the sculpture
        const artist = artistData.find(artist => artist.id === sculpture.artistId);
        return (
          <div
            key={index}
            className={`image-container ${hoveredIndex === index ? 'hovered' : ''}`}
            onMouseEnter={() => setHoveredIndex(index)}
            onMouseLeave={() => setHoveredIndex(null)}
          >
            <img src={sculpture.src} alt="Sculpture" />
            <div className="image-text">
                Artist: {artist ? artist.name : 'Unknown'}
              <br />
              Title: {sculpture.title}
              <br/>
              Year Completed: {sculpture.yearCompleted}
              <br/>
              Medium: {sculpture.medium}
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