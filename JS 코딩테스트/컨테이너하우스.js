// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

const input = [];

rl.on("line", function(line) {
	if (!line) {
		rl.close();
	} else {
		input.push(line);
	}
	
}).on("close", function() {
	solution(input);
	process.exit();
});

const solution = (data) => {
	
	let arr = [];
	for (let i = 1; i < data.length; i++) {
		arr.push(data[i]);
	}
	
	//절댓값으로 정렬
	arr.sort((a,b) => Math.abs(a)-Math.abs(b));
	
	//규칙 - 양,음 번갈아서 나와야함.
	let res = [];
	
	for (i of arr) {
		if (res.length === 0) {
			res.push(i);
		} else {
			//현재 맨 위가 음수면 양수여야함
			if (res[res.length-1] < 0 && i > 0 ) {
				res.push(i);
			// 맨위가 양수면 음수여야함
			} else if (res[res.length-1] >0 && i <0 ) {
				res.push(i);
			} else {
				continue;
			}
		}
	}
	
	console.log(res.length);
}
