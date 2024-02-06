import { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';

function Exhibitions() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel activeIndex={index} onSelect={handleSelect}>
      <Carousel.Item>
        <img src="/painting1.jpg" className="d-block w-100px" style={{ height: '900px' }} alt="Photo 1" />
        <Carousel.Caption>
          <h3>Nature Exhibition</h3>
          <p></p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img src="/painting2.jpg" className="d-block w-100px" style={{ height: '900px' }} alt="Photo 3" />
        <Carousel.Caption>
          <h3>Abstract Art</h3>
          <p></p>
        </Carousel.Caption>
      </Carousel.Item>
      <Carousel.Item>
        <img src="/painting3.jpg" className="d-block w-100px" style={{ height: '900px' }} alt="Photo 4" />
        <Carousel.Caption>
          <h3>Art and History</h3>
          <p></p>
        </Carousel.Caption>
      </Carousel.Item>
    </Carousel>
  );
}
export default Exhibitions;