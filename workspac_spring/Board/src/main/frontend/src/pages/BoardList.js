import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import * as boardApi from '../apis/boardApi';


const BoardList = () => {

  const navigate = useNavigate();

  const [boardList, setBoardList] = useState([]);
  const [loginInfo, setLoginInfo] = useState({});

  //검색 조건을 저장할 변수
  const [searchData, setSearchData] = useState({
    searchType : 'TITLE',
    searchValue : ''
  });

  function changeSearchData(e){
    setSearchData({
      ...searchData,
      [e.target.name] : e.target.value
    })
  }
  console.log(searchData)

  useEffect(()=>{
    boardApi.getBoardList(searchData)
    // getBoardList()
    .then((res)=>{
      setBoardList(res.data);
      console.log(res.data)
    })
    .catch((error)=>{
      console.log(error);
    })
  },[])

  useEffect(()=>{
    //로그인 여부 확인, 데이터 없으면 null 나옴
    const loginData = window.sessionStorage.getItem('loginInfo');

    //로그인 정보가 있으면...
    if(loginData != null){
      const result = JSON.parse(loginData);//json을 객체로 변환 
      setLoginInfo(result);//객체로 변환된 로그인 정보를 loginInfo 변수에 저장
    }
  },[])

  function search(){
    boardApi.getBoardList(searchData)
    .then((res)=>{
      setBoardList(res.data)
    })
    .catch((error)=>{
      console.log(error)
    })
  }

  return (
    <div className='boardList-div'>
      {/* <div className='login-div'>
        {
          loginInfo.memId == null ? 
          <>
            <span onClick={()=>{navigate('/login')}}>Login</span>
            <span onClick={()=>{navigate('/join')}}>Join</span>
          </> : 
          <div>{loginInfo.memId}님 반갑습니다
          <span onClick={(e)=>{
            window.sessionStorage.removeItem('loginInfo')
            setLoginInfo({});
          }}>Logout</span>
        </div>
        }
      </div> */}
      <p>자유게시판</p>
      <div className='btn-div'>
        <select name='searchType' value={searchData.searchType} onChange={(e)=>{changeSearchData(e)}}>
          <option value={'TITLE'}>제목</option>
          <option value={'MEM_ID'}>작성자</option>
        </select>
        <input type='text' name='searchValue' value={searchData.searchValue}
        onChange={(e)=>{changeSearchData(e)}}></input>
        <button type='button' onClick={(e)=>{
          search()
        }}>검색</button>
      </div>
      <table className='boardList-table'>
        <thead>
          <tr>
            <td>No</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
          </tr>
        </thead>
        <tbody>
          {
            boardList.length == 0 ? 
            <tr>
              <td colSpan={4}>등록된 게시글이 없습니다</td>
            </tr> :
            boardList.map((board, i)=>{
              return(
                <tr key={i}>
                  <td>{boardList.length - i}</td>
                  <td onClick={()=>{
                    navigate(`/detail/${board.boardNum}`)
                  }}>{board.title}</td>
                  <td>{board.memId}</td>
                  <td>{board.createDate}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className='footer-div'>
        {
          loginInfo.memId == null ?
            null :
            <button type='button' onClick={(e)=>{
              navigate('/inBoard')
            }}>글쓰기</button>
        }
      </div>
    </div>
  )
}

export default BoardList