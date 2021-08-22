package day_0822;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class bj_4344 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int t = 0; t < N; t++) {
			
			int num = sc.nextInt();
			int sum = 0;
			int[] student = new int[num];
			for (int i = 0; i< num; i++) {
				int tmp = sc.nextInt();
				sum += tmp;
				student[i] = tmp;
			}
			
			int avg = sum/num;
			int cnt = 0;
			for (int i =0; i< num; i++) {
				if (student[i] > avg) {
					cnt++;
				} 
			}
			
			double res = (double) cnt / (double) num;
			System.out.println(String.format("%.3f", res*100)+"%");
		}
		
	}

}
