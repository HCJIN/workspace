import logo from './logo.svg';
import './App.css';
import { Route, Routes, useNavigate } from 'react-router-dom';
import Origin from './Origin';
import UseRedux from './UseRedux';
import Member from './Member';

//redux-toolkit 설치 명령어 : npm i @reduxjs/toolkit react-redux
//redux (redux-toolkit)에서 사용하는 용어
//store : 모든 컴포넌트를 저장하고 관리하는 저장소
//        하나의 프로젝트에는 하나의 store만 사용 가능
//Action : store에 저장된 state 변수의 값을 변경할 데이터
//Reducer : state 값을 변경하기 위해 실행되는 함수
//Dispatch : reducer를 실행시켜주는 함수

//useSelect() : store에 저장한 state변수값 가져오기
//useDispacth() : state변수의 값을 변경시키는 함수 호출
function App() {

  const navigate = useNavigate();

  return (
    <div className="App">
      <Routes>
        <Route path='/' element={
          <div>
            <h3 onClick={() => {navigate('/origin')}}>숫자카운터(기존방식)</h3>
            <h3 onClick={() => {navigate('/useRedux')}}>숫자카운터(redux사용)</h3>
          </div>
        } />
        <Route path='/origin' element={<Origin/>}></Route>
        <Route path='/useRedux' element={<UseRedux/>}></Route>
        <Route path='/member' element={<Member/>}></Route>
      </Routes>
    </div>
  );
}

export default App;
