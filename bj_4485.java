package day_0929;
import java.io.*;
import java.util.*;

class Loc {
	int x, y;

	public Loc(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}

	@Override
	public String toString() {
		return "Loc [x=" + x + ", y=" + y + "]";
	}

	
}

public class bj_4485 {
	static int N, Ans;
	static int[][] map, dis;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
	
		int cnt = 0;
		
		while (true) {
		
			++cnt;
			
			N = sc.nextInt();
			
			if (N == 0) {
				return;
			}
			
			map = new int[N][N];
			dis = new int[N][N];
			//check = new boolean[N][N];
			Ans = 0;
			
			for(int i =0; i<N; i++) {
			
				for (int j =0; j <N; j++) {
					
					map[i][j] = sc.nextInt();
					dis[i][j] = 9999999;
					
				}
				
			}
			
		

			dis[0][0] = map[0][0];
			bfs(0,0);
			System.out.println("Problem "+cnt+ ": " + dis[N-1][N-1]);
			
			
		}
		
	
		
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	private static void bfs(int x, int y) {
		Queue<Loc>  Q = new LinkedList();
		Q.add(new Loc(x,y));
		
		
		while(!Q.isEmpty()) {
			Loc p = Q.poll();
			
			for (int i =0;  i<dx.length; i++) {
				
				int moveX = p.x+dx[i];
				int moveY = p.y+dy[i];
				
				if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && dis[moveX][moveY] > dis[p.x][p.y] + map[moveX][moveY] ) {
					
					dis[moveX][moveY] = dis[p.x][p.y] + map[moveX][moveY];
					Q.add(new Loc(moveX,moveY));
					
				}
			}
	
		}
	}
	
}
