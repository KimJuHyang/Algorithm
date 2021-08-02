package algo_add;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/algo_add/src/input.txt");		
		Scanner sc = new Scanner(file);
		
		
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++) {
			
			int N = sc.nextInt();
			char[][] board = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				for(int j = 0; j < N; j++) {
					board[i][j] = temp.charAt(j);
				}
				
			}
			
			int[] dx = {-1,0,0,1};
			int[] dy = {0,1,-1,0};
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					
					
					if (board[i][j] == 'A' ) {
						
						
						for (int k = 0; k < dx.length; k++) {
							int x = i+dx[k];
							int y = j+dy[k];
							
							if (x < 0 || y < 0 || x >= N || y >= N)  {
								continue;
							}
							
							board[x][y] = 'X';
						}
						
						
					} else if (board[i][j] == 'B') {
						
						for (int k = 0; k < dx.length; k++) {
							int x = i+dx[k];
							int y = j+dy[k];
							
							if (x < 0 || y < 0 || x >= N || y >= N)  {
								continue;
							}
							
							board[x][y] = 'X';
							
							if (x*2 < 0 || y*2 < 0 || x*2 >= N || y*2 >= N)  {
								continue;
							}
							
							board[x*2][y*2] = 'X';
							
						}
						
					} else if (board[i][j] == 'C') {
						
						for (int k = 0; k < N; k++) {
							board[i][k] = 'X';
							board[k][j] = 'X';
						}
					}
				}
			}
			
			int cnt = 0;
			
			for (int i =0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					if (board[i][j] == 'H') {
						cnt++;
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
			
		}
		
	}
}
