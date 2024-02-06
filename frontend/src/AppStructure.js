import Header from "./components/Header";
import Footer from "./components/Footer";
import Menu from "./components/Menu";
import HomePage from "./pages/HomePage";
import MuseumsPage from "./pages/MuseumsPage";
import VisitPage from "./pages/VisitPage";
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

const AppStructure = () => {
    return (
      <div className="min-vh-100 page-container">
        <Header />
        <Menu />
        <div className='content-wrap'>
          <div>
          <Routes>
            <Route path="/home" element={<Home/>} />
            <Route path="/museums" element={<Museums/>} />
            <Route path="/visit-us" element={<Visit/>} />
          </Routes>
          </div>
        </div>
        <Footer />
      </div>
    );
  };

  export default AppStructure;