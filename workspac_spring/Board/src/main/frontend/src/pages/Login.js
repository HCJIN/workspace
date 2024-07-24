import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import * as dataApi from '../apis/memberApi'


//리액트는 화면을 새로고침 할 때마다 데이터가 초기화 되기 때문에 
//로그인을 했다는 정보를 일반적인 방식으로 저장해도 새로고침하면 로그인이 풀려버린다.

//새로고침 해도 정보가 사라지지 않는 저장 공간을 두 개 제공. 
//이 두 개의 저장 공간은 client pc에 존재.

//localStorage : 
//여기에 저장되는 데이터는 직접 삭제하지 않는 한 반영구적으로 보전. 
//인터넷 끊겨도, 컴퓨터를 재부팅해도 데이터가 살아있음.
//브라우저에 다른 탭끼리도 데이터가 공유

//sessionStorage
//여기에 저장되는 데이터는 인터넷(브라우저)을 종료하면 자동으로 사라짐
//브라우저의 탭이 달라도 데이터 공유가 안 됨. 

//사용법
//데이터 저장 : sessionStorage.setItem(key, value);
//데이터 읽기 : sessionStorage.getItem(key);
//데이터 삭제 : sessionStorage.removeItem(key);
//전체데이터 삭제 : sessionStorage.clear();

//localStorage는 sessionStorage 를 localStorage로 바꾸면 됨

const Login = ({loginInfo, setLoginInfo}) => {
  //sessionStorage 데이터 입력
  window.sessionStorage.setItem('name', 'kim');
  window.sessionStorage.setItem('age', 20);

  const m = {
    stuNum : 1,
    name : 'lee',
    age : 30
  }

  //객체 -> json으로 변환 (객체를 문자로 변환)
  // JSON.stringify();
  // json -> 객체
  // JSON.parse();
  window.sessionStorage.setItem('member', JSON.stringify(m));

  const data = window.sessionStorage.getItem('member')
  console.log(data)
  //json 데이터를 가져오면 문자로 인식한다!!
  console.log(JSON.parse(data));
  console.log(JSON.parse(data).stuNum);

  //객체나 배열을 Strage에 저장할 때 json 형태로 저장 할 수 있음.
  //json(javascript object notation) -> 자바스크립트의 객체를 문자화 시킨 것!
  //{name : 'kim', age : 20} -> "{name : 'kim', age : 20}"
  //모든 언어에서 공통으로 해석할 수 있는 자료형

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

  //로그인 버튼 클릭시 실행
  function login(){
    dataApi.chekIdPw(newMember)
    .then((res)=>{
      //조회결과에 따라 로그인 실행
      //조회결과가 있으면 로그인 처리! 
      console.log(res.data)
      if(res.data != ''){
        alert('로그인 성공')

        //sessionStorage에 로그인한 사람의 아이디, 이름, 권한을 저장
        const loginInfo = {
          memId : res.data.memId,
          memName : res.data.memName,
          memRole : res.data.memRole
        }

        window.sessionStorage.setItem('loginInfo',JSON.stringify(loginInfo));

        setLoginInfo(loginInfo);

        navigate('/')

        //조회결과가 없으면 다시 로그인 할 수 있도록 처리
      }else{
        alert('id 혹은 pw 확인')
      }

    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div className='loginPage-div'>
      {/* <div className='login-div'>
        <span>Login</span>
        <span onClick={()=>{navigate('/join')}}>Join</span>
      </div> */}
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