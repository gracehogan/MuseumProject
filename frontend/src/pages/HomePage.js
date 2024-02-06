import '../resources/css/Home'

const HomePage = () => {
    return (
      <div>
        <video id="background-video" autoPlay loop muted>
          <source src="https://api-www.louvre.fr/sites/default/files/videos/video_1_1_1280/video.mp4" type="video/mp4" /> 
        </video>
      </div>
    );
  };

  export default HomePage;