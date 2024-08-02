import React from 'react'

const Modal = ({content, setShow, goNavigate}) => {
  return (
    <div className='modal-container show'>
      <div className='modal'>
        <div className='modal-header'>
          <span onClick={()=>{modalContainer.current.className = 'modal-container'; setTimeout(()=>{setShow(false)},300)}}><i className="bi bi-x"></i></span>  
        </div>
        <div className='modal-content'>
          {content()}
        </div>
        <div className='modal-footer'>
          <button type='button' className='btn btn-primary' onClick={()=>{
            modalContainer.current.className = 'modal-container';
            setTimeout(()=>{
              setShow(false)
            },300); goNavigate();
            }}>확인</button>
        </div>
      </div>
    </div>
  )
}

export default Modal