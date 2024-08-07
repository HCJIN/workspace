import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../css/regItem.css';
import { useNavigate } from 'react-router-dom';
import Modal from '../../common/Modal';

const RegItem = () => {

  const [itemList, setItemList] = useState([]);

  //등록버튼 눌렀을때 반응하는 모달
  const [show, setShow] = useState(false);

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
    .get('/admin/itemList')
    .then((res)=>{
      console.log(res.data)
      setItemList(res.data)
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
    .post(`/admin/setItem`,newItem)
    .then((res)=>{
      setShow(true);
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  //등록버튼 클릭시 나오는 모달 내용
  function setModalContent(){
    return(
      <div>
        상품을 등록했습니다
      </div>
    )
  }

  function goNavigate(){
    navigate('/admin/itemList')
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
              <select name='cateCode' onChange={(e)=>{onChange(e)}}>
                {
                  itemList.map((item, i)=>{
                    return(
                      <option key={i} value={item.cateCode}>{item.cateName}</option>
                                          
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
              <input type='text' name='itemName' onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 가격</td>
          </tr>
          <tr>
            <td>
              <input type='text' name='itemPrice' onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 소개</td>
          </tr>
          <tr>
            <td>
              <textarea name='itemIntro' onChange={(e)=>{onChange(e)}}></textarea>
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
      {
        show ? <Modal content={setModalContent} 
        setShow={setShow} 
        clickClosebtn={(goNavigate)}/> : null
      }
    </div>
  )
}

export default RegItem