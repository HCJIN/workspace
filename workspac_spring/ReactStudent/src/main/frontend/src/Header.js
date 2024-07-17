import React from 'react'
import { useNavigate } from 'react-router-dom';

const Header = () => {

  
  const navigate = useNavigate();

  return (
    <div className='btn_box'>
      <button type='button' onClick={()=>{ 
        navigate('/') 

      }}>학생정보조회</button>
      <button type='button' onClick={()=>{ navigate('/inStudent') }}>학생등록</button>
      <button type='button' onClick={()=>{ navigate('/delStudent') }}>학생삭제</button>
      <button type='button' onClick={()=>{ navigate('/detail') }}>성적관리</button>
    </div>
  )
}

export default Header