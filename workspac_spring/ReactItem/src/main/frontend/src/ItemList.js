import axios from 'axios';
import './itemList.css'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const ItemList = () => {

  const [itemList, setItemList] = useState([]);
  const navigate = useNavigate();

  useEffect(()=>{
    axios
    .get('/getMain')
    .then((res)=>{
      console.log(res.data)
      setItemList(res.data);
    })
    .catch((error)=>{
      console.log(error)
    });
  },[]);



  return (
    <div className='table_div'>
      
      <div className='left_div'>
        <p>총 {itemList.length}개의 상품이 등록되었습니다.</p>
        <table className='list_table'>
          <thead>
            <tr>
              <td>No</td>
              <td>상품명</td>
              <td>상품가격</td>
              <td>판매자</td>
            </tr>
          </thead>
          <tbody>
            {
              itemList.length == 0 ? 
              <tr>
                <td colSpan={4}>등록된 상품이 없습니다.</td>
              </tr> :
              itemList.map((item,i)=>{
                return(
                  <tr key={i}>
                    <td>{i + 1}</td>
                    <td onClick={()=>{
                      navigate(`/detail/${item.itemNum}`)
                    }}>{item.itemName}</td>
                    <td>{item.itemPrice}</td>
                    <td>{item.seller}</td>
                  </tr>
                )
              })

            }
          </tbody>
        </table>
      </div>
      <div className='right_div'></div>
    </div>
  )
}

export default ItemList