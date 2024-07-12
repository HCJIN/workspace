import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import data from './data';
import ItemList from './ItemList';
import axios from 'axios';
import { Link, Route, Routes } from 'react-router-dom';
import Detail from './Detail';

function App() {

  const item_list = data;

  return (
    <div className="App">
      <div className='header'>
        <Link to="/">Book Shop</Link>
        <Link to="/list">상품목록</Link>
        <Link to="/detail">상품상세</Link>
      </div>
      <div className='banner'>
        <img src={process.env.PUBLIC_URL + '/header.jpg'}/>
      </div>

      {/* 이동할 수 있는 페이지의 url들 */}
      <Routes>
        <Route path='/' element={<div>메인페이지</div>}/>
        <Route path='/list' element={<ItemList item_list={item_list}/>}/>
        <Route path='/detail/:id' element={<Detail item={item_list}/>}/>
        <Route path='*' element={<div>잘못된 페이지입니다.</div>}/>
      </Routes>

      <Test name={'홍길동'} age={20} />

    </div>
  );
}

const Test = ({name, age}) => {
  // 매개변수로 props를 받았을때
  // console.log(props)
  // const {name, age} = props;
  // console.log(name, age)
  // 매개변수로 {name, age}로 받았을때랑 동일

  return(
    <div></div>
  )
}

export default App;
