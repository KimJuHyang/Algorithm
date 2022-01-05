// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {;
	solution(line);
	rl.close();
}).on("close", function() {
	process.exit();
});

const solution = (data) => {
	let res = -1;
	let tmp = data.split(" ");
	for (let i = tmp[0]; i <= tmp[1]; i++) {
		res = Math.max(doCal(i), res);
	}
	
	console.log(res);
}

function doCal(num) {
	let cnt = 1;
	while(num != 1) {
		if (num%2 == 0) {
			num = num/2;
		} else {
			num = num*3+1;
		}
		
		cnt++;
	}
	
	return cnt;
}
