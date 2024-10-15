
import axios from 'axios';
import React from 'react'
import { useNavigate } from 'react-router-dom'
import { securityApi } from './securityAxios';

const Main = () => {
  const navigate = useNavigate();

  //서버로 요청 시 토큰 가져가는 코드
  const test = () => {
    axios.get("/getToken", {
      headers : {
        'Authorization' : localStorage.getItem("Authorization")
      }
    })
    .then(res => console.log(res.data))
    .catch(error => console.log(error));
  }

  const test1 = () => {
    securityApi.get("/test1")
    .then(res => {
      console.log("성공")
    })
    .catch(error => console.log(error))
  }
  const test2 = () => {
    securityApi.get("/test2")
    .then(res => {
      console.log("성공")
    })
    .catch(error => {
      if(error.status == 403){
        alert('이 페이지에 접근하려면 로그인하셔야 합니다. \n 로그인 페이지로 이동합니다.');
        navigate('/loginForm');
      }else{
        console.log(error);
      }
    })
  }
  const test3 = () => {
    securityApi.get("/test3")
    .then(res => {})
    .catch(error => console.log(error))
  }
  const test4 = () => {
    securityApi.get("/test4")
    .then(res => {
      console.log("성공")
    })
    .catch(error => console.log(error))
  }
  const test5 = () => {
    securityApi.get("/test5")
    .then(res => {
      console.log("성공")
    })
    .catch(error => console.log(error))
  }

  return (
    <div>
      <h1>Main페이지</h1>
      <h3><span onClick={() => {navigate("/loginForm")}}>로그인 페이지로 이동</span></h3>
      <h3><span onClick={() => {navigate("/joinForm")}}>회원가입 페이지로 이동</span></h3>
      <h3><sapn onClick={() => {test()}}>서버에 토큰 가져가기</sapn></h3>

      <h3 onClick={()=>{test1()}}>MainController-text1 메서드 : 누구나 접근</h3>
      <h3 onClick={()=>{test2()}}>MainController-text2 메서드 : 인증된 사람만 접근</h3>
      <h3 onClick={()=>{test3()}}>MainController-text3 메서드 : 인증된 힐반회원만 접근</h3>
      <h3 onClick={()=>{test4()}}>MainController-text4 메서드 : 인증된 관리자만 접근</h3>
      <h3 onClick={()=>{test5()}}>MainController-text5 메서드 : 인증된 매니저 or 관리자 접근</h3>
      
    </div>
  )
}

export default Main