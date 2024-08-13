import axios from 'axios';
import '../../css/detail.css';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const Detail = () => {

  
  const navigate = useNavigate();
  
  const [item, setItem] = useState({
    itemName: '',
    itemPrice: 0,
    cartCnt: 1,
    imgList: [],
    itemIntro: '',
    memId : 1
  });
  
  const { itemCode } = useParams();
  
  const [cart, setCart] = useState({
    itemCode : itemCode,
    cartCnt : item.cartCnt,
    memId : JSON.parse(window.sessionStorage.getItem("loginInfo")).memId
  })
  console.log(cart)

  useEffect(() => {
    axios
      .get(`/item/getItem/${itemCode}`)
      .then((res) => {
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

  function onChange(e) {
    setCart({
      ...cart,
      cartCnt : Number(item.cartCnt) + 1
    });
    setItem({
      ...item,
      [e.target.name]: e.target.value
    });
  }

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
    .post(`/item/insertCart`, cart)
    .then((res)=>{
      alert('장바구니에 담겼습니다')
      navigate('/cart')
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
            <img src={getImageUrl(0)} alt="상품 이미지" />
          </div>
        </div>
        <div className='top-right-div'>
          <div>
            <h4>{item.itemName}</h4>
            <p>가격 : {item.itemPrice.toLocaleString('ko-KR', { style: 'currency', currency: 'KRW' })}</p>
            <div className='cnt'>
              <p>수량</p>
              <input
                type='number'
                min={1}
                name='cartCnt'
                value={item.cartCnt}
                className='form-control'
                onChange={(e) => {onChange(e)}}
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
