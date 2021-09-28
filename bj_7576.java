package day_0924;
import java.util.*;
import java.io.*;

class Node {
	int x, y;

	public Node(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
}

public class bj_7576 {

	static int N, M;
	static int[][] arr;
	static int[][] depth;
	
	public static void main(String[] args) throws FileNotFoundException {
		

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		arr = new int[N][M];
		
		int flag = 0;
		
		for (int i = 0;  i< N; i++) {
			for (int j =0; j <M; j++) {
				
				arr[i][j] = sc.nextInt();
				
			}
		}
		
		bfs();
		
		int max = 0;
		
		// 다 채웟는지 검사
		for (int i =0; i < N; i++) {
			for (int j =0; j < M; j++) {
				if (arr[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
			
		}
		
		System.out.println(max-1);
	
	}

	static int[] dx = {1, 0, -1, 0 };
	static int[] dy = {0, 1, 0 , -1};
	
	private static void bfs() {
		
		Queue<Node> Q = new LinkedList();
		
		for (int i =0; i < N; i++) {
			for (int j =0; j < M; j++) {
				
				//동시다발적으로 시작해야하므로 1인 애들 모두 큐에 넣어주기.
				if (arr[i][j] == 1) {
					Q.add(new Node(i,j));
				}
				
			}

		}

		while(!Q.isEmpty()) {
			
	
			Node p = Q.poll();
		
			for (int i =0; i < dx.length; i++) {
				int moveX = p.x+dx[i];
				int moveY = p.y+dy[i];
				
					if (moveX >=0 && moveX < N && moveY >=0 && moveY < M && arr[moveX][moveY] == 0) {
						
						arr[moveX][moveY] = arr[p.x][p.y]+1;
						Q.add(new Node(moveX, moveY));
					
					}
			}
			
		}
		
		
		
	}

}
