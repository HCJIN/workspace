import { useState } from 'react';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import data from './data';
import Main from './Main';
import Btn from './Btn';
import Detail from './Detail';


function App() {

  const [list, setList] = useState(data);

  return (
    <div className="App">

      <Btn />
      <Routes>
        <Route path='/' element={<Main list={list} setList={setList}/>} ></Route>
        <Route path='/detail/:stuNum' element={<Detail list={list} setList={setList}/>}></Route>
      </Routes>

    </div>
  );
}

export default App;
