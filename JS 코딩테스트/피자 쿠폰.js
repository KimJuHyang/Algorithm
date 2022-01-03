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
	let pizza = parseInt(tmp[0]);
	let hasCupon = pizza;
	let k = parseInt(tmp[1]);
	
	while (hasCupon >= k) {
		let bonus = parseInt(hasCupon / k);
		pizza += bonus;
		hasCupon = parseInt(hasCupon%k) + bonus;
	}
	console.log(pizza);
}
