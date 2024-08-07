import React, { useRef, useState } from 'react'
import '../../css/join.css';
import { useDaumPostcodePopup } from 'react-daum-postcode';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import Modal from '../../common/Modal';
import Firecracker from '../../common/Firecracker';
import { joinValidate } from '../../validate/joinValidate';

const Join = () => {
  //id 중복 체크 여부를 저장할 변수
  const [isCheckId, setIsChecId] = useState(false);

  const navigate = useNavigate();

  //모달창 불린 유무
  const [show, setShow] = useState(false);

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
    confirmPw : '',
    memName : '',
    memTel : '',
    post : '',
    memAddr : '',
    addrDetail : '',
    memEmail : ''
  });

  const memId_valid_tag = useRef();
  const memName_valid_tag = useRef();
  const confirmPw_valid_tag = useRef();
  const memPw_valid_tag = useRef();
  const memTel_valid_tag = useRef();
  

  //ref 태그들을 한번에 배열로 가져가기
  const valid_tag = [
    memId_valid_tag,
    memPw_valid_tag,
    confirmPw_valid_tag, 
    memName_valid_tag, 
    memTel_valid_tag
  ];

  function changeJoinData(e){
    //입력한 데이터
    const newData = {
      ...joinData,
      [e.target.name] : e.target.name != 'memEmail' ? 
      e.target.value :
      email_1.current.value + email_2.current.value
    }

    //입력한 데이터에 대한 validation 처리
    // 모든 데이터가 유효한 데이터면 리턴 true
    const result = joinValidate(newData, valid_tag, e.target.name);
    setValidResult(result);

    //유효성 검사 끝난 데이터를 joinData에 저장 // 이메일을 변경했으면...(삼항연산자)
    setJoinData(newData);

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

  const triggerConfetti = Firecracker();

  //회원가입 버튼 클릭 시 insert 쿼리 실행하러 가기
  function join(){
    if(!validResult){
      alert('입력 데이터를 확인하세요.')
      return;
    }

    //id중복 검사 했는지 확인
    if(!isCheckId){
      alert('ID 중복검사 후 가입 하세요.');
      return;
    }

    axios.post('/api_member/join',joinData)
    .then((res)=>{
      //모달창 띄움
      setShow(true);
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

  //중복확인 버튼 클릭 시 실행
  function isEnableId(){
    axios.get(`/api_member/isEnableId/${joinData.memId}`)
    .then((res)=>{
      console.log(res.data)
      if(res.data){
        alert('사용 가능한 ID 입니다')
        setIsChecId(true);
      }else{
        alert('중복된 ID 입니다.')
      }
    })
    .catch((error)=>{
      console.log(error)
    })
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
                  <input type='text' className='form-control' name='memId' onChange={(e)=>{
                    changeJoinData(e);
                    setIsChecId(false);
                    }}></input>
                  <button type='button' className='btn btn-primary' onClick={()=>{isEnableId()}}>중복확인</button>
                </div>
                <div className='feedback' ref={memId_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td>
                <input type='password' className='form-control' name='memPw' onChange={(e)=>{changeJoinData(e)}}></input>
                <div className='feedback' ref={memPw_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td>비밀번호 확인</td>
              <td>
                <input type='password' className='form-control' name='confirmPw' onChange={(e)=>{changeJoinData(e)}}></input>
                <div className='feedback' ref={confirmPw_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td>이름</td>
              <td>
                <input type='text' className='form-control' name='memName' onChange={(e)=>{changeJoinData(e)}}></input>
                <div className='feedback' ref={memName_valid_tag}></div>
              </td>
            </tr>
            <tr>
              <td>연락처</td>
              <td>
                <input type='text' placeholder='숫자만 입력하세요' className='form-control' name='memTel' onChange={(e)=>{changeJoinData(e)}}></input>
                <div className='feedback' ref={memTel_valid_tag}></div>
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
        <div className='btn-div'>
          <button onClick={join} className='btn btn-primary'>
            회원가입
          </button>
        </div>
        {/* 회원가입 성공 시 열리는 모달 */}
        {
          show ? <Modal content={setModalContent} setShow={setShow} clickClosebtn={onClickModalBtn}/> : null
        }
      </div>
    </div>
  )
}

export default Join