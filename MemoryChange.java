package day_0802;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MemoryChange {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/input.txt");		
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		int cnt = 0;
		char c = '0';
		
		for (int t = 1; t <= testCase; t++) {
			String s = sc.next();

			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != c) {
					c = s.charAt(i);
					cnt++;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
