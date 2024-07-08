import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import List from './List';
import Add from './Add';

function App() {

  const [list, setList] = useState([]);

  function remove(index){
    list.splice(index,1);
    setList([...list])
  }


  return (
    <div className="App">
      <h2>Shopping List</h2>
      <List list={list} setList={setList} remove={remove}></List>
      <Add 
        list = {list}
        setList = {setList}
      > 
      </Add>
    </div>
  );
}


export default App;
