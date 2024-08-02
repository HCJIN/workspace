import React, { useEffect, useRef, useState } from 'react'
import '../../css/join.css'
import axios from 'axios';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import { useNavigate } from 'react-router-dom';
import Firecracker from '../../common/Firecracker'
import Modal from '../../common/Modal'

const Join = () => {

  const navigate = useNavigate();

  //모달창 불린 유무
  const [isShow, setIsShow] = useState(false);

  //회원가입 성공 여부
  const [joinSuccess, setJoinSuccess] = useState(false);

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
    memPwChk : '1',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  //새로 입력되는 input 값을 객체에 저장
  function onChange(e){
    //이메일을 변경했으면...(삼항연산자)
    setNewMember({
      ...newMember,
      [e.target.name] : e.target.name != 'memEmail' ? 
      e.target.value :
      email_1.current.value + email_2.current.value
    })
  }
  console.log(newMember)

  //자바에서 가져온 데이터랑 입력한 값 비교
  function joinChk(){
    console.log(newMember)
    if(newMember.memId == ''){
      alert('아이디를 입력하세요.')
      return
    }

    if(newMember.memId.length > 8 || newMember.memId.length < 4){
      alert('아이디는 4 ~ 8 글자여야 합니다.')
      return ;
    }

    axios.get(`/member/checkId/${newMember.memId}`)
    .then((res)=>{
      const result = res.data;
      alert(result ? '중복입니다' : '사용가능합니다')
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  //회원가입 데이터 전달
  function goJoin(){
    if(newMember.memName = ''){
      alert('이름은 필수입력입니다.')
      return
    }
    if(newMember.memPw != newMember.memPwChk){
      alert('비밀번호를 확인해주세요')
      return
    }else{
      axios.post('/member/insert',newMember)
      .then((res)=>{
        setIsShow(true);
        setJoinSuccess(true);
      })
      .catch((error)=>{
        console.log(error)
      })
    }
  }

  //모달창 안의 내용을 생성하는 함수
  function setModalContent(){
    return(
      <div>
        🎉회원가입이 완료되었습니다.🎉
      </div>
    )
  }

  function goNavigate(){
    navigate('/')
  }



  return (
    <div className='join-div'>
      <table className='join-table'>
        <tbody>
          <tr>
            <td>아이디<span>*</span></td>
            <td>
              <div className='inline-input'>
                <input type='text' name='memId' onChange={(e)=>{onChange(e)}}></input>
                <button type='button' onClick={()=>{joinChk()}}>중복확인</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>비밀번호<span>*</span></td>
            <td colSpan={2}>
              <input type='password' name='memPw'  onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>비밀번호확인<span>*</span></td>
            <td colSpan={2}>
              <input type='password' name='memPwChk'  onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>이름<span>*</span></td>
            <td colSpan={2}>
              <input type='text' name='memName'  onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>연락처</td>
            <td colSpan={2}>
              <input type='text' name='memTel' placeholder='숫자만 입력하세요.' onChange={(e)=>{onChange(e)}}></input>
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
        { joinSuccess && <Firecracker clickName='회원가입'/> }
      </div>
      {/* 회원가입 성공 시 열리는 모달 */}
      {
        isShow ? <Modal content={setModalContent} setShow={setIsShow} goNavigate={goNavigate}/> : null
      }
    </div>
  )
}

export default Join