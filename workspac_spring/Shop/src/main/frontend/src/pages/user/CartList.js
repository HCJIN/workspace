import axios from 'axios';
import '../../css/cart.css'
import React, { useEffect, useState } from 'react'

const CartList = () => {

  const [cartLsit, setCartList] = useState([]);
  console.log(cartLsit)

  const [cartItem, setCartItem] = useState({})

  const memId = JSON.parse(window.sessionStorage.getItem("loginInfo")).memId

  useEffect(()=>{
    axios
    .get(`/item/getCartList/${memId}`)
    .then((res)=>{
      setCartList(res.data);
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  // 이미지 URL을 처리하는 함수
  const getImageUrl = (index) => {
    return (
      cartLsit[index].imgList[0] ? `http://localhost:8080/upload/${cartLsit[index].imgList[0].attachedFileName}` : ''
    )
  };

  function onChange(e){
    setCartItem({
      ...cartItem,
      [e.target.name] : e.target.value
    })
  }
  console.log(cartItem)

  return (
    <div className='cartList-div'>
      <table className='cartList-table'>
        <colgroup>
          <col width='5%'></col>
          <col width='5%'></col>
          <col width='20%'></col>
          <col width='10%'></col>
          <col width='*'></col>
          <col width='10%'></col>
          <col width='10%'></col>
          <col width='10%'></col>
        </colgroup>
        <thead className='head'>
          <tr>
            <td>No</td>
            <td>
              <input type='checkbox'></input>
            </td>
            <td>상품 정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>구매가격</td>
            <td>구매일시</td>
            <td></td>
          </tr>
        </thead>
        <tbody>
          {
            cartLsit.map((cart, i)=>{
              const price = cart.item.itemPrice.toLocaleString       ('ko-KR', {
                style: 'currency',
                currency: 'KRW', // 한국 원화
              })
              return(
                <tr key={i}>
                  <td>{cartLsit.length - i}</td>
                  <td>
                    <input type='checkbox'></input>
                  </td>
                  <td>
                    <div>
                      <img className='cartImg' src={getImageUrl(i)} alt="상품 이미지" />
                      <p>{cart.item.itemName}</p>
                    </div>
                  </td>
                  <td>{price}</td>
                  <td>
                    <input type='number' name='cnt' defaultValue={cart.cartCnt} onChange={(e)=>{onChange(e)}}></input>
                    <button type='button' className='btn btn-primary'>변경</button>
                  </td>
                  <td>
                    {cart.cartCnt * cart.item.itemPrice}
                  </td>
                  <td>
                    {cart.cartDate}
                  </td>
                  <td>
                  <button type='button' className='btn btn-primary'>삭제</button>
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default CartList