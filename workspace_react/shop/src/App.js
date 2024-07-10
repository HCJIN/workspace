import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import data from './data';
import ItemList from './ItemList';
import axios from 'axios';

function App() {

  // const item_list = data;
  let item_list = [];

  // axios.get('/test1')
  //     .then((response)=>{
  //       console.log(response.data)
  //     });

  // axios.get('/test2')
  //     .then((response)=>{
  //       console.log(response.data)
  //     })

  // let arr = [];
  // axios.get('/test3')
  //     .then((response)=>{
  //       // console.log(response.data)
  //       arr = response.data
  //       console.log(arr);
  //     })

  axios.get('/test4')
      .then((response)=>{
        console.log(response.data)
        item_list = response.data;
      })

  // axios.get('/test5')
  //     .then((response)=>{
  //       console.log(response.data)
  //     })


  return (
    <div className="App">
      <div className='header'>
        Book Shop
      </div>
      <div className='banner'>
        <img src={process.env.PUBLIC_URL + '/header.jpg'}/>
      </div>
      <ItemList item_list={item_list}/>

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
    <div>sbs</div>
  )
}

export default App;
