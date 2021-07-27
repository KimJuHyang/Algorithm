package day_0727;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassWord {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/day_0727/input.txt");
		Scanner sc = new Scanner(file);
		
		for (int t = 1; t <=10; t++) {
			int testCase = sc.nextInt();
			String s = sc.next();
			
			ArrayList<Character> list = new ArrayList<Character> ();
			for (int i = 0; i < s.length(); i++) {
				char temp = s.charAt(i);
				list.add(temp);
			}
			
			int idx = 0;
			while (true) {
				if (idx == list.size()-1) {
					break; }
				
				if (list.get(idx) == list.get(idx+1)) {
					list.remove(idx); 
					list.remove(idx);
					idx = 0;
				} else {
					idx++; }
			}
			System.out.print("#"+t+" ");
			for(Character i : list) { 
			    System.out.print(i);
			}
			System.out.println();
		}
		
	}
}
