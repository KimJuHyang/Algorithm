// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const input = [];

rl.on("line", function(line) {
	if(!line) {
		rl.close();
	} else {
		input.push(line);
	}
	
}).on("close", function() {
	solution(input);
	process.exit();
});

const solution = (data) => {
	let ready = data[2].split(" ");
	let eat = data[1].split(" ");
	
	let arr = [];
	for (let i =0; i < ready.length; i++) {
		arr.push([ready[i], eat[i]]);
	}
	
	// 먹는 시간이 긴 순서대로 정렬하기
	arr.sort((a,b) => b[1]-a[1]); 
	
	let start = 0;
	let end = 0;
	
	for(i of arr) {
		start += parseInt(i[0]); // 준비시간 
		end = start + parseInt(i[1]); // 준비시간 + 먹는시간
	}
	console.log(end);
}

//틀린이유
// 데우는 시간이 짧은 순서대로 정렬하는것이 아닌, 먹는시간이 긴 애들을 정렬해서 최대한 앞쪽으로 배치해야했다.
