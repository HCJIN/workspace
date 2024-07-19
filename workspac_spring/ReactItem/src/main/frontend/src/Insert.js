import React, { useState } from 'react'
import './insert.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Insert = () => {

  const navigate = useNavigate();

  const [item, setItem] = useState({
    itemName : '',
    itemPrice : '',
    seller : '',
    itemIntro : ''
  });

  function onChange(e){
    setItem({
      ...item,
      [e.target.name] : e.target.value
    })
  }

  function goIn(){
    axios
    .post('/insert', item)
    .then((res)=>{
      console.log(res.data);
      alert('상품등록이 완료되었습니다.')
      navigate('/')
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div className='insert_div'>
      <table className='insert_table'>
        <colgroup>
          <col width='20%'></col>
          <col width='*'></col>
        </colgroup>
        <tbody>
          <tr>
            <td>상품명</td>
            <td>
              <input type='text' name='itemName' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>상품가격</td>
            <td>
              <input type='text' name='itemPrice' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>판매자</td>
            <td>
              <input type='text' name='seller' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>상품설명</td>
            <td>
              <textarea name='itemIntro' onChange={(e)=>{
                onChange(e)
              }}></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn_div'>
        <button type='button' onClick={()=>{goIn()}}>등록</button>
      </div>
    </div>
  )
}

export default Insert