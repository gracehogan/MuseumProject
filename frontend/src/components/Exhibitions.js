import { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';
import '../resources/css/Exhibition.css';

function Exhibitions() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel activeIndex={index} onSelect={handleSelect}>
      <Carousel.Item>
        <img src="/painting5.jpg" className="d-block w-100 carousel-image" alt="Photo 1" />
        <Carousel.Caption>
          <h3>Nature Exhibition</h3>
          <p>Explore art and nature in this exclusive exhibition at the PAGES Museum.</p>
          <p>Date: 10th Feb 2024</p>
          <p>For bookings, please go to the bookings page.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img src="/painting6.jpg" className="d-block w-100 carousel-image" alt="Photo 3" />
        <Carousel.Caption>
          <h3>Abstract Art</h3>
          <p>Explore abstract art as never before at the Muse Museum.</p>
          <p>Date: 12th Feb 2024</p>
          <p>For bookings, please go to the bookings page.</p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img src="/painting7.jpg" className="d-block w-100 carousel-image" alt="Photo 4" />
        <Carousel.Caption>
          <h3>Art and History</h3>
          <p>Explore art and history at the PAGES Museum.</p>
          <p>Date: 16th Feb 2024</p>
          <p>For bookings, please go to the bookings page.</p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}

export default Exhibitions;
