import React, { useState } from 'react'

const Origin = () => {

  const [num, setNum] = useState(0);

  //+1 함수
  const addNum = () => {
    setNum(num + 1)
  }
  //-1 함수
  const removeNum = () => {
    setNum(num - 1)
  }
  //0으로 초기화 함수
  const resetNum = () => {
    setNum(0)
  }

  return (
    <div>
      <h3>카운터앱(기존방식)</h3>
      <h3>{num}</h3>
      <div>
        <button type='button' onClick={() => addNum()}>+1</button>
        <button type='button' onClick={() => removeNum()}>-1</button>
        <button type='button' onClick={() => resetNum()}>reset</button>
      </div>
    </div>
  )
}

export default Origin