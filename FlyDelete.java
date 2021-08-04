package day_0804;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FlyDelete {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File ("FlyDelete_input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		
		
		for ( int t = 1; t <= testCase; t++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] map = new int[N][N];
			
			for (int i = 0 ; i <N; i++) {
				for (int j = 0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			
			for (int i = 0; i < N-M+1; i++) {
				for (int j = 0; j < N-M+1; j++) {
						int sum = 0;
						
						if (i+M < N && j+M < N) {
							for (int k = 0; k < M; k++) {
								for (int l = 0; l < M; l++) {
									sum += map[i+k][j+l];
								}
								
							}
						}
						
						if (sum > max) max = sum;
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
		
		
	}

}
