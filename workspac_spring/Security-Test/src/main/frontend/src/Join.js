import axios from 'axios';
import React, { useState } from 'react'

const Join = () => {

  //입력한 회원정보를 저장할 State변수
  const [joinData, setJoinData] = useState({
    memId : '',
    memPw : '',
    memName : ''
  });

  //입력 태그에 값 입력할때마다 실행되는 함수
  const changeJoindata = (e) => {
    setJoinData({
      ...joinData,
      [e.target.name] : e.target.value
    })
  }

  //회원가입 버튼 클리 시 실행
  const join = () => {
    axios
    .post("/member/join", joinData)
    .then((res)=>{
      console.log('회원가입 성공')
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  console.log(joinData)

  return (
    <div>
      <h1>회원가입 페이지</h1>
      <div>
        아이디 : <input type='text' name='memId' onChange={(e)=>{changeJoindata(e)}}/>
      </div>
      <div>
        비번 : <input type='password' name='memPw' onChange={(e)=>{changeJoindata(e)}}/>
      </div>
      <div>
        이름 : <input type='text' name='memName' onChange={(e)=>{changeJoindata(e)}}/>
      </div>
      <div>
        <button type='button' onClick={()=>{join()}}>회원가입</button>
      </div>
    </div>
  )
}

export default Join