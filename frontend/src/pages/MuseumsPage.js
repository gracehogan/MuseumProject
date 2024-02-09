import '../resources/css/MuseumsPage.css';
import '../resources/css/BookingPage.css';
import { Link } from 'react-router-dom';
import '../resources/css/Menu.css';
import PaintingGrid from '../components/PaintingGrid';
import SculptureGrid from '../components/SculptureGrid';
import PaintingSortByDropdown from '../components/PaintingSortByDropdown';
import SculptureSortByDropdown from '../components/SculptureSortByDropdown';
import { PaintingButtonProvider } from '../components/PaintingButtonContext';
import { SculptureButtonProvider } from '../components/SculptureButtonContext';
import PaintingSearchBar from '../components/PaintingSearchBar';
import { PaintingSearchBarProvider } from '../components/PaintingSearchBarContext';
import { SculptureSearchBarProvider } from '../components/SculptureSearchBarContext';
import SculptureSearchBar from '../components/SculptureSearchBar';

const MuseumPage = () => {

    return (
    <div>
      <nav aria-label="breadcrumb">
          <ol className="breadcrumb">
              <li className="breadcrumb-item"><Link to="/">Home</Link></li>
              <li className="breadcrumb-item"><Link to="/museums">Museums</Link></li>
          </ol>
      </nav>

      <h2 className="page-heading margin-align">Museums</h2>
      <section className="margin-align flex-page">
        
        <section className="pages-museum tile-margin">
          <p className="sub-heading">Pages</p>
          <img src='/pages-tile-image.jpg' alt='pages-image' height="350px" width="300px"/>
          <div className="arrow-link">
                <Link to="/visit#visit-page">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
          </div>
          <br />
          <div className="arrow-link">
              <Link to="/exhibitions">
                  See upcoming exhibitions<i className="fas fa-arrow-right"></i>
              </Link>
          </div>
        </section>

        <section className="muse-museum">
          <p className="sub-heading">Muse</p>
          <img src='/muse-tile-image-second.jpg' alt='muse-image' height="350px" width="300px"/>
          <div className="arrow-link">
                <Link to="/visit#visit-page">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
          </div>
          <br />
          <div className="arrow-link">
              <Link to="/exhibitions">
                  See upcoming exhibitions<i className="fas fa-arrow-right"></i>
              </Link>
          </div>
        </section>

        <section className="xplore-museum">
          <p className="sub-heading">Xplore</p>
          <img src='/xplore-tile-image.jpg' alt='xplore-image' height="350px" width="300px"/>
          <div className="arrow-link">
                <Link to="/visit#visit-page">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
          </div>
          <br />
          <div className="arrow-link">
              <Link to="/exhibitions">
                  See upcoming exhibitions<i className="fas fa-arrow-right"></i>
              </Link>
          </div>
        </section>

        <section className="horizons-museum">
          <p className="sub-heading">Horizons</p>
          <img src='/horizons-tile-image-second.jpg' alt='horizons-image' height="350px" width="300px"/>
          <div className="arrow-link">
                <Link to="/visit#visit-page">
                    Plan a visit<i className="fas fa-arrow-right"></i>
                </Link>
          </div>
          <br />
          <div className="arrow-link">
              <Link to="/exhibitions">
                  See upcoming exhibitions<i className="fas fa-arrow-right"></i>
              </Link>
          </div>
        </section>
      </section>
      
      <PaintingSearchBarProvider>
          <PaintingButtonProvider> 
           <div class="flexbox-container">
              <h2 className="page-heading margin-align">Our Paintings</h2>
              <br/>
              <PaintingSortByDropdown/>
              <br/>
              <PaintingSearchBar/>
            <PaintingGrid/>
            </div>
          </PaintingButtonProvider>
      </PaintingSearchBarProvider>
        
        <SculptureSearchBarProvider>
          <SculptureButtonProvider>
          <div class="flexbox-container">
            <h2 className="page-heading margin-align">Our Sculptures</h2>
            <br/>
            <SculptureSortByDropdown/> 
            <br/>
            <SculptureSearchBar/>
            <SculptureGrid/>
            <br/>
          </div>
          </SculptureButtonProvider>
        </SculptureSearchBarProvider>
      <br/>
    </div>
  );
};

export default MuseumPage;