import axios from 'axios';
import React, { useEffect, useState } from 'react'
import Score from './Score';
import { useNavigate } from 'react-router-dom';
import * as api from './apis'

const StudentList = () => {

  const navigate = useNavigate();

  const [studentList, setStudentList] = useState([]);

  useEffect(()=>{
    axios
    .get('/getMain')
    .then((res)=>{
      console.log(res.data)
      setStudentList(res.data);
    })
    .catch((error)=>{
      console.log(error)
    });
  },[]);


  return (
    <div className='table-div'>
      <table className='list-table'>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>국어점수</td>
            <td>영어점수</td>
            <td>수학점수</td>
            <td>평균</td>
          </tr>
        </thead>
        <tbody>
          {
            studentList.length == 0 ?
            <tr>
              <td colSpan={6}>조회된 데이터가 없습니다</td>
            </tr> :
            studentList.map((student, i)=>{
              return(
                <tr key={i}>
                  <td>{i+1}</td>
                  <td id='name' onClick={(e)=>{
                    navigate(`/detail/${student.stuNum}`);
                  }}>{student.stuName}</td>
                  <td>{student.korScore}</td>
                  <td>{student.engScore}</td>
                  <td>{student.mathScore}</td>
                  <td>{((student.korScore + student.engScore + student.mathScore) / 3).toFixed(2)}</td>
                </tr>
              )
            })
          } 
        </tbody>
      </table>
    </div>
  )
}

export default StudentList