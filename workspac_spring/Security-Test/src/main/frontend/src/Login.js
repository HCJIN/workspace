import axios from 'axios';
import React, { useState } from 'react'

const Login = () => {

  //입력한 로그인 정보를 저장할 state변수
  const [loginData, setLoginData] = useState({
    memId : '',
    memPw : ''
  });

  const changeLoginData = (e) => {
    setLoginData({
      ...loginData,
      [e.target.name] : e.target.value
    })
  }

  const login = () => {
    axios
    .post('/member/login', loginData)
    .then((res)=>{
      console.log('로그인 성공');
      console.log(res);
    })
    .catch((error) => {
      console.log(error)
    })
  }

  console.log(loginData)
  
  //아이디와 비번 input 태그의 name 속성은 반드시 
  //자바의 LoginFilter 클래스의 생성자 안에서 설정한 파라메터 이름으로 지정!
  return (
    <div>
      <h1>로그인 페이지</h1>
      <div>
        아이디 : <input type='text' name='memId' onChange={(e)=>{changeLoginData(e)}}></input>
      </div>
      <div>
        비밀번호 : <input type='password' name='memPw' onChange={(e)=>{changeLoginData(e)}}></input>
      </div>
      <div>
        <button type='buttton' onClick={()=>{login()}}>로그인</button>
      </div>
    </div>
  )
}

export default Login