import axios from 'axios';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

const InStudent = () => {
  
  const navigate = useNavigate();

  const [student, setStudnet] = useState({
    stuName : '',
    stuAge : '',
    stuTel : '',
    stuAddr : ''
  });

  function goJoin(e){
    setStudnet({
      ...student,
      [e.target.name] : e.target.value
    })
  }

  function goInsert(){
    axios
    .post(`/insert`,student)
    .then((res)=>{
      navigate('/');
    })
    .catch();
  }
  


  return (
    <div className='inStudent-div'>
      <table>
        <tr>
          <td>이름</td>
          <td>
            <input type='text' name='stuName' onChange={(e)=>{
              goJoin(e);
            }}></input>
          </td>
        </tr>
        <tr>
          <td>나이</td>
          <td>
            <input type='text' name='stuAge' onChange={(e)=>{
              goJoin(e);
            }}></input>
          </td>
        </tr>
        <tr>
          <td>연락처</td>
          <td>
            <input type='text' name='stuTel' onChange={(e)=>{
              goJoin(e);
            }}></input>
          </td>
        </tr>
        <tr>
          <td>주소</td>
          <td>
            <input type='text' name='stuAddr' onChange={(e)=>{
              goJoin(e);
            }}></input>
          </td>
        </tr>
      </table>
      <button type='button' onClick={(e)=>{goInsert()}}>글쓰기</button>
    </div>
  )
}

export default InStudent