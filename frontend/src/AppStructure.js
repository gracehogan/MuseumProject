import 'bootstrap/dist/css/bootstrap.min.css';
import './resources/css/AppStructure.css'
import { BrowserRouter as Router, Route, Link, Routes } from "react-router-dom"; 
import Header from "./components/Header";
import Footer from "./components/Footer";
import Menu from "./components/Menu";
import Exhibitions from "./components/Exhibitions";
import HomePage from "./pages/HomePage";
import MuseumsPage from "./pages/MuseumsPage";
import VisitPage from "./pages/VisitPage";
import BookingPage from "./pages/BookingPage"
import PagesMuseum from "./pages/Pages";
import MuseMuseum from "./pages/Muse";
import FAQPage from "./pages/FAQPage";
import ContactPage from "./pages/ContactPage";
import AboutUs from "./pages/AboutUs";
import SpanishContactUs from "./pages/SpanishContactUs";
import FrenchContactUs from "./pages/FrenchContactUs";
import CatalanContactUs from "./pages/CatalanContactUs";
import HindiContactUs from "./pages/HindiContactUs";
import i18n from './i18n';
import { withNamespaces } from 'react-i18next';


function Home() {
  return <HomePage />;
};

function Museums() {
  return <MuseumsPage />;
};

function Visit() {
  return <VisitPage />;
};

function Exhibition() {
  return <Exhibitions />;
};

function Muse() {
  return <MuseMuseum />;
};

function Pages() {
  return <PagesMuseum/>;
};

function Contact() {
  return <ContactPage />;
};

function FAQ() {
  return <FAQPage/>;
};

function About() {
  return <AboutUs/>;
}

function Booking() {
  return <BookingPage/>;
};

// function SpanishContact() {
//   return <SpanishContactUs />;
// }

// function FrenchContact() {
//   return <FrenchContactUs />;
// }

// function CatalanContact() {
//   return <CatalanContactUs />;
// }

// function HindiContact() {
//   return <HindiContactUs />;
// }


const AppStructure = () => {
    return (
      <div id="page-container">
        <Header />
        <div>
        <Menu />
        <div className="background" id="content-wrap">
          <div>
          <Routes>
            <Route path="/" element={<Home/>} />
            <Route path="/museums" element={<Museums/>} />
            <Route path="/visit" element={<Visit />} />
            <Route path="/museum/Pages" element={<Pages />} />
            <Route path="/museum/Muse" element={<Muse />} />
            <Route path="/help/faq" element={<FAQ />} />
            <Route path="/exhibitions" element={<Exhibition />} />
            <Route path="//help/contact-us" element={<Contact />} />
            <Route path="//help/about-us" element={<About />} />
            <Route path="/book" element={<Booking />} />
            <Route path="/contact-us" element={<ContactPage />} />
            {/* <Route path="/contact-us/spanish" element={<SpanishContactUs />} />
            <Route path="/contact-us/french" element={<FrenchContactUs />} />
            <Route path="/contact-us/catalan" element={<CatalanContactUs />} />
            <Route path="/contact-us/hindi" element={<HindiContactUs />} /> */}
          </Routes>
          </div>
        </div>
        </div>
        <Footer />
      </div>
    );
  };

  export default AppStructure;