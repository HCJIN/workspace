import React from 'react'
import { Outlet, useNavigate } from 'react-router-dom'

const UserLayout = () => {

  const navigate = useNavigate();

  return (
    <div>
      <div className='menu-div'>
        <ul className='user-menu'>
          <li onClick={()=>{navigate('/')}}>전체상품</li>
          <li>인터넷/IT</li>
          <li>소설/에세이</li>
          <li>자기계발</li>
        </ul>
      </div>
      <Outlet />
    </div>
  )
}

export default UserLayout