import axios from 'axios';
import '../../css/detail.css';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import ItemList from './ItemList';

const Detail = () => {

  
  const navigate = useNavigate();
  
  //조회한 상세 정보 데이터를 저장할 state 변수
  const [item, setItem] = useState({
    itemName: '',
    itemPrice: 0,
    cartCnt: 1,
    imgList: [],
    itemIntro: '',
    memId : ''
  });

  //대표 이미지명을 저장할 변수
  const [mainImgName, setMainImgName] = useState('');
  //상세 이미지명을 저장할 변수
  const [subImgName, setSubImgName] = useState('');
  
  const { itemCode } = useParams();
  
  //장바구니 담기 버튼 클릭 시 자바로 가져가는 데이터
  const [cart, setCart] = useState({
    itemCode : itemCode,
    cartCnt : item.cartCnt,
    memId : JSON.parse(window.sessionStorage.getItem("loginInfo")).memId
  })
  console.log(cart)

  //상품 상세 정보 조회
  useEffect(() => {
    axios
      .get(`/item/getItem/${itemCode}`)
      .then((res) => {
        let img1 = '';
        let img2 = '';
        //조회한 정보에서 대표이미지명, 서브이미지명 찾기
        res.data.imgList.forEach((img, i)=>{
          if(img.isMain == 'Y'){
            img1 = img.attachedFileName;
          }else{
            img2 = img.attachedFileName;
          }
        })

        setMainImgName(img1);
        setSubImgName(img2);
        const result = res.data;
        setItem({
          ...item,
          ...result
        });
      })
      .catch((error) => {
        console.error(error);
      });
  }, []); 

  //변경되는 값을 state에 저장
  function onChange(e) {
    setItem({
      ...item,
      [e.target.name]: e.target.value
    });
    setCart({...cart, cartCnt : e.target.value})
  }

  //총 가격 계산
  const total = item.itemPrice * item.cartCnt;
  const price = total.toLocaleString('ko-KR', {
    style: 'currency',
    currency: 'KRW', // 한국 원화
  });


  // 이미지 URL을 처리하는 함수
  const getImageUrl = (index) => {
    return (
      item.imgList[index] ? `http://localhost:8080/upload/${item.imgList[index].attachedFileName}` : ''
    )
  };

  function insertCart(){
    axios
    .post(`/cart/insertCart`, cart)
    .then((res)=>{
      const result = window.confirm('장바구니에 상품을 담았습니다. \n 계속 쇼핑하시겠습니까?')

      //취소를 선택하면 자바구니 목록 페이지로 이동
      if(!result){
        navigate('/cart')
      }else{

      }


    })
    .catch((error)=>{
      console.log(error)
    })
  }

  return (
    <div className='detail-div'>
      <div className='top-div'>
        <div className='top-left-div'>
          <div>
            <img src={`http://localhost:8080/upload/${mainImgName}`} alt="상품 이미지" />
          </div>
        </div>
        <div className='top-right-div'>
          <div>
            <h4>{item.itemName}</h4>
            <p>가격 : {
              Object.keys(item).length == 0 ? '' :
              item.itemPrice.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' })
            }</p>
            <div className='cnt'>
              <p>수량</p>
              <input

                type='number'
                name='cartCnt'
                value={item.cartCnt}
                className='form-control'
                onChange={(e) => {
                  e.target.value < 1 || e.target.value > 10 
                  ?
                    setItem({...item, cartCnt : 1})
                  :
                  onChange(e)}}
              />
            </div>
            <p>총 가격 : <span>{price}</span></p>
            <div className='btn-div'>
              <button type='button' className='btn btn-primary'>구매하기</button>
              <button type='button' className='btn btn-primary' onClick={()=>{insertCart()}}>장바구니에 담기</button>
            </div>
          </div>
        </div>
      </div>
      <div className='itemIntro-div'>
        {item.itemIntro}
      </div>
      <div className='bottom-div'>
        <img src={getImageUrl(1)} alt="상세 이미지" />
      </div>
    </div>
  );
}

export default Detail;
