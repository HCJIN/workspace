import React, { useRef, useState } from 'react'
import '../user/join.css';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Home from '../../common/Firecracker';
import Modal from '../../common/Modal';
import Firecracker from '../../common/Firecracker';

const Join = () => {

  const navigate = useNavigate();

  const [show, setShow] = useState(false);

  //daum 주소 api 팝업창을 띄우기 위한 함수 선언
  const open = useDaumPostcodePopup();

  //주소 검색 팝업창이 닫힐 때 실행되는 함수
  function handleComplete(data){
    //우편번호
    let zonecode = data.zonecode;
    //도로명주소
    let roadAddress = data.roadAddress

    //input 태그에 검색한 내용 넣어주기
    setJoinData({
      ...joinData,
      post : data.zonecode,
      memAddr : roadAddress
    })
  }
  
  //검색 버튼 클릭시 실행되는 함수
  function handleClick(){
    open({onComplete : handleComplete});
  }

  const email_1 = useRef();
  const email_2 = useRef();

  //회원 강비 쿼리 시 가져갈 데이터
  const [joinData, setJoinData] = useState({
    memId : '',
    memPw : '',
    confirmPw : '1',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  function changeJoinData(e){
    //이메일을 변경했으면...(삼항연산자)
    setJoinData({
      ...joinData,
      [e.target.name] : e.target.name != 'memEmail' ? 
      e.target.value :
      email_1.current.value + email_2.current.value
    })

    //이메일을 변경했으면...(if문)
    // if(e.target.name == 'memEmail'){
    //   setJoinData({
    //     ...joinData,
    //     [e.target.name] : email_1.current.value + email_2.current.value
    //   })
    // }else{
    //   setJoinData({
    //     ...joinData,
    //     [e.target.name] : e.target.value
    //   })
    // }
  }
  console.log(joinData)

  //회원가입 버튼 클릭 시 insert 쿼리 실행하러 가기
  function join(){
    axios.post('/api_member/join',joinData)
    .then((res)=>{
      setShow(true)
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

  function goNavigate(){
    navigate('/')
  }

  return (
    <div className='join-div'>
      <div>
        <table className='join-table'>
          <tbody>
            <tr>
              <td>아이디</td>
              <td>
                <div className='inline-input'>
                  <input type='text' className='form-control' name='memId' onChange={(e)=>{changeJoinData(e)}}></input>
                  <button type='button' className='btn btn-primary'>중복확인</button>
                </div>
              </td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td>
                <input type='password' className='form-control' name='memPw' onChange={(e)=>{changeJoinData(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td>
                <input type='password' className='form-control' name='confirmPw' onChange={(e)=>{changeJoinData(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>이름</td>
              <td>
                <input type='text' className='form-control' name='memName' onChange={(e)=>{changeJoinData(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td>
                <input type='text' placeholder='숫자만 입력하세요' className='form-control' name='memTel' onChange={(e)=>{changeJoinData(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>주소</td>
              <td>
                <div className='inline-input'>
                  <input type='text' placeholder='우편번호' className='form-control' name='post' onChange={(e)=>{changeJoinData(e)}} value={joinData.post} readOnly={true} onClick={handleClick}></input>
                  <button type='button' className='btn btn-primary' onClick={handleClick}>주소검색</button>
                </div>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input type='text' placeholder='주소' className='form-control' value={joinData.memAddr} name='memAddr' onChange={(e)=>{changeJoinData(e)}} readOnly={true} onClick={handleClick}></input>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <input type='text' placeholder='상세주소' className='form-control' name='addrDetail' onChange={(e)=>{changeJoinData(e)}}></input>
              </td>
            </tr>
            <tr>
              <td>이메일</td>
              <td>
                <div className='inline-select'>
                  <input type='text' className='form-control' ref={email_1} name='memEmail' onChange={(e)=>{changeJoinData(e)}}></input>
                  <select className='form-control' ref={email_2} name='memEmail' onChange={(e)=>{changeJoinData(e)}}>
                    <option value={'@naver.com'}>naver.com</option>
                    <option value={'@gmail.com'}>gmail.com</option>
                  </select>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <div className='btn-div'>
        <button type='button' className='btn btn-primary' onClick={()=>{join()}}>회원가입</button>
      </div>
      {/* 회원가입 성공 시 열리는 모달 */}
      {
        show ? <Modal isShow={show} content={setModalContent} goNavigate={goNavigate} setShow={setShow}/> : null
      }
    </div>
  )
}

export default Join