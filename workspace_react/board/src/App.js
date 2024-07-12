import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Main from './main.js'
import data from './data';
import Detail from './detail';
import { useState } from 'react';
import Write_form from './Write_form.js';
import InputTest from './InputTest.js';

function App() {
  const [board_list, setBoard_list] = useState(data);

  return (
    <div className="App">
      <Routes>
        <Route path='/' element={<Main board_list={board_list} ></Main>}></Route>
        <Route path='/detail/:id' element={<Detail  board_list={board_list} setBoard_list={setBoard_list} ></Detail>}></Route>
        <Route path='/write_form' element={<Write_form board_list={board_list} setBoard_list={setBoard_list}></Write_form>}></Route>
        <Route path='/test' element={<InputTest></InputTest>}></Route>
      </Routes>
      
    </div>
    
  );
}

export default App;
