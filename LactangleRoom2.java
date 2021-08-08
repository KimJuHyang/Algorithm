package day_0806;

import java.io.*;
import java.util.*;
public class LactangleRoom2 {
	static int N;
	static int[][] board;
	static int maxCnt;
	static int minDot;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		
		int T = sc.nextInt();
		for (int t = 0; t <T; t++ ) {
		
			N = sc.nextInt();
			board = new int [N][N];
			
			maxCnt = -1;
			minDot = 99999;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					moving(i,j,0,1);
				}
			}
			
			System.out.println(minDot + " "+maxCnt);
		}
	}

	private static void moving(int i, int j, int start, int cnt) {
		// TODO Auto-generated method stub
		
		
		for (int l = 0; l < dx.length; l++) {
			int x = i+dx[l];
			int y = j+dy[l];
			
			if (x < 0 || y < 0|| x >= N || y >= N ) {
				continue;
			}
			
			//주변에 있음
			if ((board[i][j])+1 == board[x][y]) {
				if (start == 0) {
					moving(x,y,board[i][j],cnt+1);
				} else {
					moving(x,y,start,cnt+1);
				}
				
			} 
			
			if (cnt > maxCnt) {
				maxCnt = cnt;
				minDot = start;
			} else if (cnt == maxCnt) {
				if (minDot > start) {
					minDot = start;
				}
			}
		}
		
	}
	
	

}
