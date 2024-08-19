import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';
import { useEffect, useState } from 'react';
import RegItem from './pages/admin/RegItem';
import ItemList from './pages/user/ItemList';
import Detail from './pages/user/Detail';
import ItemManage from './pages/admin/ItemManage';
import CategoryManage from './pages/admin/CategoryManage';
import SaleHistoryOfMonth from './pages/admin/SaleHistoryOfMonth';
import SearchUser from './pages/admin/SearchUser';
import RecordOfMonth from './pages/admin/RecordOfMonth';
import CartList from './pages/user/CartList';


//새로고침과 재랜더링은 다르다!!!
//새로고침하면 state 변수의 값이 전부 초기화 된다. 
//재랜더링하면 state 변수의 값은 보존된다.
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
    const sessionLoginInfo = window.sessionStorage.getItem('loginInfo');

    //세션에 로그인 정보가 있으면...
    if(sessionLoginInfo != null){
      //로그인 정보를 저장할 loginInfo에 저장
      //1. 세션에서 가져온 데이터를 객체로 변환
      const obj_loginInfo = JSON.parse(sessionLoginInfo);

      //2. 로그인 정보를 loginInfo에 저장
      setLoginInfo(obj_loginInfo);
    }
  },[])

  //빈 객체인지 확인하는 코드
  //Object.keys() -> 객체 안의 모든 키 값을 가져옴

  return (
    <div className="container">
      <div className='login-div'>
        {
          Object.keys(loginInfo).length == 0 
          ?
          <ul className='header-menu'>
            <li><span onClick={()=>{navigate('/loginForm')}}>LOGIN</span></li>
            <li><span onClick={()=>{navigate('/join')}}>JOIN</span></li>
          </ul>
          :
          <div className='login'>
            {loginInfo.memId} 님 반갑습니다
            <span onClick={()=>{
              //세션에 저장된 로그인 정보 삭제
              window.sessionStorage.removeItem('loginInfo');
              //loginInfo state 값을 바꿔줌
              setLoginInfo({});
              //상품 목록 페이지로 이동
              navigate('/')
            }}>Logout</span>
            <i className="bi bi-cart4" onClick={()=>{
              navigate('/cart')
            }}></i>
          </div>
        }
        <div className='banner'>
          <div>
            <img className='banner-img' src='http://localhost:8080/images/book-banner-3.png'/>
          </div>
          <div className='title-div' onClick={()=>{navigate('/')}}>BOOK SHOP</div>
        </div>
      </div>
      <div className='layout-div'>
        <Routes>
          {/* {일반 유저용} */}
          <Route path='/' element={<UserLayout/>}>
            {/* 상품 목록 화면 */}
            <Route path='' element={<ItemList />}/>
            {/* 회원가입 페이지 */}
            <Route path='join' element={<Join />} />
            {/* 로그인 페이지 */}
            <Route path='loginForm' 
            element={<Login setLoginInfo={setLoginInfo} loginInfo={loginInfo}/>}/>
            {/* 상품 상세정보 페이지 */}
            <Route path='detail/:itemCode' element={<Detail />} />
            {/* 장바구니 페이지 */}
            <Route path='cart' element={<CartList />} />
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
