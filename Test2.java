package day_0827;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//세로로말해요
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		
		for (int t =1; t<= N; t++) {
			
			char[][] arr = new char[5][15];
			String res = "";
			
			for (int i =0; i<5; i++) {
				for (int j=0; j<15; j++) {
					arr[i][j] = '*';
				}
			}
			
			for (int i= 0; i < 5; i++) {
				
				String s = sc.next();
				for(int j = 0; j < s.length(); j++) {
					
					arr[i][j] = s.charAt(j);
					
					
				}
				
				
			}
			
			
			

			for (int j = 0; j<15; j++) {
				for (int i = 0; i <5; i++) {
					
						if (arr[i][j] != '*') res += arr[i][j];
				}
			}
			
			
			System.out.println("#"+t+" "+res);
		}
		
		
		
		
	}

}
