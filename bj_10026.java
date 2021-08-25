package day_0825;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_10026 {
	static int N;
	static char[][] arr, noGreenArr;
	static boolean[][] mark, noGreenMark;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	static int cnt =0, cntNoGreen = 0;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

	
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		//일반 배열
		arr = new char[N][N];
		// 적록색약 배열
		noGreenArr = new char[N][N];
		// 일반 마크배열
		mark = new boolean[N][N];
		// 적록색약 마크배열
		noGreenMark = new boolean[N][N];
		
		
		for (int i =0; i<N; i++) {
			String s = sc.next();
			for (int j =0 ; j<N; j++) {
				
				//일반 배열
				arr[i][j] = s.charAt(j);
				
				if (s.charAt(j) == 'G') {
					noGreenArr[i][j] = 'R';
				} else {
					noGreenArr[i][j] = s.charAt(j);
				}
				
				//적록색약 배열
				
				//System.out.print(noGreenArr[i][j]);
			}
			//System.out.println();
		}
	
		
		
		
		//일반
		for (int i= 0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				
				if (!mark[i][j]) {
					bfs(i,j);
				}
				
			}
		}
		
		//적록색약
		for (int i=0; i<N; i++) {
			for (int j = 0; j<N; j++) {
				
				if (!noGreenMark[i][j]) {
					bfs2(i,j);
				}
			}
		}
		
		System.out.println(cnt + " "+ cntNoGreen);
	}

	
	//일반 사람 bfs
	private static void bfs(int x, int y) {
		
		cnt++;
		
		//큐 선언
		Queue<int[]> queue = new LinkedList<>();
		// 시작 정점을 넣어준다.
		queue.add(new int[] {x,y});
		// 방문 배열에 방문처리를 한다.
		mark[x][y] = true;
		
		//큐 탐색 시작
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			y = q[1];
			
			for (int i =0; i< dx.length; i++) {
				int moveX = x+dx[i];
				int moveY = y+dy[i];
				
				//경계처리, 방문하지 않은 값일 경우
				if (moveX>=0 && moveX <N && moveY >= 0 && moveY<N && !mark[moveX][moveY]) {
					
					// 둘이 같을경우 같은 범위다.
					if (arr[x][y] == arr[moveX][moveY]) {
						
						mark[moveX][moveY] = true;
						queue.add(new int[] {moveX, moveY});
						
					}
					
				}
				
			}
		}

	}
	
	//색약 bfs
	private static void bfs2(int x, int y) {
		// TODO Auto-generated method stub
		cntNoGreen++;
		
		//큐 선언
		Queue<int[]> queue = new LinkedList<>();
		// 시작 정점을 넣어준다.
		queue.add(new int[] {x,y});
		// 방문 배열에 방문처리를 한다.
		noGreenMark[x][y] = true;
		
		//큐 탐색 시작
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			x = q[0];
			y = q[1];
			
			for (int i =0; i< dx.length; i++) {
				int moveX = x+dx[i];
				int moveY = y+dy[i];
				
				//경계처리, 방문하지 않은 값일 경우
				if (moveX>=0 && moveX <N && moveY >= 0 && moveY<N && !noGreenMark[moveX][moveY]) {
					
					// 둘이 같을경우 같은 범위다.
					if (noGreenArr[x][y] == noGreenArr[moveX][moveY]) {
						
						noGreenMark[moveX][moveY] = true;
						queue.add(new int[] {moveX, moveY});
						
					}
					
				}
				
			}
		}
	}


}
