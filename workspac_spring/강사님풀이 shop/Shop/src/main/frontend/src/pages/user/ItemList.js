import React, { useEffect, useState } from 'react'
import '../../css/itemList.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const ItemList = () => {

  const [itemList, setItemList] = useState([]);

  const navigate = useNavigate();

  useEffect(()=>{
    axios
    .get('/item/getItemList')
    .then((res)=>{
      setItemList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  return (
    <div className='itemList-div'>
        {
          itemList.map((item, i)=>{
            const money = item.itemPrice;
            const price = money.toLocaleString('ko-KR', {
                style: 'currency',
                currency: 'KRW', // 한국 원화
              });
              console.log(item.imgList[0])
            return(
              <div className='item-div' key={i} onClick={()=>{
                navigate(`/detail/${item.itemCode}`)
              }}>
                <img src={`http://localhost:8080/upload/${item.imgList[0].attachedFileName}`}/> 
                <h4>{item.itemName}</h4>
                <p>{price}</p>
              </div>
            )
          })
        }
    </div>
  )
}

export default ItemList