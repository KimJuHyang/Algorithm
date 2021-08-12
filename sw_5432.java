package day_0812;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class sw_5432 {

	private static final Readable File = null;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File ("input.txt");
		Scanner sc = new Scanner(file);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			Stack<String> stack = new Stack<String>();
			
			int cnt =0;
			String[] s = sc.next().split("");
			
			for(int i = 0; i < s.length; i++) {
				if (s[i].equals("(")) {
					if (s[i+1].equals(")")) {
						cnt += stack.size();
						i++;
						continue;
					}
					stack.push(s[i]);
				} else {
					stack.pop();
					cnt += 1;
				}
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
