import logo from './logo.svg';
import './reset.css'
import './App.css';
import { Route, Routes } from 'react-router-dom';
import Header from './Header';
import StudentList from './StudentList';
import InStudent from './InStudent';
import Score from './Score';
import Inscore from './Inscore';
import StuDelete from './StuDelete';
import Detail from './Detail';
import * as api from './apis';

function App() {
  return (
    <div className="App">

      <Header />
      {/* header_end */}

      <Routes>
        {/* 메인페이지 */}
        <Route path='/' element={<StudentList />}/>
        {/* 학생등록 페이지 */}
        <Route path='/inStudent' element={<InStudent />}/>
        {/* 학생삭제 페이지 */}
        <Route path='/delStudent'  element={<StuDelete />}/>
        {/* 성적관리 페이지 */}
        <Route path='/detail' element={<Score />}/>
        {/* 성적입력 페이지 */}
        <Route path='/inScore/:stuNum' element={<Inscore />}/>
        {/* 상세 페이지 */}
        <Route path='/detail/:stuNum' element={<Detail />}/>
      </Routes>
    </div>
  );
}

export default App;
