const chkAll = document.querySelector('#chk_all');
const menuAll = document.querySelectorAll('.menu');
const inputAll = document.querySelectorAll('input');

//전체선택/해제 시 전체선택 해제 기능
function checkAllMenu(){
  if(chkAll.checked){
    for(const input of inputAll){
      input.checked = true;
    }
  }else{
    for(const input of inputAll){
      input.checked = false;
    }
  }
}

function checkAllOption(e){
    const ul = e.nextElementSibling;
    const check = ul.querySelectorAll('input');
    console.log(check);
    if(e.checked){
      for(const chk of check){
        chk.checked = true;
      }
    }else{
      for(const chk of check){
        chk.checked = false;
      }
    }
}