import React, { useEffect, useState } from 'react'
import '../../css/itemList.css'
import axios from 'axios';

const ItemList = () => {

  const [itemList, setItemList] = useState([]);

  useEffect(()=>{
    axios
    .get('/admin/getItemList')
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
          return(
            <div className='item-box'>
              <img className='item-img' src='http://localhost:8080/images/panda.PNG'></img>
              <p>- {item.itemName} -</p>
              <p>{item.itemPrice}원</p>
            </div>
          )
        })
      }
    </div>
  )
}

export default ItemList