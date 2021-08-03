package hw_20210803;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class 달팽이숫자 {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File ("/Users/juhyang/SSAFY/hw/hw_20210803/src/hw_20210803/input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		
		for (int i = 1; i <= testCase; i++) {
			
			int N = sc.nextInt();
			int arr[][] = new int [N][N];
			
			int num = 1;
			int cnt = 0;
			int x = 0;
			int y = 0;
			
			while (num <= N*N) {

				for (int j = y; j < N-cnt; j++) {
					if (arr[x][j] == 0) {
						arr[x][j] = num;
						num++;
					}
					
					y = j;
				}

				for (int j = x; j < N-cnt; j++) {
					if (arr[j][y] == 0) {
						arr[j][y] = num;
						num++;
					}
					
					x = j;
				}
				
				for (int j = y; j >= 0+cnt; j--) {
					if (arr[x][j] == 0) {
						arr[x][j] = num;
						num++;
					}
					
					y = j;
				}
				
				for (int j = x; j > 0+cnt; j--) {
					if (arr[j][y] == 0) {
						arr[j][y] = num;
						num++;
					}
					x = j;
				}
				
				cnt++;
				
			}
			
			
			System.out.println("#"+i);
			for(int[] k : arr) {
				for (int l : k) {
					System.out.print(l+" ");
				}
				System.out.println();
			}
			
		}
		
	}
}
