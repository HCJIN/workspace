import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './pages/BoardList';
import Join from './pages/Join';
import Login from './pages/Login';
import InBoard from './pages/InBoard';

function App() {
  return (
    <div className="App">

      <Routes>
        <Route path='/' element={<BoardList />}/>
        <Route path='/join' element={<Join />}></Route>
        <Route path='/login' element={<Login />}/>
        <Route path='/inBoard' element={<InBoard />}/>
      </Routes>

    </div>
  );
}

export default App;
