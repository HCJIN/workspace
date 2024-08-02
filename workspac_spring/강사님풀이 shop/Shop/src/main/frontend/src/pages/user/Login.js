import React from 'react'
import '../../css/login.css'

const Login = () => {
  return (
    <div className='loginForm-div'>
      <div className='login-title'>
        <h1>Scream</h1>
        <h6>KICKS RULE EVERYTHING AROUND ME</h6>
      </div>
      <table className='login-table'>
        <tr>
          <td>아이디</td>
          <td>
            <input type='text' className='form-control'></input>
          </td>
        </tr>
        <tr></tr>
        <tr>
          <td>비밀번호</td>
          <td>
            <input type='password' className='form-control'></input>
          </td>
        </tr>
        <tr></tr>
      </table>
      <div className='icon-div'>
        <i className="bi bi-facebook"></i>
        <i className="bi bi-instagram"></i>
        <i className="bi bi-twitter-x"></i>
      </div>
    </div>
  )
}

export default Login