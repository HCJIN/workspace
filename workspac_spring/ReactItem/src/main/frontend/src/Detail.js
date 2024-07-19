import axios from 'axios';
import './itemList.css'
import React, { useCallback, useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';

const Detail = () => {

  const [itemList, setItemList] = useState([]);
  const {itemNum} = useParams();
  const navigate = useNavigate();
  const [item, setItem] = useState({
    itemNum : itemNum,
    itemName: '',
    itemPrice: '',
    seller: '',
    regDate: '',
    itemIntro: ''
  });

  useEffect(()=>{
    axios
    .get('/getMain')
    .then((res)=>{
      setItemList(res.data);
    })
    .catch((error)=>{
      console.log(error)
    });
  },[]);

  useEffect(() => {
      axios
        .get(`/detail/${itemNum}`)
        .then((res) => {
          console.log(res.data);
          setItem(res.data);
        })
        .catch((error) => {
          console.log(error);
        });
    
  }, [itemNum]);

  function goChange(e){
    setItem({
      ...item,
      [e.target.name] : e.target.value
    })
  }

  function goJoin(){
    axios
    .post(`/update/${itemNum}`,item)
    .then((res)=>{
      alert('수정이 완료되었습니다.')
      navigate('/')
    })
    .catch((error)=>{})
  }


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
      <div className='right_div'>
        <p>상품 상세 정보</p>
        <table className='list_table'>  
          <tbody>
            <tr>
              <td>상품번호</td>
              <td>
                <input type='text' className='read' readOnly value={item.itemNum}></input>
              </td>
            </tr>
            <tr>
              <td>상품명</td>
              <td>
                <input type='text' name='itemName' value={item.itemName} onChange={(e)=>{goChange(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>상품가격</td>
              <td>
                <input type='text' name='itemPrice' value={item.itemPrice} onChange={(e)=>{goChange(e)}} ></input>
              </td>
            </tr>
            <tr>
              <td>판매자</td>
              <td>
                <input type='text' className='read' readOnly  onChange={(e)=>{goChange(e)}} value={item.seller}></input>
              </td>
            </tr>
            <tr>
              <td>판매시작일</td>
              <td>
                <input type='text' className='read' readOnly value={item.regDate}></input>
              </td>
            </tr>
            <tr>
              <td>상품 설명</td>
              <td>
                <textarea name='itemIntro' value={item.itemIntro} onChange={(e)=>{goChange(e)}}>
                </textarea>
              </td>
            </tr>
          </tbody>
        </table>
        <div className='btn_div'>
          <button type='button' onClick={()=>{ goJoin()}}>수정</button>
        </div>
      </div>
    </div>
  )
}

export default Detail;