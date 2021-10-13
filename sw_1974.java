package day_1013;
import java.util.*;
import java.io.*;

class sw_1974 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++) {
			
			int[][] arr = new int[9][9];
			
			for (int i=0; i <9;i++) {
				for(int j=0; j <9; j++) {
					arr[i][j] = sc.nextInt();
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			
			//int num = 1+2+3+4+5+6+7+8+9;
			
			boolean flag = true;
			
			//가로 
			for (int i=0; i <9; i++) {
				boolean[] num = new boolean[10];
				for (int j=0; j<9; j++) {
					num[arr[i][j]] = true;
				}
				
				int sum =0;
				for (int k=1; k <= 9; k++) {
					if(num[k]) {
						sum++;
					}
				}
				
				if (sum != 9) {
					flag = false;
				}
			}
			
			
			//세로
			for (int i=0; i <9; i++) {
				boolean[] num = new boolean[10];
				for (int j=0; j<9; j++) {
					num[arr[j][i]] = true;
				}
				
				int sum =0;
				for (int k=1; k <= 9; k++) {
					if(num[k]) {
						sum++;
					}
				}
				
				if (sum != 9) {
					flag = false;
				}
			}
			
			//네모
			
			for (int i=0; i<9; i+=3) {
				for (int j=0; j<9; j+=3) {
					
					boolean[] num = new boolean[10];
					for (int k =0; k <3; k++) {
						for (int l =0; l <3; l++) {
							int moveX = i+k;
							int moveY = j+l;
							
							num[arr[moveX][moveY]] = true;
						}
						
					}
					
					int sum =0;
					for (int k=1; k <= 9; k++) {
						if(num[k]) {
							sum++;
						}
					}
					
					if (sum != 9) {
						flag = false;
					}
					
				}
				
			}
			
			if (flag) {
				System.out.println("#"+t+" "+1);
			} else {
				System.out.println("#"+t+" "+0);
				
			}
		}
	}

}
