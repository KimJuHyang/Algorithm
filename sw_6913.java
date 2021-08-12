package day_0812;

import java.util.*;
import java.io.*;

public class sw_6913 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File ("input.txt");
		Scanner sc = new Scanner(file);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][M];
			int[] cnt = new int[N];
			int max = -1, p = 0;
			
			for (int i= 0; i < N; i++) {
				for (int j =0; j<M; j++) {
					arr[i][j] = sc.nextInt();
					if (arr[i][j] == 1) cnt[i]++;				
				}
			}
			
			for (int i : cnt) {
				if (max < i) {
					p = 0;
					max = i;
					p++;
				} else if (max == i) p++;
			}
			
			System.out.println("#"+t+" "+p+" "+max);
		}
	}

}
