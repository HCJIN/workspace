import React, { useEffect, useState } from 'react'
import '../../css/login.css'
import axios from 'axios';
import Modal from '../../common/Modal';
import { useNavigate } from 'react-router-dom';
import * as dataApi from '../../apis/login'

const Login = ({loginInfo, setLoginInfo}) => {

  const navigate = useNavigate();
  const [memberList, setMemberList] = useState([]);
  //입력한 id, pw를 저장할 변수
  const [loginMember, setLoginMember] = useState({
    memId : '',
    memPw : ''
  });
  //login버튼 클릭 시 화면에 보여지는 모달창의 상태
  const [show, setShow] = useState(false);
  //login 쿼리가 실행된 후 보여지는 모달창의 상태
  const [afterLoginModal, setAfterLoginModal] = useState(false);
  //로그인 성공 실패 여부를 저장하는 변수
  const [isLoginSuccess, setIsLoginSuccess] = useState(false)

  //input에 입력한 값 객체에 저장
  function onChange(e){
    setLoginMember({
      ...loginMember,
      [e.target.name] : e.target.value
    })
  }

  //login 버튼 클릭시 로그인
  function login(){
    //id,pw 입력 여부 확인
    if(loginMember.memId == '' || loginMember.memPw == ''){
      setShow(true)
      return
    }

    dataApi.checkIdPw(loginMember)
    .then((res)=>{
      setAfterLoginModal(true)
      if(res.data != ''){
        setIsLoginSuccess(true)

        //sessionStorage에 로그인한 회원의 정보 저장
        const loginInfo = {
        memId : res.data.memId,
        memName : res.data.memName,
        memRole : res.data.memRole
        }

        //로그인 정보를 가진 객체를 문자열 형태로 변환
        //객체 -> 문자열로 변환한 데이터를 JOSN 데이터로 부른다.
        // JSON.stringify();
        window.sessionStorage.setItem('loginInfo', JSON.stringify(loginInfo));

        //로그인 정보를 저장하기 위해 만든 state 변수 loginInfo(App.js생성)에 로그인 정보를 저장
        setLoginInfo(loginInfo);

      }else{
        setIsLoginSuccess(false)
      }
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  //모달 내용 함수
  function setModalContent(){
    if(loginMember.memId == '' || loginMember.memPw == ''){
      return(
        <div>
          ID나 PW에 빈값이 존재합니다.
        </div>
      )
    }
  }

  //login 쿼리 실행 후 뜨는 모달 안의 내용 
  function drawModalContent(){
    return(
      <>
        {
          isLoginSuccess
          ?
          <div>환영합니다</div>
          :
          <div>ID, PW를 확인하세요 ~</div>
        }
      </>
    )
  }

  //모달창을 닫으면 실행되는 함수
  function onClickModalBtn(){
    navigate('/loginForm')
  }

  //login 쿼리 실행 후 뜨는 모달 안의 확인 버튼 클릭 시 실행되는 내용
  function handleBtn(){
    if(isLoginSuccess){//로그인 성공 시 확인 버튼 내용
      //로그인 성공 시 상품 목록 페이지로 이동
      if(loginInfo.memRole == 'ADMIN'){
        navigate('/admin/itemManage')
      }else if(loginInfo.memRole == 'USER'){
        navigate('/')
      }
    }
  }

  

  return (
    <div className='loginForm-div'>
      <div className='login-title'>
        <h1>Scream</h1>
        <h6>KICKS RULE EVERYTHING AROUND ME</h6>
      </div>
      <table className='login-table'>
        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input type='text' name='memId' className='form-control' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr></tr>
          <tr>
            <td>비밀번호</td>
            <td>
              <input type='password' name='memPw' className='form-control' onChange={(e)=>{
                onChange(e);
              }}></input>
            </td>
          </tr>
          <tr></tr>
        </tbody>
      </table>
      <div className='icon-div'>
        <i className="bi bi-facebook"></i>
        <i className="bi bi-instagram"></i>
        <i className="bi bi-twitter-x"></i>
      </div>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={()=>{
          login();
        }}>로그인</button>
      </div>
      {
        show ? <Modal content={setModalContent} 
        setShow={setShow} 
        clickClosebtn={onClickModalBtn}/> : null
      }

      {/* login 쿼리 실핼 후 뜨는 모달 */}
      {
        afterLoginModal
        ?
        <Modal content={drawModalContent}
              setShow={setAfterLoginModal}
              clickClosebtn={handleBtn}/>
        :
        null
      }
    </div>
  )
}

export default Login