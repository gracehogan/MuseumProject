import './App.css';
import SculptureGrid from './components/SculptureGrid';
import ImageGrid from './components/PaintingGrid';

function App() {
  return (
    <div className="App">
      <ImageGrid/>
      <br />
      <SculptureGrid/>
    </div>
  );
}

export default App;

