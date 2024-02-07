import './App.css';
import SculptureGrid from './components/SculptureGrid';
import PaintingGrid from './components/PaintingGrid';

function App() {
  return (
    <div className="App">
      <PaintingGrid/>
      <br />
      <SculptureGrid/>
    </div>
  );
}

export default App;

