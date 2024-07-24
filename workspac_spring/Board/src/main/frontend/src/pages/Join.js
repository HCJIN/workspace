import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import * as memberApi from '../apis/memberApi'

const Join = () => {

  const navigate = useNavigate();

  //자바 데이터리스트 
  const [boardList, setBoardList] = useState([]);

  //버튼 활성화 여부 state 변수
  const [isDisabled, setIsDisabled] = useState(true);

  //새로운 아아디 생성될 빈 객체
  const [id, setid] = useState({
    memId : '',
    memPw : '',
    memName : '',
    gender : 'male'
  })
  
  //비밀번호 체크용 객체
  const [pwchk, setPwchk] = useState({ pw : ''})

  //자바에서 데이터 받아오기
  useEffect(() => {
    axios
    .get('/member/list')
    .then((res) => {
      setBoardList(res.data);
      console.log(res.data)
    })
    .catch((error) => {
      console.log(error)
    });
  }, []);

  //아이디에 input에 입력된 값 저장
  function onChange(e){

    //아이디 input 태그의 값이 변경되면 회원가입 버튼을 비활성화
    if(e.target.name == 'memId'){
      setIsDisabled(true);
      console.log(isDisabled)
    }

    //input 입력값 id 객체에 등록
    setid({
      ...id,
      [e.target.name] : e.target.value
    })
  }

  //비밀번호 확인용에 input 값 저장
  function pwchkChange(e){
    setPwchk({
      pw : e.target.value
    })
  }

  //아이디 중복여부 확인
  // function test(){

  //   const id_input = document.querySelector('input[name="memId"]')

  //   if(id_input.value ==''){
  //     alert('아이디를 입력하시오');
  //     id_input.focus();
  //     return;
  //   }
    
  //   let result = false;
  //   boardList.forEach((board)=>{
  //     if(board.memId == id.memId){
  //       result = true;
  //     }
  //   })

  //   if(result){
  //     alert("중복입니다.")
  //     setid({...id, memId : ''})
  //   }else{
  //     alert("사용가능합니다")
  //   }
  // }
  
  //강사님 아이디 중복 체크
  function test(){

    if(id.memId == ''){
      alert('아이디를 입력하세요.')
      return
    }

    //아이디 4~8글자
    if(id.memId.length > 8 || id.memId.length < 4){
      alert('아이디는 4 ~ 8 글자여야 합니다.')
      return ;
    }

    memberApi.chekId(id.memId)
    .then((res)=>{
      // ture -> 불가능
      // false -> 가능
      const result = res.data;
      // if(result){
      //   alert('중복입니다')
      // }else{
      //   alert('사용가능')
      // }
      alert(result ? '중복입니다' : '사용가능합니다')

      //사용 가능한 id면 버튼 활성화
      if(!result){
        setIsDisabled(false);
        console.log(isDisabled)
      }
    })
    .catch((error)=>{
      alert('중복확인오류')
      console.log(error)
    })
  }

  //회원가입 버튼 클릭시 작동
  function Join(){
    //validation 처리 (유효성 검사)
    
    const memName_input = document.querySelector('input[name="memName"]')
    
    //이름 입력했는지 여부 확인
    if(memName_input.value ==''){
      alert('이름을 입력하시오');
      memName_input.focus();
      return;
    }
    
    //비밀번호가 같다면 데이터 전송
    if(id.memPw === pwchk.pw){    
      axios
      .post(`/member/join`, id)
      .then((res)=>{
        alert("회원가입이 되었습니다.")
        navigate('/login')
      })
      .catch((error)=>{
        console.log(error)
      })
    }
    else{
      alert("비밀번호가 다릅니다")
    }
    

  }

  console.log(id)
  console.log(pwchk)

  

  return (
    <div className='join-div'>
      {/* <div className='login-div'>
        <span onClick={()=>{
          navigate('/login')
        }}>Login</span>
        <span>Join</span>
      </div> */}
      <span className='title'>자유게시판</span>
      <table className='join-table'>
        <tbody>
          <tr>
            <td className='name' colSpan={2}><p>아이디</p></td>
          </tr>
          <tr>
            <td>
              <input type='text' name='memId' value={id.memId} onChange={(e)=>{
                onChange(e)
              }}></input>
              <button className='btn' type='button'onClick={()=>{
                test()
              }}>중복확인</button>
            </td>
          </tr>
          <tr>
            <td><p>비밀번호</p></td>
          </tr>
          <tr>
            <td>
              <input type='password' name='memPw' value={id.memPw} onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td><p>비밀번호 확인</p></td>
          </tr>
          <tr>
            <td>
              <input type='password' value={pwchk.pw} onChange={(e)=>{pwchkChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td><p>이름</p></td>
          </tr>
          <tr>
            <td>
              <input type='text'  name='memName' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td className='gen'><p>성별</p>
              <label>
                <input 
                  type="radio" 
                  name='gender'
                  value="male" 
                  checked = {id.gender == "male"}
                  onChange={(e)=>{
                    onChange(e)
                  }}
                  
                  />
                남
              </label>
              <label>
                <input 
                  type="radio" 
                  name='gender'
                  value="female" 
                  checked ={id.gender == "female"}
                  onChange={(e)=>{
                    onChange(e);
                  }}
                  />
                여
              </label>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='join-btn'>
        <button type='button' className='btn' disabled={isDisabled} onClick={()=>{Join()}}>회원가입</button>
        {/* <button type='button' disabled={isDisabled}>연습용버튼</button> */}
      </div>
    </div>
  )
}

export default Join