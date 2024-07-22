import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './pages/BoardList';
import Join from './pages/Join';
import Login from './pages/Login';

function App() {
  return (
    <div className="App">

      <Routes>
        <Route path='/' element={<BoardList />}/>
        <Route path='/join' element={<Join />}></Route>
        <Route path='/login' element={<Login />}/>
      </Routes>

    </div>
  );
}

export default App;
