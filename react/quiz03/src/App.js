import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import './App.css';

const Box = () => {
  return (
    <div className='Box'>
      <div>
      <Link to="/Red">Red</Link>
      </div>
      <div>
      <Link to="/Green">Green</Link>
      </div>
      <div>
      <Link to="/Blue">Blue</Link>
      </div>
    </div>

  );
}

const Red = () => {
  return (
    <div className="Red"></div>
  );
}

const Green = () => {
  return (
    <div className="Green"></div>
  );
}

const Blue = () => {
  return (
    <div className="Blue"></div>
  );
}

function App() {
  return (
    <div className='container'>
    <BrowserRouter>
      <Box></Box>
      <Routes>
        <Route path="/Red" element={<Red />} />
        <Route path="/Green" element={<Green />} />
        <Route path="/Blue" element={<Blue />} />
      </Routes>
    </BrowserRouter>
    </div>
  );
}

export default App;
