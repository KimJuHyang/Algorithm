package day_0824;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class sw_7465 {

	static int[] person;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner (System.in);
		
		int tc = sc.nextInt();
		
		
		for (int t = 1; t <= tc; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			N = N+1;
			person = new int[N];
			
			//make
			for (int i = 1; i < N; i++) {
				person[i] = i;
				//System.out.print(person[i] + " ");
			}
			//System.out.println();
			
			
			//union
			for (int i= 0; i <M; i++) {
				union(sc.nextInt(), sc.nextInt());
			}
			
			int[] res = new int[N];
			int cnt = 0;
			
			for (int i =1; i<N; i++) {
				find(i);
			}
			
			for (int i =1; i<N; i++) {
				++res[person[i]];
				if (res[i] != 0) cnt++;
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

	private static void union(int my, int freind) {
		// TODO Auto-generated method stub
		int myRoot = find(my);
		int freindRoot = find(freind);
		
		if (myRoot != freindRoot) person[freindRoot] = myRoot;
		
	}

	private static int find(int a) {
		// TODO Auto-generated method stub
	
		if (a == person[a]) return a;
		
		return person[a] = find(person[a]);
	}

}
