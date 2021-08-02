package day_0801;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class word {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/input.txt");		
		Scanner sc = new Scanner(file);
		
		Stack<String> stack = new Stack<>();
		String answer = "";
		boolean flag = false;
		
			String s  = sc.nextLine();
			//문자 마지막 표시
			s += "*";
			for (String c : s.split("")) {
				
				if (c.equals("<")) {
					while (!stack.empty()) answer += stack.pop();
					answer += "<";
					flag = true;
					continue;
				}
				
				if (c.equals(">")) {
					answer += ">";
					flag = false;
					continue;
				}
				
				//문자열 공백이거나, 문자의 마지막인경우 pop
				if (c.equals(" ") || c.equals("*") ) {
					while (!stack.empty()) answer += stack.pop();
					answer += " ";
					continue;
				}
				
				if (flag) {
					answer += c;
				} else {
					stack.push(c);
				}
			}
		System.out.println(answer);

	}
}
