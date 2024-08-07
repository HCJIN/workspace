import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../css/regItem.css';
import { useNavigate } from 'react-router-dom';

const RegItem = () => {

  //카테고리 목록을 저장할 state 변수
  const [categoryList, setCategoryList] = useState([]);
  const [newItem, setNewItem] = useState({
    cateCode: '2', // 기본값 설정
    itemName: '',
    itemPrice: '',
    itemIntro: ''
  });
  const navigate = useNavigate();

  //자바에서 데이터 가져오기
  useEffect(()=>{
    axios
    .get('/api_admin/getCateList')
    .then((res)=>{
      setCategoryList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[]);

  //새로 입력하는 값 객체에 저장
  function onChange(e){
    setNewItem({
      ...newItem,
      [e.target.name] : e.target.value
    })
  }
  console.log(newItem)

  function setItem(){
    axios
    .post(`/api_admin/setItem`,newItem)
    .then((res)=>{
      navigate('/admin');
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div className='regItem-div'>
      <table className='regItem-table'>
        <tbody>
          <tr>
            <td>상품 카테고리</td>
          </tr>
          <tr>
            <td>
              <select name='cateCode' onChange={(e)=>{onChange(e)}} >
                {
                  categoryList.map((category, i)=>{
                    return(
                      <option key={i} value={category.cateCode}>{category.cateName}</option>
                                          
                    )
                  })
                }
              </select>
            </td>
          </tr>
          <tr>
            <td>상품명</td>
          </tr>
          <tr>
            <td>
              <input type='text' name='itemName' className='form-control' onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 가격</td>
          </tr>
          <tr>
            <td>
              <input type='text' name='itemPrice' className='form-control' onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 소개</td>
          </tr>
          <tr>
            <td>
              <textarea name='itemIntro' className='form-control' rows={7} onChange={(e)=>{onChange(e)}}></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={()=>{
          setItem()
        }}>
          상품등록
        </button>
      </div>
    </div>
  )
}

export default RegItem