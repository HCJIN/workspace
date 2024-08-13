import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';
import { useEffect, useState } from 'react';
import RegItem from './pages/admin/RegItem';
import ItemList from './pages/admin/ItemList';

function App() {

  const navigate = useNavigate();

  //로그인 정보를 저장 할 수 있는 state 변수
  const [loginInfo, setLoginInfo] = useState({});

  //로그인 성공 시 loginInfo에 로그인 정보를 저장하지만 
  //새로고침하면 App.js 다시 시작하면서 loginInfo 변수의 값이 초기화된다.
  //새로고침을 하더라도 sessionStorage에 로그인 정보는 존재하니,
  //새로고침 할때 만약 로그인 정보가 sessionStorage에 남아있다면
  //loginInfo state변수에 로그인 정보를 저장시켜야 함.
  useEffect(()=>{
    //세션에 저장된 로그인 정보 가져 옴
    const loginDataString = window.sessionStorage.getItem('loginInfo');


    if(loginDataString != null){
      //로그인 정보를 저장할 loginInfo에 저장
      //1. 세션에서 가져온 데이터를 객체로 변환
      const loginInfo = JSON.parse(loginDataString);

       //2. 로그인 정보를 loginInfo에 저장
      setLoginInfo(loginInfo);
    }
  },[])



  return (
    <div className="container">
      <div className='login-div'>
        <div className='logo' onClick={()=>{navigate('/')}}>Scream</div>
        {
          loginInfo.memId == null ? 
          <>
            <div className='login'>
              <span onClick={()=>{navigate('/loginForm')}}>login</span>
              <span onClick={()=>{navigate('/join')}}>join</span>
            </div>
          </> : 
          <div>{loginInfo.memId}님 반갑습니다
            <span  className='logout' onClick={(e)=>{
              //세션스토리지에 저장된 로그인 정보를 제거
              window.sessionStorage.removeItem('loginInfo')
              setLoginInfo({});
              alert('로그아웃 되었습니다');
              navigate('/')
            }}>Logout</span>
          </div>
        }

      </div>
      <div className='layout-div'>
        <Routes>
          {/* {일반 유저용} */}
          <Route path='/' element={<UserLayout/>}>
            {/* 상품 목록 화면 */}
            <Route path='' element={<ItemList />}/>
            {/* 회원 가입 페이지 */}
            <Route path='join' element={<Join />}/>
            {/* 로그인 페이지 */}
            <Route path='loginForm' element={<Login setLoginInfo={setLoginInfo} loginInfo={loginInfo}/>}/>
            {/* 상품 상세정보 페이지 */}
            <Route path='/detail/:itemCode' element={<div>상세정보</div>} />
          </Route>

          {/* {관리자용} */}
          <Route path='/admin' element={<AdminLayout />}>
            {/* 상품 관리 화면 */}
            <Route path='itemManage' element={<ItemManage />} />
            {/* 상품 등록 화면 */}
            <Route path='regItem' element={<RegItem />}/>
            {/* 카테고리관리 화면 */}
            <Route path='categoryManage' element={<CategoryManage />} />
            {/* 구매관리 화면 */}
            <Route path='saleHistoryOfMonth' element={<SaleHistoryOfMonth />} />
            {/* 유저관리 화면 */}
            <Route path='searchUser' element={<SearchUser />} />
            {/* 매출관리 화면 */}
            <Route path='recordOfMonth' element={<RecordOfMonth />} />
          </Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
