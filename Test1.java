package day_0827;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test1 {
	static int cnt;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//빙고
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[5][5];
		
		for (int i = 0; i<5; i++) {
			for (int j= 0; j<5; j++) {
				arr[i][j] = sc.nextInt();
				//System.out.print(arr[i][j]);
			}
			//System.out.println();
		}
		
		cnt = 0;
		
		
		outer: for (int i =0; i<5; i++) {
			for (int j = 0; j<5; j++) {
				
				int res = 0;
				int num = sc.nextInt();
				++cnt;
				
				//빙고 처리
				loop: for (int k = 0; k < 5; k++) {
						for (int l = 0; l < 5; l++) {
							
							if (arr[k][l] == num) {
								arr[k][l] = 0;
								break loop;
							}

						}
					 }
				
				
				//빙고 검사(가로)
				
				for (int k = 0; k<5; k++) {
					int row = 0;
					for (int l = 0; l < 5; l++) {
						if (arr[k][l] == 0) {
							row++;
						}
					}
					
					if (row == 5) res++;
				}
				
				
				//빙고검사(세로)
				for (int k = 0; k<5; k++) {
					int col = 0;
					for (int l = 0; l < 5; l++) {
						if (arr[l][k] == 0) {
							col++;
						}
					}
					
					if (col == 5) res++;
				}
				
				//빙고검사(대각선 오른쪽)
				int cross1 = 0;
				for (int k = 0; k<5; k++) {
					if(arr[k][k] ==0) cross1++; 
				}
				
				if (cross1 == 5) res++;

				//빙고검사(대각선 왼쪽)
				int cross2 = 0;
				int tmp= 0;
				for (int k = 4; k>=0; k--) {
					if(arr[k][tmp] == 0) cross2++; 
					tmp++;
				}
				
				if (cross2 == 5) res++;
				
				
				//최종 빙고 
				if (res >= 3) {
					break outer;
				}
				
			}
		
		}
		
		System.out.println(cnt);
		
		
	}

}