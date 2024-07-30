import axios from 'axios';
import React, { useEffect, useState } from 'react'
import '../salesInfo.css';
import { useNavigate } from 'react-router-dom';

const SalesInfo = () => {

  const [carList, setCarList] = useState([]);
  const navigate = useNavigate();

  const [sales, setSales] = useState({
    buyer : '',
    color : '블랙',
    modelNum : 1,
    tel : ''
  });

  //자바 데이터 받아오기
  useEffect(()=>{
    axios.get('/info/carList')
    .then((res)=>{
      setCarList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])


  //생성한 구매자 객체 값 입력
  function onChange(e){
    setSales({
      ...sales,
      [e.target.name] : e.target.value
    })
  }

  //작성한 구매자 객체 자바 전달 
  function goByuer(){
    const buyer = document.querySelector('#buyer').value;
    const tel = document.querySelector('#tel').value;
    console.log(sales)
    if(buyer == '' || tel == ''){
      alert('빈 값이 있습니다.')
      return
    }else{
      axios
      .post('/sales/inBuyer', sales)
      .then((res)=>{
        alert('등록이 완료되었습니다.')
        navigate('/salesList')
      })
      .catch((error)=>{
        console.log(error)
      })
    }
  }

  return (
    <div className='salesInfo'>
      <table className='sales-table'>
        <colgroup>
          <col width='10%'></col>
          <col width='20%'></col>
          <col width='10%'></col>
          <col width='20%'></col>
        </colgroup>
        <tbody>
          <tr>
            <td><p>구매자명</p></td>
            <td colSpan={3}>
              <input type='text' name='buyer' id='buyer' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td><p>색상</p></td>
            <td>
              <select name='color' value={sales.color} onChange={(e)=>{
                onChange(e);
              }}>
                <option>블랙</option>
                <option>화이트</option>
                <option>실버</option>
                <option>레드</option>
              </select>
            </td>
            <td><p>모델</p></td>
            <td>
              <select name='modelNum' value={sales.modelNum} onChange={(e)=>{
                onChange(e)
              }}>
                {
                  carList.map((car,i)=>{
                    return(
                      <option key={i} value={car.modelNum}>{
                        car.modelName
                      }</option>
                    )
                  })
                }
              </select>
            </td>
          </tr>
          <tr>
            <td><p>연락처</p></td>
            <td>
              <input type='text'id='tel' name='tel' onChange={(e)=>{
                onChange(e);
              }}></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn'>
        <button type='button' onClick={()=>{
          goByuer();
        }}>등록</button>
      </div>
    </div>
  )
}

export default SalesInfo