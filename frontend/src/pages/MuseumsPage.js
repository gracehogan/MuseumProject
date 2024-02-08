import '../resources/css/MuseumsPage.css';
import '../resources/css/BookingPage.css';
import '../resources/css/Menu.css';
import PaintingGrid from '../components/PaintingGrid';
import SculptureGrid from '../components/SculptureGrid';
import PaintingSortByDropdown from '../components/PaintingSortByDropdown';
import SculptureSortByDropdown from '../components/SculptureSortByDropdown';
import { PaintingButtonProvider } from '../components/PaintingButtonContext';
import { SculptureButtonProvider } from '../components/SculptureButtonContext';
import PaintingSearchBar from '../components/PaintingSearchBar';
import { PaintingSearchBarProvider } from '../components/PaintingSearchBarContext';

const MuseumPage = () => {

    return (
    <div>
      <h2 className="page-heading margin-align">Museums</h2>
      <section className="margin-align flex-page">
        
        <section className="pages-museum tile-margin">
          <p className="sub-heading">Pages</p>
          <img src='/pages-tile-image.jpg' alt='pages-image' height="350px" width="300px"/>
        </section>

        <section className="muse-museum">
          <p className="sub-heading">Muse</p>
          <img src='/muse-tile-image-second.jpg' alt='muse-image' height="350px" width="300px"/>
        </section>

        <section className="xplore-museum">
          <p className="sub-heading">Xplore</p>
          <img src='/xplore-tile-image.jpg' alt='xplore-image' height="350px" width="300px"/>
        </section>

        <section className="horizons-museum">
          <p className="sub-heading">Horizons</p>
          <img src='/horizons-tile-image-second.jpg' alt='horizons-image' height="350px" width="300px"/>
        </section>
      </section>

        <div>
        <PaintingSearchBarProvider>
          <PaintingButtonProvider> 
          <PaintingSearchBar/>
            <h2 className="page-heading margin-align">Our Paintings</h2>
            <PaintingSortByDropdown/>
            <PaintingGrid/>
          </PaintingButtonProvider>
          </PaintingSearchBarProvider>

          <SculptureButtonProvider>
            <h2 className="page-heading margin-align">Our Sculptures</h2>
            <SculptureSortByDropdown/> 
            <SculptureGrid/>
          </SculptureButtonProvider>
        </div>
      <br/>
    </div>
  );
};

export default MuseumPage;