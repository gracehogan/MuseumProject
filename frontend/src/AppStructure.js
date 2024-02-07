import Header from "./components/Header";
import Footer from "./components/Footer";
import Menu from "./components/Menu";
import HomePage from "./pages/HomePage";
import MuseumsPage from "./pages/MuseumsPage";
import VisitPage from "./pages/VisitPage";
import BookingPage from "./pages/BookingPage"
import 'bootstrap/dist/css/bootstrap.min.css';
import './resources/css/AppStructure.css'
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom"; 


function Home() {
  return <HomePage />;
};

function Museums() {
  return <MuseumsPage />;
};

function Visit() {
  return <VisitPage />;
};

// function Muse() {
//   return <MuseMuseum />;
// };

// function Pages() {
//   return <PagesMuseum />;
// };

// function Contact() {
//   return <ContactPage />;
// };

// function FAQ() {
//   return <FAQPage />;
// };


// Remember to add imports for Muse & Pages museum 
// and add the routes in the return statement below also

const AppStructure = () => {
    return (
      <div className="min-vh-100" id="page-container">
        <Header />
        <Menu />
        <div className="background" id="content-wrap">
          <div>
          <Routes>
            <Route path="/home" element={<Home/>} />
            <Route path="/museums" element={<Museums/>} />
            <Route path="/visit" element={<VisitPage />} />
            <Route path="/booking" element={<BookingPage />} />
          </Routes>
          </div>
        </div>
        <Footer />
      </div>
    );
  };

  export default AppStructure;