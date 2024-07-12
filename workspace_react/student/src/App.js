import { useState } from 'react';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import data from './data';


function App() {

  const [list, setList] = useState(data);
  console.log(list)

  return (
    <div className="App">

      <Routes>
        <Route path='/' ></Route>

      </Routes>

    </div>
  );
}

export default App;
