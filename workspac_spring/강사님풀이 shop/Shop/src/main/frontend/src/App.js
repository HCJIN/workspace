import './App.css';
import './reset.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import UserLayout from './pages/user/UserLayout';
import AdminLayout from './pages/admin/AdminLayout';
import Join from './pages/user/Join';
import Login from './pages/user/Login';

function App() {

  const navigate = useNavigate();


  return (
    <div className="container">
      <div className='login-div'>
        <div className='logo' onClick={()=>{navigate('/')}}>Scream</div>
        <div className='login'>
          <span onClick={()=>{navigate('/login')}}>login</span>
          <span onClick={()=>{navigate('/join')}}>join</span>
        </div>
      </div>
      <div className='layout-div'>
        <Routes>
          {/* {일반 유저용} */}
          <Route path='/' element={<UserLayout/>}>
            {/* 상품 목록 화면 */}
            <Route path='' element={<div>상품목록화면</div>}/>
            {/* 회원 가입 페이지 */}
            <Route path='join' element={<Join />}/>
            {/* 로그인 페이지 */}
            <Route path='login' element={<Login />}/>
          </Route>

          {/* {관리자용} */}
          <Route path='/admin' element={<AdminLayout />}>
            <Route path='test1' element={<div>상품등록페이지</div>}/>
          </Route>
        </Routes>
      </div>
    </div>
  );
}

export default App;
