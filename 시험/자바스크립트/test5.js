function addRow(){
	
	str='';
	str += '<tr>'
	str += `
	<td>
	<input type="text">
	</td>
	<td>
	<input type="text">
	</td>`
	str += '</tr>';
	
	document.querySelector('.stu-list tbody').insertAdjacentHTML('afterbegin', str);
}

function setData(){
	const socer = document.querySelectorAll('.stu-list input').value;
	console.log(socer)

	
}























// function setData(){
// 	const trs = document.querySelectorAll('.stu-list tbody tr');
	
// 	//총점
// 	let sum = 0;
// 	let max = 0;
// 	let max_index = 0; //점수가 가장 큰 tr의 index
	
// 	trs.forEach(function(tr_tag, index){
// 		const score = parseInt(tr_tag.querySelectorAll('input')[1].value);
// 		sum = sum + score;
		
// 		if(max < score){
// 			max = score;
// 			max_index = index;
// 		}
// 	});
	
// 	document.querySelector('#totalScore').value = sum;
	
// 	//1등 학생명
// 	document.querySelector('#firstName').value = trs[max_index].querySelectorAll('input')[0].value;
	
// 	//보충학습자들
// 	const avg = sum / trs.length;
	
// 	let names = '';
// 	for(const tr_tag of trs){
// 		const score = tr_tag.querySelectorAll('input')[1].value;
		
// 		if(parseInt(score) < 60){
// 			const name = tr_tag.querySelectorAll('input')[0].value;
// 			names = names + name + ' ';
// 		}
		
// 	}
	
// 	document.querySelector('#names').value = names;
	
// }




















