// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {
	solution(line);
	rl.close();
}).on("close", function() {
	process.exit();
});

const solution = (line) => {
	let tmp = line.split(" ");
	//피자의 초기값
	let pizza = parseInt(tmp[0]);
	//가진 쿠폰 (초기 피자개수와 같음)
	let hasCupon = pizza;
	//피자를 바꿀 수 있는 쿠폰 개수 
	let k = parseInt(tmp[1]);
	
	//피자를 바꿀 수 없을때까지 반복
	while (hasCupon >= k) {
		let bonus = parseInt(hasCupon / k); //보너스로 먹는 피자 개수
		pizza += bonus; // 보너스만큼 먹는 피자개수를 더하고
		hasCupon = parseInt(hasCupon%k) + bonus; // 보너스 만큼 쿠폰을 더함
	}
	console.log(pizza);
}

//틀린 이유
// 급하게 읽느라 문제를 이해하지 못했다. 
