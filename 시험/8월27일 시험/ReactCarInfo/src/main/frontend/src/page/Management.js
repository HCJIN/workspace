import React, { useEffect, useState } from 'react'
import '../management.css';
import axios from 'axios';

const Management = () => {

  //자바에서 가져온 데이터가 들어갈 배열 생성
  const [carList, setCarList] = useState([]);
  //입력값이 들어갈 객체 생성
  const [joinCar, setJoinCar] = useState({
    brand : '현대',
    modelName : '',
    price : ''
  });

  //자바 데이터 받아오기
  useEffect(()=>{
    axios.get('/info/carList')
    .then((res)=>{
      console.log(res.data)
      setCarList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[joinCar])

  //입력한 데이터를 생성한 객체에 입력
  function onCahnge(e){
    setJoinCar({
      ...joinCar,
      [e.target.name] : e.target.value
    })
  }

  //생성한 객체 자바 전달
  function goJoin(){
    const model = document.querySelector('#model').value;
    const price = document.querySelector('#price').value;
    if(model == '' || price == ''){
      alert('빈 값이 있습니다.')
      return
    }else{
      axios
      .post('/info/insert',joinCar)
      .then((res)=>{
        alert('등록이 완료되었습니다.')
        setJoinCar({
          ...joinCar,
          brand : '현대',
          modelName : '',
          price : ''
        })
      })
      .catch((error)=>{
        console.log(error)
      })
    }
  }

  return (
    <div className='management-div'>
      <div className='management-top'>
        <table className='top-table'>
          <thead>
            <tr>
              <td>
                <p>-차량등록</p>
              </td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><p>제조사</p></td>
              <td>
                <select name='brand' value={joinCar.brand} onChange={(e)=>{onCahnge(e)}}>
                  <option name='hyundai'>현대</option>
                  <option name='kia' >기아</option>
                  <option name='kg' >쌍용</option>
                </select>
              </td>
              <td>모델명</td>
              <td>
                <input type='text' id="model" name='modelName' value={joinCar.modelName} onChange={(e)=>{onCahnge(e)}}></input>
              </td>
              <td>차량가격</td>
              <td>
                <input type='text' id="price" name='price' value={joinCar.price} onChange={(e)=>{onCahnge(e)}}></input>
              </td>
            </tr>
          </tbody>
        </table>
        <div className='btn'>
          <button type='button' onClick={()=>{goJoin()}}>등록</button>
        </div>  
      </div>  
      <div className='management-bottom'>
        <table className='bottom-table'>
          <colgroup>
            <col width='20%'></col>
            <col width='40%'></col>
            <col width='40%'></col>
          </colgroup>
          <thead>
            <tr>
              <td>
                <p>-차량목록</p>
              </td>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td><p>모델번호</p></td>
              <td><p>모델명</p></td>
              <td><p>제조사</p></td>
            </tr>
            {
              carList.map((car, i)=>{
                return(
                  <tr key={i} className='key-div'>
                    <td>{car.modelNum}</td>
                    <td>{car.modelName}</td>
                    <td>{car.brand}</td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>  
      </div>  
    </div>
  )
}

export default Management