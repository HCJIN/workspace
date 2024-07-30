import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes } from 'react-router-dom';
import Header from './page/Header';
import Management from './page/Management';
import Home from './page/Home';
import SalesInfo from './page/SalesInfo';
import SalesList from './page/SalesList';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <Routes>
        <Route path='/' element={<Home/>} />
        <Route path='/management' element={<Management />} />
        <Route path='/salesInfo' element={<SalesInfo />} />
        <Route path='/salesList' element={<SalesList />} />
      </Routes>
    </div>
  );
}

export default App;
