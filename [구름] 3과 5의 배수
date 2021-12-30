// Run by Node.js

const readline = require("readline");
const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout
});

rl.on("line", function(line) {
	//console.log(line);
	let res = 0;
	
	for (i = 1; i <= line; i++) {
		if (i % 3 == 0 || i % 5 == 0) {
			res += i;
		}
	}
	
	console.log(res);
	rl.close();
}).on("close", function() {
	process.exit();
});
