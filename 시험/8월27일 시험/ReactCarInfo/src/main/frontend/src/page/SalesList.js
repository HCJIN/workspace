import React, { useEffect, useState } from 'react'
import '../salesList.css';
import axios from 'axios';

const SalesList = () => {

  const [salesList, setSalesList] = useState([]);

  useEffect(()=>{
    axios
    .get('/sales/salesList')
    .then((res)=>{
      setSalesList(res.data)
    }).catch((error)=>{
      console.log(error)
    })
  },[])

  return (
    <div className='salesList-div'>
      <table>
        <colgroup>
          <col width='10%'></col>
        </colgroup>
        <tbody>
          <tr aria-rowspan={2}>
            <td rowSpan={2}>NO.</td>
            <td colSpan={4}>구매자정보</td>
            <td colSpan={2}>차량정보</td>
          </tr>
          <tr>
            <td>구매자명</td>
            <td>연락처</td>
            <td>구매일</td>
            <td>색상</td>
            <td>모델명</td>
            <td>금액</td>
          </tr>
          {
            salesList.map((item, i) => {
              console.log(item)
              return(
                <tr key={i}>
                  <td>{item.salesNumber}</td>
                  <td>{item.buyer}</td>
                  <td>{item.tel}</td>
                  <td>{item.salesDate}</td>
                  <td>{item.color}</td>
                  <td>{item.carInfo[0].modelName}</td>
                  <td>{item.carInfo[0].price}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default SalesList