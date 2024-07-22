import React from 'react'
import { useNavigate } from 'react-router-dom'

const Login = () => {

  const navigate = useNavigate();



  return (
    <div className='loginPage-div'>
      <div className='login-div'>
        <span>Login</span>
        <span onClick={()=>{navigate('/join')}}>Join</span>
      </div>
      <p>자유게시판</p>
      <table className='login-table'>
        <tr>
          <td>아이디</td>
        </tr>
        <tr>
        <td>
            <input type='text'></input>
          </td>
        </tr>
        <tr>
          <td>비밀번호</td>
        </tr>
        <tr>
        <td>
            <input type='text'></input>
          </td>
        </tr>
      </table>
      <div className='login-btn'>
        <button type='button' className='btn'>로그인</button>
        <button type='button' className='btn' onClick={()=>{
          navigate('/')
        }}>목록가기</button>
      </div>
    </div>
  )
}

export default Login