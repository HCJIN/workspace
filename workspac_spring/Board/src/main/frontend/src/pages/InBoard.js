import React from 'react'

const InBoard = () => {
  return (
    <div className='inBoard-div'>
      <table className='inBoard-table'>
        <tbody>
          <tr>
            <td>제목</td>
            <td>
              <input type='text' name='title'></input>
            </td>
          </tr>
          <tr>
            <td>내용</td>
            <td>
              <input id="content" type='text' name='content'></input>
            </td>
          </tr>
        </tbody>
      </table>
      <div className='footer-div'>
        <button type='button'>글등록</button>
      </div>
    </div>
  )
}

export default InBoard