
function setAvgAge(){
  const ageNum = document.querySelectorAll('.ageTd');
  
  let sum = 0;
  let avg = 0;
  ageNum.forEach(function(e){
    let num1 = Number(e.textContent);
    sum += num1;
  });
  avg = sum / 3;
  console.log(avg);

  const result = document.querySelector('#resultTd');

  result.insertAdjacentHTML('beforeend',avg);
}