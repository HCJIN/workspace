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
    //이름 입력했는지 확인
    const stuName_input = document.querySelector('input[name="stuName"]')
    if(stuName_input.value == ''){
      alert('이름을 입력하시오');
      stuName_input.focus();
      return;
    }
    
    axios
    .post(`/insert`,student)
    .then((res)=>{
      alert('학생이 등록되었습니다.')
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