import './App.css';
import image from './assets/IMG.jpg'

const ULBox = () => {
  return(
    <div className="ulBox">
      <ul>
        <li>Angular</li>
        <li>React</li>
        <li>Vue</li>
      </ul>
    </div>
  );
}


// Functional Component 제작
/*function ULBox() {
  return (
    <div className="ulBox">
      <ul>
        <li>Angular</li>
        <li>React</li>
        <li>Vue</li>
      </ul>
    </div>
  );
}*/

function TableBox(){
  return(
    <div className="tableBox">
        <table>
          <thead>
            <tr>
              <th>Seq</th>
              <th>writer</th>
              <th>Message</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1001</td>
              <td>Tom</td>
              <td>React</td>
            </tr>
            <tr>
              <td>1002</td>
              <td>Nick</td>
              <td>React Practice</td>
            </tr>
          </tbody>
        </table>
      </div>
  );
}

function ImgBox(){
  return(
    <div className="imageBox">
        <img src={image}></img>
      </div>
  );
}

function App() {
  return (
    <div className="container">
      <ULBox></ULBox>
      <TableBox></TableBox>
      <ImgBox></ImgBox>
      
      </div>
  );
}

export default App;
