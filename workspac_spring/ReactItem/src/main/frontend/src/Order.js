import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './order.css'

const Order = () => {

  const [buyList, setBuyList] = useState([]);
  const [price, setPrice] = useState('');
  const [selectItem, setSelectItem] = useState({
    itemName : '',
    imtemPrice : '',
    buyer : '',
    buyCnt : ''
  });

  //데이터 받아오기
  useEffect(()=>{
    axios
    .get('/getOrder')
    .then((res)=>{
      setBuyList(res.data)
      setSelectItem({
        itemName : res.data[0].itemName,
        itemPrice : res.data[0].itemPrice
      })
      setPrice(res.data[0].itemPrice)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  //셀렉트 변경시 작동
  function onChange(e){
    setSelectItem({
      itemName : e.target.value
      // {
      //   ...selectItem,
      //   [e.target.name] : e.target.vlaue
      // }
    })
  }

  //가격 출력
  useEffect(()=>{
      let buyPrice = 0;
      buyList.map((item)=>{
        if(item.itemName == selectItem.itemName){
          buyPrice = item.itemPrice
        }
      })
      setPrice(buyPrice)
  },[selectItem.itemName])
  
  //주문하기
  function change(e){
    setSelectItem({
      ...selectItem,
      [e.target.name] : e.target.value
    })
  }

  function buy(){
    axios
    .post('/insert', selectItem)
    .then((res)=>{

    })
    .catch((error)=>{

    })
  }


  return (
    <div className='order_div'> 
      <table >
        <tbody>
          <tr>
            <td>주문상품</td>
            <td>
              <select value={selectItem.itemName} onChange={(e)=>{
                onChange(e)
              }}>
                {
                  buyList.map((buy, i) => {
                    return(
                      <option key={i} >
                        {buy.itemName}
                      </option>
                    ) 
                  })
                }
              </select>
            </td>
          </tr>
          <tr>
            <td>상품단가</td>
            <td>
              <input type='text' className='read' value={price} readOnly></input>
            </td>
          </tr>
          <tr>
            <td>주문자</td>
            <td>
              <input type='text' name='buyer' onChange={(e)=>{
                change(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>주문 수량</td>
            <td>
              <input type='text' name='buyCnt' onChange={(e)=>{
                change(e)
              }}></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn_div'>
        <button type='button'>주문하기</button>
      </div>
    </div>
  )
}

export default Order