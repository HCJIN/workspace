import React from 'react'
import './header.css';
import { useNavigate } from 'react-router-dom'

const Header = () => {

  const navigate = useNavigate();


  return (
    <div className='header_div'>
      <ul className='menu_list'>
        <li onClick={()=>{ navigate('/')}}>상품정보</li>
        <li onClick={()=>{ navigate('/insert')}}>상품등록</li>
        <li onClick={()=>{ navigate('/order')}}>주문하기</li>
        <li onClick={()=>{ navigate('/orderList')}}>주문목록</li>
      </ul>
    </div>
  )
}

export default Header