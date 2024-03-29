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
          </Routes>
          </div>
        </div>
        </div>
        <Footer />
      </div>
    );
  };

  export default AppStructure;