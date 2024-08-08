import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../css/regItem.css';
import { useNavigate } from 'react-router-dom';
import Modal from '../../common/Modal';

const RegItem = () => {
  //첨부파일을 저장할 state 변수
  const [mainImg, setMainImg] = useState(null)
  const [subImg, setSubImg] = useState(null);

  const [itemList, setItemList] = useState([]);

  //등록버튼 눌렀을때 반응하는 모달
  const [show, setShow] = useState(false);

  //상품 등록 시 가져갈 데이터를 저장할 state 변수
  const [newItem, setNewItem] = useState({
    cateCode: '2', // 기본값 설정
    itemName: '',
    itemPrice: '',
    itemIntro: ''
  });
  const navigate = useNavigate();

  //자바에서 카테고리 목록 데이터 가져오기
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

  //input태그에 새로 입력하는 값 객체에 저장
  function onChange(e){
    setNewItem({
      ...newItem,
      [e.target.name] : e.target.value
    })
  }
  console.log(newItem)

  //상품등록 버튼 클릭 !!
  //post(url, data, config)
  //get(url, config)
  //put(url, data, config)
  //delete(url, config)
  function setItem(){
    //axios 통신으로 자바로 갈 때 첨부파일이 있으면 
    //반드시 아래의 설정코드를 axios에 추가!!!!
    const fileConfig = {headers : {'Content-Type' : 'multipart/form-data'}}

    //위의 설정코드를 axios 통신할 때 추가하면 자바로 넘어가는 데이터를 전달하는 방식이 달라짐
    //첨부파일이 있는 데이터를 자바로 전달하기 위해서는 form태그를 사용해서 전달!

    //1. form 객체 생성
    const itemForm = new FormData();

    //2. form 객체에 데이터 추가
    // itemForm.append('itemName', '상품1');
    // itemForm.append('itemPrice', 10000);

    itemForm.append('itemName',newItem.itemName);
    itemForm.append('itemPrice',newItem.itemPrice);
    itemForm.append('itemIntro',newItem.itemIntro);
    itemForm.append('cateCode',newItem.cateCode);
    itemForm.append('mainImg',mainImg);
    itemForm.append('subImg',subImg);

    //3. 데이터를 가진 form 객체를 axios 통신에서 자바로 전달한다.
    // axios
    // .post(`/admin/setItem`,newItem, fileConfig)
    axios
    .post(`/admin/setItem`,itemForm, fileConfig)
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
    navigate('/')
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
              <select name='cateCode' className='form-control' onChange={(e)=>{onChange(e)}}>
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
              <textarea name='itemIntro' className='form-control' onChange={(e)=>{onChange(e)}}></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div>
        <input type='file' className='file-div' onClick={(e)=>{
          console.log(e.target.files[0]);
          setMainImg(e.target.files[0]);
        }}></input>
      </div>
      <div>
        <input type='file' className='file-div' onChange={(e)=>{
          setSubImg(e.target.files[0]);
        }}></input>
      </div>
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