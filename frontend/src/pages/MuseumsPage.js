import '../resources/css/MuseumsPage.css';
import '../resources/css/BookingPage.css';

const MuseumPage = () => {

    return (
    <div>
      <h2 className="page-heading margin-align">Museums</h2>
      <section className="margin-align">
        <section className="pages-museum">
          {/* Pages column here */}
        </section>
        <section className="muse-museum">
          {/* Muse column here */}
        </section>
        <section className="xplore-museum">
          {/* Xplore column here */}
        </section>
        <section className="horizons-museum">
          {/* Horizon column here */}
        </section>
      </section>
    </div>
  );
};

export default MuseumPage;