import logo from './logo.svg';
import './App.css';
import { Route, Routes } from 'react-router-dom';
import BoardList from './BoardList';
import AxiosTest from './AxiosTest';
import Detail from './Detail';
import WriteForm from './WriteForm';
import Join from './Join';

function App() {
  return (
    <div className="App">

      <Routes>

        {/* axios 예제 페이지 */}
        <Route path='/axios' element ={<AxiosTest />}/>

        {/* 게시글 목록 페이지 */}
        <Route path='/' element={<BoardList />}/>

        {/* 상세 정보 페이지 */}
        <Route path='/detail/:boardNum' element={<Detail />}/>

        {/* 글쓰기 페이지 */}
        <Route path='/writeForm' element={<WriteForm />}/>

        {/* 글수정 페이지 */}
        <Route path='/join/:boardNum' element={<Join />}/>

      </Routes>
    </div>
  );
}

export default App;
