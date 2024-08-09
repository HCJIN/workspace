import axios from 'axios';
import '../../css/detail.css';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const Detail = () => {
  const [item, setItem] = useState({
    itemName: '',
    itemPrice: 0,
    cnt: 1,
    imgList: [],
    itemIntro: ''
  });

  const { itemCode } = useParams();

  useEffect(() => {
    axios
      .get(`/item/getItem/${itemCode}`)
      .then((res) => {
        console.log(res.data);
        setItem(res.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []); 

  function onChange(e) {
    setItem({
      ...item,
      [e.target.name]: e.target.value
    });
  }

  const total = item.itemPrice * item.cnt;
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

  return (
    <div className='detail-div'>
      <div className='top-div'>
        <div className='top-left-div'>
          <div>
            {item.imgList.length > 0 && (
              <img src={getImageUrl(0)} alt="상품 이미지" />
            )}
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
                name='cnt'
                value={item.cnt}
                className='form-control'
                onChange={(e) => {onChange(e)}}
              />
            </div>
            <p>총 가격 : <span>{price}</span></p>
            <div className='btn-div'>
              <button type='button' className='btn btn-primary'>구매하기</button>
              <button type='button' className='btn btn-primary'>장바구니에 담기</button>
            </div>
          </div>
        </div>
      </div>
      <div className='itemIntro-div'>
        {item.itemIntro}
      </div>
      <div className='bottom-div'>
        {/* 조건부 렌더링을 통해 imgList가 비어있지 않을 때만 이미지 표시 */}
        {item.imgList.length > 1 && (
          <img src={getImageUrl(1)} alt="상세 이미지" />
        )}
      </div>
    </div>
  );
}

export default Detail;
