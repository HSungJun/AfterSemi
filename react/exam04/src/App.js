import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Link, Route, Routes,Outlet } from 'react-router-dom';

const Index = () => {
  return (
    <div className='container'>
      <table border="1" align='center'>
        <thead>
          <tr>
            <th colSpan={3}>Index</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>
              <Link to="/Input">toInput</Link>
            </td>
            <td>
              <Link to="/Output">toOutput</Link>
            </td>
            <td>
              <Link to="/sub">toSub</Link>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

const Input = () => {
  return (
    <div className='container'>
      <table border={1} align='center'>
        <thead>
          <tr>
            <th>Input Message</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><input type='text' placeholder='Input writer'></input>
            </td>
          </tr>
          <tr>
            <td><input type='text' placeholder='Input Message'></input>
            </td>
          </tr>
          <tr>
            <td style={{ display: "flex", justifyContent: "space-evenly" }}>
              <button onClick={() => { console.log("write Click!") }}>write</button>
              <Link to="/"><button>back</button></Link>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

const Output = () => {

  const messages = [
    { seq: 1, writer: "Jane", message: "React Router" },
    { seq: 2, writer: "Ryan", message: "React Practice" },
    { seq: 3, writer: "Tom", message: "Practice Hard" }

  ]

  const result = messages.map((e, index) => {
    return (<tr key={e.seq}><td>{e.seq}</td><td>{e.writer}</td><td>{e.message}</td></tr>);
  });

  return (
    <div className='container'>
      <table border={1} align="center">
        <thead>
          <tr>
            <th colSpan={3}>
              Message List
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th>Seq</th>
            <th>Writer</th>
            <th>Message</th>
          </tr>
          {result}
          <tr>
            <td align='center' colSpan={3}>
              <Link to="/"><button>back</button></Link>
            </td>
          </tr>
        </tbody>

      </table>
    </div>
  );
}


const Sub =() => {
  return(
    <div className='container'>
      <table border={1} align="center">
        <thead>
          <tr>
            <th colSpan={3}>Sub Page</th>
          </tr>
          <tr>
            <th>
             <Link to="/sub/red">Red</Link>
            </th>
            <th>
             <Link to="/sub/Green">Green</Link>
            </th>
            <th>
             <Link to="/sub/Blue">Blue</Link>
            </th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td colSpan={3} width={200} height={200}>
              {/* <Routes>
                <Route path="red" element={<Red/>}/>
                <Route path="green" element={<Green/>}/>
                <Route path="blue" element={<Blue/>}/>
              </Routes>  */}
              <Outlet/>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

const Red = () => {
  return (
    <div className="Container" style={{width:"100%",height:"100%",backgroundColor:"pink"}}>
      Red
    </div>
  );
}

const Green = () => {
  return (
    <div className="Container" style={{width:"100%",height:"100%",backgroundColor:"green"}}>
      Green
    </div>
  );
}

const Blue = () => {
  return (
    <div className="Container" style={{width:"100%",height:"100%",backgroundColor:"blue"}}>
      Blue
    </div>
  );
}


function App() {
  return (
    <BrowserRouter>
      <Index></Index>
        <Routes>
          <Route path="/" element={<Index/>} />
          <Route path="/input" element={<Input/>} />
          <Route path="/output" element={<Output/>} />
          <Route path="/sub/*" element={<Sub/>}> 
            <Route path="red" element={<Red/>}/>
            <Route path="green" element={<Green/>}/>
            <Route path="blue" element={<Blue/>}/>
          </Route>
          <Route path="*" element={<Index/>} />
        </Routes>
    </BrowserRouter>
  );
}

export default App;
