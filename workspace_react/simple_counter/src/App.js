import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {

  let [cnt, setCnt] = useState(0);

  function changeCount(num){
    console.log(num);
    setCnt(cnt + Number(num));
  }

  return (
    <div className="App">
      <h2>Simple Counter</h2>
      <Viewer 
        cnt = {cnt}>
      </Viewer>
      <Controller 
        setCnt = {setCnt}
        cnt = {cnt}
        changeCount = {changeCount}
      >
      </Controller>
    </div>
  );
}

function Viewer(props){
  return(
    <div className='viewer'>
      <p>현재 카운터</p>
      <span>{props.cnt}</span>
    </div>
  );
}

function Controller(props){
  return(
    <div className='controller'>
      <button type='button' id='btn1' onClick={() => {props.setCnt(props.cnt - 10)}}>-10</button>
      <button type='button' id='btn2' onClick={() => props.setCnt(props.cnt - 1)}>-1</button>
      <button type='button' id='btn3'  value={1} onClick={(e) => {
        props.changeCount(e.target.value);
      }}>+1</button>
      <button type='button' id='btn4' value={10} onClick={(e) => {
        props.changeCount(e.target.value);
      }}>+10</button>
    </div>
  );
}

export default App;
