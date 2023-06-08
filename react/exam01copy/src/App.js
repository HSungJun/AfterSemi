import styled from 'styled-components';
import './App.css';
import { MyButton,MyDiv } from './components/styled';




function App(){
  return(
    <div className='container'>
      <MyButton>임의의 Button</MyButton>
      <MyDiv>임의의 Div</MyDiv>
    </div>
  );
}

export default App;