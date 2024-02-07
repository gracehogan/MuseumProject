import React, { useEffect, useState } from "react";
import './ImageGrid.css';

const SculptureGrid = () => {
  const [hoveredIndex, setHoveredIndex] = useState(null);
  const [paintingData, setPaintingData] = useState(null);
  const [artistData, setArtistData] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch("http://localhost:8080/sculptures");
        const data = await response.json();
        setPaintingData(data);
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
      {paintingData && artistData && paintingData.map((painting, index) => {
        // Find the corresponding artist for the painting
        const artist = artistData.find(artist => artist.id === painting.artistId);
        return (
          <div
            key={index}
            className={`image-container ${hoveredIndex === index ? 'hovered' : ''}`}
            onMouseEnter={() => setHoveredIndex(index)}
            onMouseLeave={() => setHoveredIndex(null)}
          >
            <img src={painting.src} alt="Painting" />
            <div className="image-text">
                Artist: {artist ? artist.name : 'Unknown'}
              <br />
              Title: {painting.title}
              <br/>
              Year Completed: {painting.yearCompleted}
              <br/>
              Medium: {painting.medium}
              <br/>
              Backstory: {painting.backstory}
            </div>
          </div>
        );
      })}
    </div>
  );
};

export default SculptureGrid;