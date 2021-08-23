package day_0823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bj_2581 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			boolean flag = false;

			for (int j = 2; j < i; j++) {
				if (i%j == 0) flag = true;
				
			}
			
			if (!flag && i > 1) {
				sum+=i;  
				min = Math.min(min, i);
			}
		}
		
		if (sum != 0) {
			System.out.println(sum);
			System.out.println(min);
		} else {
			System.out.println(-1);
		}
		
	}

}
