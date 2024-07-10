function setTable(){

  // 행의 값을 가져오기
  const row = document.querySelector('#rowInput').value;
  console.log(`행의 값 : ${row}`);
  //열의 값을 가져오기
  const col = document.querySelector('#colInput').value;
  console.log(`열의 값 : ${col}`)

  //행과 열 표시될 값
  let rowCnt = 0; 
  let colCnt = 0;

  //입력될 태그 값
  let tag = '';

  //반복
  for(let i = 1; i <= row; i++){
    tag += '<tr>'
    for(let j = 1; j <= col; j++){
      tag += `
        <td>
          ${rowCnt + i}행${colCnt + j}열
        </td>
      `;
    }
    tag += '</tr>';
  }

  //들어갈 태그
  const inDiv = document.querySelector('.table-div');
  inDiv.innerHTML = '';
  
  const table = `
    <table>
      ${tag}
    </table>
  `;
  
  inDiv.insertAdjacentHTML('beforeend',table)





}