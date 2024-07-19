import logo from './logo.svg';
import './App.css';
import './reset.css';
import Header from './Header.js';
import { Route, Routes } from 'react-router-dom';
import ItemList from './ItemList.js';
import Detail from './Detail.js';
import Insert from './Insert.js';
import Order from './Order.js';

function App() {
  return (
    <div className="App">
      <Header />
      <Routes>
        {/* 상품정보 페이지 */}
        <Route path='/' element={<ItemList />}/>
        {/* 상세정보 페이지 */}
        <Route path='/detail/:itemNum' element={<Detail />} />
        {/* 상품등록 페이지 */}
        <Route path='/insert' element={<Insert />}/>
        {/* 주문하기 페이지 */}
        <Route path='/order' element={<Order />}/>
        {/* 주문목록 페이지 */}
        <Route path='/orderList' element={<div>주문목록</div>}/>
      </Routes>
    </div>
  );
}

export default App;
