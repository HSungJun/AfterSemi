import logo from './logo.svg';
import './App.css';
import { Button, Card, CardBody, CardSubtitle, CardText, CardTitle, Col, Container, Row } from 'reactstrap';
import TopNavi from './Components/TopNavi';
import Main from './Pages/Main/main';
 
function App() {
  return (
    <>
      <TopNavi></TopNavi>
      <Container style={{ marginTop: "58px" }}>
        <Main></Main>
      </Container>
    </>
  );
}

export default App;
