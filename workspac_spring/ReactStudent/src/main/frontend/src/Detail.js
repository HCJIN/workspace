import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const Detail = () => {

  const [studentList, setStudentList] = useState([]);
  const {stuNum} = useParams();
  
  useEffect(()=>{
    axios
    .get(`/detail/${stuNum}`)
    .then((res)=>{
      console.log(res.data)
      setStudentList(res.data);
    })
    .catch((error)=>{
      console.log(error)
    })
  },[]);
  

  return (
    <div className='table-div'>
      <table className='list-table'>
        <tr>
          <td>이름</td>
          <td>{studentList.stuName}</td>
          <td>나이</td>
          <td>{studentList.stuAge}</td>
        </tr>
        <tr>
          <td>연락처</td>
          <td>{studentList.stuTel}</td>
          <td>주소</td>
          <td>{studentList.stuAddr}</td>
        </tr>
        <tr>
          <td>국어점수</td>
          <td>{studentList.korScore}</td>
          <td>영어점수</td>
          <td>{studentList.engScore}</td>
        </tr>
        <tr>
          <td>수학점수</td>
          <td>{studentList.mathScore}</td>
          <td>평균</td>
          <td>{((studentList.korScore + studentList.engScore + studentList.mathScore) / 3).toFixed()}</td>
        </tr>
      </table>
    </div>
  )
}

export default Detail