import React, { useEffect, useRef, useState } from 'react'
import '../../css/join.css'
import axios from 'axios';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';
import Firecracker from '../../common/Firecracker'
import Modal from '../../common/Modal'
import { joinValidate } from '../../validate/joinValidate';

const Join = () => {
  //id 중복 체크 여부를 저장할 변수
  const [isCheckId, setIsChecId] = useState(false);

  const navigate = useNavigate();

  //모달창 불린 유무
  const [isShow, setIsShow] = useState(false);

  const [validResult, setValidResult] = useState(false);

  //daum 주소 api 팝업창을 띄우기 위한 함수 선언
  const open = useDaumPostcodePopup();

  //주소 검색 팝업창이 닫힐 때 실행되는 함수
  function handleComplete(data){
    //우편번호
    let zonecode = data.zonecode;
    //도로명주소
    let roadAddress = data.roadAddress

    //input 태그에 검색한 내용 넣어주기
    setNewMember({
      ...newMember,
      post : zonecode,
      memAddr : roadAddress
    })
  }

  //검색 버튼 클릭시 실행되는 함수
  function handleClick(){
    open({onComplete : handleComplete});
  }
  
  const email_1 = useRef();
  const email_2 = useRef();

  //새로 입력될 멤버
  const [newMember, setNewMember] = useState({
    memId : '',
    memPw : '',
    memPwChk : '',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  const memId_valid_tag = useRef();
  const memName_valid_tag = useRef();
  const memPwChk_valid_tag = useRef();
  const memPw_valid_tag = useRef();
  const memTel_valid_tag = useRef();

  //ref 태그들을 한번에 배열로 가져가기
  const valid_tag = [
    memId_valid_tag, 
    memPw_valid_tag,
    memPwChk_valid_tag,
    memName_valid_tag,
    memTel_valid_tag
  ];

  //새로 입력되는 input 값을 객체에 저장
  function onChange(e){
    //입력한 데이터
    const newData = {
      ...newMember,
      [e.target.name] : e.target.name != 'memEmail' ? 
      e.target.value :
      email_1.current.value + email_2.current.value
    }

    //입력한 데이터에 대한 
    //validation 처리 : 모든 데이터가 유효한 데이터면 리턴 true
    const result = joinValidate(newData, valid_tag, e.target.name);
    setValidResult(result)

    //유효성 검사 끝난 데이터를 joinData에 저장 // 이메일을 변경했으면...(삼항연산자)
    setNewMember(newData);

  }

  const triggerConfetti = Firecracker();

  //회원가입 데이터 전달
  function goJoin(){
    if(!validResult){
      alert('입력 데이터를 확인하세요.')
      return;
    }

    //id중복 검사 했는지 확인
    if(!isCheckId){
      alert('ID 중복검사 후 가입 하세요.');
      return;
    }
  
    axios.post('/member/insert',newMember)
    .then((res)=>{
      setIsShow(true);
      triggerConfetti();
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  //모달창 안의 내용을 생성하는 함수
  function setModalContent(){
    return(
      <div>
        🎉회원가입이 완료되었습니다.🎉
      </div>
    )
  }

  //모달창을 닫으면 실행되는 함수
  function onClickModalBtn(){
    navigate('/loginForm')
  }

  //자바에서 가져온 데이터랑 입력한 값 비교
  function joinChk(){
    axios.get(`/member/checkId/${newMember.memId}`)
    .then((res)=>{
      const result = res.data;
      alert(result ? '중복입니다' : '사용가능합니다')
      setIsChecId(true);
    })
    .catch((error)=>{
      console.log(error)
    })
  }


  return (
    <div className='join-div'>
      <table className='join-table'>
        <tbody>
          <tr>
            <td>아이디<span>*</span></td>
            <td>
              <div className='inline-input'>
                <input type='text' name='memId' onChange={(e)=>{onChange(e);
                  setIsChecId(false);
                }}></input>
                <button type='button' onClick={()=>{joinChk()}}>중복확인</button>
              </div>
              <div className='feedback' ref={memId_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>비밀번호<span>*</span></td>
            <td colSpan={2}>
              <input type='password' name='memPw'  onChange={(e)=>{onChange(e)}}></input>
              <div className='feedback' ref={memPw_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>비밀번호확인<span>*</span></td>
            <td colSpan={2}>
              <input type='password' name='memPwChk'  onChange={(e)=>{onChange(e)}}></input>
              <div className='feedback' ref={memPwChk_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>이름<span>*</span></td>
            <td colSpan={2}>
              <input type='text' name='memName'  onChange={(e)=>{onChange(e)}}></input>
              <div className='feedback' ref={memName_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>연락처</td>
            <td colSpan={2}>
              <input type='text' name='memTel' placeholder='숫자만 입력하세요.' onChange={(e)=>{onChange(e)}}></input>
              <div className='feedback' ref={memTel_valid_tag}></div>
            </td>
          </tr>
          <tr>
            <td>주소</td>
            <td>
              <div className='inline-input'>
                <input type='text' name='post'placeholder='우편번호' onChange={(e)=>{onChange(e)}} onClick={handleComplete}readOnly={true} value={newMember.post}></input>
                <button type='button' onClick={handleClick}>주소검색</button>
              </div>
            </td>
          </tr>
          <tr className='addr-tr'>
            <td></td>
            <td>
              <input type='text' id='addr' name='memAddr'  placeholder='주소' onChange={(e)=>{onChange(e)}} value={newMember.memAddr} readOnly={true} onClick={handleComplete}></input>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type='text' placeholder='상세주소' name='addrDetail' onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <div className='inline-input'>
                <input type='text' name='memEmail' ref={email_1} onChange={(e)=>{onChange(e)}}></input>
                <select name='memEmail' ref={email_2} value={newMember.secondEmail} onChange={(e)=>{onChange(e)}}>
                  <option alue={'@naver.com'}>naver.com</option>
                  <option alue={'@daum.net'}>daum.net</option>
                </select>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='btn-div'>
        <button onClick={goJoin} className='btn btn-primary'>
          회원가입
        </button>
      </div>
      {/* 회원가입 성공 시 열리는 모달 */}
      {
        isShow ? <Modal content={setModalContent} setShow={setIsShow} clickClosebtn={onClickModalBtn}/> : null
      }
    </div>
  )
}

export default Join