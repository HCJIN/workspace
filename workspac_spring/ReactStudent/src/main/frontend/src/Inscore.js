import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

const Inscore = () => {

  const [studentList, setStudentList] = useState([]);
  const {stuNum} = useParams();
  const navigate = useNavigate();

  const [student, setStudent] = useState({
    stuNum : stuNum,
    korScore : '',
    engScore : '',
    mathScore : ''
  });

  useEffect(()=>{
    axios
    .get(`/score/${stuNum}`)
    .then((res)=>{
      setStudentList(res.data);
    })
    .catch((error)=>{
      alert('오류발생!!\n개발자 모드로 콘솔 확인하세요!')
      console.log(error);
    });
  },[])

  function change(e){
    setStudent({
      ...student,
      [e.target.name] : e.target.value
    })
  }

  function goScore(){
    axios
    .post(`/update`,student)
    .then((res)=>{
      navigate('/')
      console.log(student)
    })
    .catch((error)=>{

    })
  }


  


  return (
    <div className='table-div'>
      <table className='list-table'>
        <tr>
          <td colSpan={2}>
            <p>{studentList.stuName} 학생의 성적을 입력합니다.</p>
          </td>
        </tr>
        <tr>
          <td>국어</td>
          <td>
            <input type='text' name='korScore' onChange={(e)=>{
              change(e)
            }}></input>
          </td>
        </tr>
        <tr>
          <td>영어</td>
          <td>
            <input type='text' name='engScore' onChange={(e)=>{
              change(e)
            }}></input>
          </td>
        </tr>
        <tr>
          <td>수학</td>
          <td>
            <input type='text' name='mathScore' onChange={(e)=>{
              change(e)
            }}></input>
          </td>
        </tr>
      </table>
      <button type='button' onClick={(e)=>{
        goScore();
      }}>점수 등록</button>
    </div>
  )
}

export default Inscore