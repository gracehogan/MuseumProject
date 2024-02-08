import '../resources/css/MuseumsPage.css';
import '../resources/css/BookingPage.css';

const MuseumPage = () => {

    return (
    <div>
      <h2 className="page-heading margin-align">Museums</h2>
      <section className="margin-align flex-page">
        
        <section className="pages-museum tile-margin">
          <p className="sub-heading">Pages</p>
        </section>

        <section className="muse-museum">
          <p className="sub-heading">Muse</p>
        </section>

        <section className="xplore-museum">
          <p className="sub-heading">Xplore</p>
        </section>

        <section className="horizons-museum">
          <p className="sub-heading">Horizons</p>
        </section>

      </section>
    </div>
  );
};

export default MuseumPage;