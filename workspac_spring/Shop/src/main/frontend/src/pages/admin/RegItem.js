import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../../css/regItem.css';
import { useNavigate } from 'react-router-dom';
import Modal from '../../common/Modal';

const RegItem = () => {
  //첨부파일을 저장할 state 변수
  const [mainImg, setMainImg] = useState(null);
  const [subImg, setSubImg] = useState(null);

  //모달 여부
  const [show, setShow] = useState(false);

  //카테고리 목록을 저장할 state 변수
  const [categoryList, setCategoryList] = useState([]);

  //상품 등록 시 가져갈 데이터를 저장할 state 변수
  const [insertItemData, setInsertItemData] = useState({
    cateCode: 1, // 기본값 설정
    itemName: '',
    itemPrice: '',
    itemIntro: ''
  });
  const navigate = useNavigate();

  //자바에서 카테고리 목록 데이터 가져오기
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

  //input태그에 새로 입력하는 값 객체에 저장
  function changeInsertItemData(e){
    setInsertItemData({
      ...insertItemData,
      [e.target.name] : e.target.value
    })
  }
  console.log(insertItemData)

  //상품등록 버튼 클릭 !!
  //post(url, data, config)
  //get(url, config)
  //put(url, data, config)
  //delete(url, config)
  function insertItem(){
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

    itemForm.append('itemName', insertItemData.itemName);
    itemForm.append('itemPrice', insertItemData.itemPrice);
    itemForm.append('itemIntro', insertItemData.itemIntro);
    itemForm.append('cateCode', insertItemData.cateCode);
    itemForm.append('mainImg', mainImg);
    itemForm.append('subImg', subImg);

    //3. 데이터를 가진 form 객체를 axios 통신에서 자바로 전달한다.
    // axios
    // .post(`/api_admin/insertItem`,insertItemData
    //   , fileConfig)
    axios
    .post(`/api_admin/insertItem`, itemForm
      , fileConfig)
    .then((res)=>{
      setShow(true);
      // navigate('/admin');
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  function drawModalContent(){
    return(
      <div>상품등록완료</div>
    )
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
              <select name='cateCode' onChange={(e)=>{changeInsertItemData(e)}} >
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
              <input type='text' name='itemName' className='form-control' onChange={(e)=>{changeInsertItemData(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 가격</td>
          </tr>
          <tr>
            <td>
              <input type='text' name='itemPrice' className='form-control' onChange={(e)=>{changeInsertItemData(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>상품 소개</td>
          </tr>
          <tr>
            <td>
              <textarea name='itemIntro' className='form-control' rows={7} onChange={(e)=>{changeInsertItemData(e)}}></textarea>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='file-div'>
        <input type='file' className='form-control' onChange={(e)=>{
          //선택한 파일 정보(배열 형태로 가져 옴)
          console.log(e.target.files[0]);
          setMainImg(e.target.files[0]);
        }}/>
      </div>
      <div className='file-div'>
        <input type='file' className='form-control' onChange={(e)=>{
          setSubImg(e.target.files[0]);
        }}></input>
      </div>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={()=>{
          insertItem()
        }}>
          상품등록
        </button>
      </div>
      {
        show ?
        <Modal content={drawModalContent}
                setShow={setShow}
                clickClosebtn={()=>{}}/>
        : null
      }
    </div>
  )
}

export default RegItem