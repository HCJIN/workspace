import React from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import './detail.css'

const Detail = ({list,setList}) => {

  const navigate = useNavigate();

  const {stuNum} = useParams();

  let stu = null;
  list.forEach(e => {
    if(e.stuNum == stuNum){
      stu = e;
    }
  });

  return (
    <div className='detail-div'>
      <table className='detail-table'>
        <colgroup>
          <col width='25%'></col>
          <col width='25%'></col>
          <col width='25%'></col>
          <col width='25%'></col>
        </colgroup>
        <tbody>
          <tr>
            <td>이름</td>
            <td>{stu.stuName}</td>
            <td>나이</td>
            <td>{stu.age}</td>
          </tr>
          <tr>
            <td>연락처</td>
            <td>{stu.tel}</td>
            <td>주소</td>
            <td>{stu.addr}</td>
          </tr>
          <tr>
            <td>국어점수</td>
            <td>{stu.koScore}</td>
            <td>영어점수</td>
            <td>{stu.enScore}</td>
          </tr>
          <tr>
            <td>수학점수</td>
            <td>{stu.mathScore}</td>
            <td>평균</td>
            <td>{stu.avg}</td>
          </tr>
        </tbody>
      </table>
      <button type='button' onClick={()=>{
        navigate('/')
      }}>뒤로가기</button>
    </div>
  )
}

export default Detail