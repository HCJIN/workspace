import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';

const Join = () => {

  const navigate = useNavigate();

  const [choice, setChoice] = useState('');

  const choiceClick = (e) =>{
    setChoice(e.target.value);
  }

  const [boardList, setBoardList] = useState([]);
  const [id, setid] = useState({
    memId : '',
    memPw : '',
    memName : '',
    gender : ''
  })
  const [pwchk, setPwchk] = useState({ pw : ''})

  useEffect(() => {
    axios
    .get('/board/boardList')
    .then((res) => {
      setBoardList(res.data);
    })
    .catch((error) => {
      console.log(error)
    });
  }, []);

  function onChange(e){
    setid({
      ...id,
      [e.target.name] : e.target.value
    })
  }

  function pwchkChange(e){
    setPwchk({
      pw : e.target.value
    })
  }

  function test(){
    let result = false;
    boardList.forEach((board)=>{
      if(board.memId == id.memId){
        result = true;
      }
    })

    if(result){
      alert("중복입니다.")
      setid({memId : ''})
    }
  }

  function Join(){

    const memName_input = document.querySelector('input[name="memName"]')
    
    if(memName_input.value ==''){
      alert('이름을 입력하시오');
      memName_input.focus();
      return;
    }

    if(choice == 1){
      setid({
        gender : '남'
      })
    }else{
      setid({
        gender : '여'
      })
    }
    
    if(id.memPw == pwchk.pw){    
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
      <div className='login-div'>
        <span onClick={()=>{
          navigate('/login')
        }}>Login</span>
        <span>Join</span>
      </div>
      <p>자유게시판</p>
      <table className='join-table'>
        <tbody>
          <tr>
            <td className='name' colSpan={2}>아이디</td>
          </tr>
          <tr>
            <td>
              <input type='text' name='memId' value={id.memId} onChange={(e)=>{
                onChange(e)
              }}></input>
              <button type='button'onClick={()=>{
                test()
              }}>중복확인</button>
            </td>
          </tr>
          <tr>
            <td>비밀번호</td>
          </tr>
          <tr>
            <td>
              <input type='password' name='memPw' value={id.memPw} onChange={(e)=>{onChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인</td>
          </tr>
          <tr>
            <td>
              <input type='password' value={pwchk.pw} onChange={(e)=>{pwchkChange(e)}}></input>
            </td>
          </tr>
          <tr>
            <td>이름</td>
          </tr>
          <tr>
            <td>
              <input type='text'  name='memName' onChange={(e)=>{
                onChange(e)
              }}></input>
            </td>
          </tr>
          <tr>
            <td className='gen'>성별
              <label>
                <input 
                  type="radio" 
                  value="1" 
                  checked ={choice === "1"}
                  onChange={choiceClick}
                  />
                남
              </label>
              <label>
                <input 
                  type="radio" 
                  value="2" 
                  checked ={choice === "2"}
                  onChange={choiceClick}
                  />
                여
              </label>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='join-btn'>
        <button type='button' onClick={()=>{
          Join()
        }}>회원가입</button>
      </div>
    </div>
  )
}

export default Join