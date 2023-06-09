import styled from 'styled-components';
import './App.css';
import { MyButton,MyDiv } from './components/styled';


const arr1 = ["Apple","Orange","Mango"];
// arr.push("Grape");
const arr2 = [...arr1,"Grape"];
console.log(arr2);

const obj1 = {name:"TOM", phone:"01012341234"}; // JSON = JAVASCRIPT의 객체
const obj2 = {...obj1,adress:"Korea",name:"Ryan"};
console.log(obj2);

// const fruit1 = arr1[0];
// const fruit2 = arr1[2];
//destruct
const [a,b,c] = arr1;
console.log(`${a} ${b} ${c}`);

const {name, phone} = obj1;
console.log(`${name} ${phone}`)

//MAP 함수 (forEach와 비슷)
arr1.map(function(e){

});

//Arrow function = 콜백 function
arr1.map((e,index)=>{console.log(`${e} : ${index}`)});

const result = arr1.map((e, index)=>{
  return <div>{e}</div>;
});
console.log(result);


function App(){
  return(
    <div className='container'>
      <MyButton>임의의 Button</MyButton>
      <MyDiv>임의의 Div</MyDiv>
      {result}
    </div>
  );
}

export default App;
// 하단의 export default 는 대표 객체 > impory 시 중괗호 x 
// const export 시에는 imoport 시 중괄호