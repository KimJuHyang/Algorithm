package day_0819;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class breadShop {

	static int R,C,cnt;
	static char[][] map;

	static int[] dr = {-1,0,1};
	static int[] dc = {1,1,1};
	
	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc= new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		
		for (int r = 0; r<R; r++) {
			String str=sc.next();
			for (int c = 0; c < C; c++) {
				map[r][c] = str.charAt(c);
			}
		}
		
		for (int i =0; i < R; i++) {
			dfs(i,0);
		}
		
		System.out.println(cnt);
		
	}

	private static boolean dfs(int r, int c) {
		// TODO Auto-generated method stub
		if (c  == C-1) { //마지막열에 도착
			cnt++;
			return true;
		}
		
		for (int d =0; d < dc.length; d++) {
			int nr = r +dr[d];
			int nc = c +dc[d];
			
			//범위 안에 있고, 건물이 아닐때만.
			if (nr>=0 && nr< R && nc >=0 && nc < C && map[nr][nc] == '.') {
				map[nr][nc] = 'o';
				
				if (dfs(nr,nc)) {
					return true;
				}
			}
		}
		
		//다탐색햇는데두 못가면 
		return false;
	}
}
