import React from 'react'
import '../header.css';
import { useNavigate } from 'react-router-dom';

const Header = () => {
  const navigate = useNavigate();

  return (
    <div className='header'>
      <ul className='menu-ul'>
        <li onClick={()=>{navigate('/')}}>
          <p>홈</p>
        </li>
        <li onClick={()=>{navigate('/management')}}>
          <p>차량관리</p>
        </li>
        <li onClick={()=>{navigate('/salesInfo')}}>
          <p>판매정보 등록</p>
        </li>
        <li onClick={()=>{navigate('/salesList')}}>
          <p>판매 목록</p>
        </li>
      </ul>
    </div>
  )
}

export default Header