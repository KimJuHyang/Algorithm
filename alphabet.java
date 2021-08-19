package day_0819;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class alphabet {

	static int R,C;
	static char[][] map;
	static ArrayList<Character> check = new ArrayList<Character>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int max = -1;

	
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
		
		
		
		dfs(0,0,0);
		
		
		System.out.println(max);
		
	}

	private static void dfs(int r, int c, int cnt) {
		// TODO Auto-generated method stub
		
		if (check.contains(map[r][c])) {
			max = Math.max(max, cnt);
			return;
		} else {
			
			check.add(map[r][c]);
			
			
			for (int d =0; d < dc.length; d++) {
				int nr = r +dr[d];
				int nc = c +dc[d];
				
				//범위 안에 있고, 체크 배열안에 없을경우
				if (nr>=0 && nr< R && nc >=0 && nc < C ) {
						dfs(nr,nc,cnt+1);
			
				}
			}
			
			//이미 다 돌은 애 일경우	
			check.remove((check.indexOf(map[r][c])));
			
			
		}

		
	}
}
