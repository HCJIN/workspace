import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Score = () => {

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
        <colgroup>
          <col width='33%'></col>
          <col width='33%'></col>
          <col width='33%'></col>
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>학생명</td>
            <td>성적입력</td>
          </tr>
        </thead>
        <tbody>
          {
            studentList.map((student, i)=>{
              return(
                <tr key={i}>
                  <td>{student.stuNum}</td>
                  <td>{student.stuName}</td>
                  <td>
                    <button type='button' onClick={(e)=>{
                      navigate(`/inscore/${student.stuNum}`)
                    }}>성적입력</button>
                  </td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default Score