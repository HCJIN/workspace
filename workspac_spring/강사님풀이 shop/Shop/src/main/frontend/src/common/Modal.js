import React, { useRef } from 'react'

const Modal = ({content, setShow, clickClosebtn}) => {

  // content : 모달에서 보여지는 내용 
  // setShow : 모달을 닫는 코드
  // clickClosebtn : 모달의 확인버튼 클릭 시 실행할 코드

  const modalContainer = useRef();

  return (
    <div className='modal-container show' ref={modalContainer}>
      <div className='modal'>
        <div className='modal-header'>
          <span onClick={()=>{modalContainer.current.className = 'modal-container'; 
            setTimeout(()=>{
              setShow(false);
              clickClosebtn();
            },300)}}><i className="bi bi-x"></i></span> 
        </div>
        <div className='modal-content'>
          {content()}
        </div>
        <div className='modal-footer'>
          <button type='button' className='btn btn-primary' onClick={()=>{
            modalContainer.current.className = 'modal-container';
            setTimeout(()=>{
              //모달창 닫기
              setShow(false);
              //어떤 페이지에서 모달창을 실행했냐에 따라 실행 코드가 달라져야함
              clickClosebtn();
            },300); 
            }}>확인
          </button>
        </div>
      </div>
    </div>
  )
}

export default Modal