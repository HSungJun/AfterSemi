import './App.css';
import Header from './pages/main/header/Header';
import Navi from './pages/main/navi/Navi';
import Body from './pages/main/body/body';
import Footer from './pages/main/footer/Footer';

function App() {
  return (
    <div className="container">
      <Header></Header>
      <Navi></Navi>
      <Body></Body>
      <Footer></Footer>
    </div>
  );
}

export default App;