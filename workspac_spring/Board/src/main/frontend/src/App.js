import logo from './logo.svg';
import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import BoardList from './pages/BoardList';
import Join from './pages/Join';
import Login from './pages/Login';
import InBoard from './pages/InBoard';
import { useEffect, useState } from 'react';
import Detail from './pages/Detail';
import Update from './pages/Update';

function App() {

  const [loginInfo, setLoginInfo] = useState({});
  const navigate = useNavigate();

  useEffect(()=>{
    const loginDataString = window.sessionStorage.getItem('loginInfo');

    if(loginDataString != null){
      const loginData = JSON.parse(loginDataString);
      setLoginInfo(loginData);
    }
  },[]);

  return (
    <div className="App">
      <div className='login-div'>
        {
          loginInfo.memId == null ? 
          <>
            <span onClick={()=>{navigate('/login')}}>Login</span>
            <span onClick={()=>{navigate('/join')}}>Join</span>
          </> :
          <div>{loginInfo.memId}님 반갑습니다
            <span onClick={(e)=>{
              //세션스토리지에 저장된 로그인 정보를 제거
              window.sessionStorage.removeItem('loginInfo')
              setLoginInfo({});

              alert('로그아웃')

              navigate('/')
            }}>Logout</span>
          </div>
          
        }
      </div>
      <Routes>
        <Route path='/' element={<BoardList />}/>
        <Route path='/join' element={<Join />}></Route>
        <Route path='/login' element={<Login loginInfo={loginInfo} setLoginInfo={setLoginInfo}/>}/>
        <Route path='/inBoard' element={<InBoard />}/>
        <Route path='/detail/:boardNum' element={<Detail />}/>
        <Route path='/update/:boardNum' element={<Update />} />
      </Routes>

    </div>
  );
}

export default App;
