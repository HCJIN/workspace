import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import * as dataApi from '../apis/memberApi'

const Login = () => {

  const navigate = useNavigate();

  const [member, setMember] = useState([]);

  //input에 입력한 내용이 들어갈 객체생성
  const [newMember, setNewMember] = useState({
    memId : '',
    memPw : ''
  })

  //자바에서 아이디 데이터 가져오기
  useEffect(()=>{
    axios.get('/member/list')
    .then((res)=>{
      setMember(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  },[])

  //input에 입력한 값이 객체에 저장
  function onChange(e){
    setNewMember({
      ...newMember,
      [e.target.name] : e.target.value
    })
  }
  console.log(newMember)

  //가져온데이터랑 입력한 값 비교
  function login(){
    dataApi.chekIdPw(newMember)
    .then((res)=>{
      console.log(res.data)
      console.log('성공')
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div className='loginPage-div'>
      <div className='login-div'>
        <span>Login</span>
        <span onClick={()=>{navigate('/join')}}>Join</span>
      </div>
      <p>자유게시판</p>
      <table className='login-table'>
        <tbody>
          <tr>
            <td>아이디</td>
          </tr>
          <tr>
          <td>
              <input type='text' name='memId' placeholder='input ID' value={newMember.memId} onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
          </tr>
          <tr>
          <td>
              <input type='password' name='memPw' placeholder='inputPw' value={newMember.memPw} onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='login-btn'>
        <button type='button' className='btn' onClick={()=>{
          login()
        }}>로그인</button>
        <button type='button' className='btn' onClick={()=>{
          navigate('/')
        }}>목록가기</button>
      </div>
    </div>
  )
}

export default Login