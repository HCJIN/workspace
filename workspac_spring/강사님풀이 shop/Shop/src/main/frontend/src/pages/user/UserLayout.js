import React from 'react'
import { Outlet } from 'react-router-dom'

const UserLayout = () => {
  return (
    <div>
      <ul className='user-menu'>
        <li>전체상품</li>
        <li>인터넷/IT</li>
        <li>소설/에세이</li>
        <li>자기계발</li>
      </ul>
      <div>유저 전용 페이지 입니다.</div>
      <Outlet />
    </div>
  )
}

export default UserLayout