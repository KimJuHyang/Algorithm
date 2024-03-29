package day_1111;
import java.util.*;
import java.io.*;

class Loc{
	int x, y;

	public Loc(int x, int y) {
		
		this.x = x;
		this.y = y;
	}


}
public class bj_14502 {

	static int Max = -1;
	static int N,M;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[][] arr = new int[N][M];
		
		for(int i=0; i <N; i++) {
			for (int j=0; j <M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		//아이디어
		//벽을 랜덤으로 세우고, (하나는 고정, 2개는 랜덤으로 세우고) BFS를 돌려서 바이러스 퍼트리기
		//백트래킹으로 벽을 다시 세워가면서 안전구역 개수를 최대값으로 갱신해주기

		for (int i=0; i < N; i++) {
			for(int j=0; j<M; j++) {
				if (arr[i][j] == 0) {
					//빈칸이니까, 고정벽을 세움.
					arr[i][j] = 1;
					//고정 벽 1개와  랜덤벽 2개를 세우기 위한 함수 호출
					build(arr,  1);
					// 고정벽을 풀어준다.
					arr[i][j] = 0;
				}
				
			}
		}
		
		System.out.println(Max);
	}


	//랜덤으로 벽세우기
	private static void build(int[][] arr, int cnt) {
		// TODO Auto-generated method stub
		
		//벽을 3개 세웠으면, 바이러스 퍼트리기
		if (cnt == 3) {
			bfs(arr);
		} else {
		
			for(int i=0; i <N; i++) {
				for(int j =0; j <M; j++) {
					if (arr[i][j] == 0) {
						
						arr[i][j] = 1;
						build(arr, cnt+1); 
						// 여기서 리턴맞고 돌아온 상태는?
						// 고정벽 1개 + 랜덤벽 2개 세우고 안전구역  셈까지 완료한 상태.
						// 즉 고정 벽 하나는 그대로 - 나머지 2개만 다시 랜덤으로 세워야함
						// 그러기 위해서 벽 다시 되돌려주기
						arr[i][j] = 0;
					}
				}
			}
			
		}
		
	
	}

	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static void bfs(int[][] arr) {
		// TODO Auto-generated method stub
		
		// 기존에 깨끗한 배열에 벽을 계속 바꿔서 세워야하니까
		// 바이러스 퍼트리고 갯수세는 용도로 임시 배열 생성
		
		int[][] copy_map = new int[N][M];
		
		for (int i=0; i <N; i++) {
			for (int j=0;j < M; j++) {
				copy_map[i][j] = arr[i][j];
			}
		}
		
		Queue<Loc> Q = new LinkedList();
		
		//바이러스가 있는 부분 모두 큐에 담기
		for (int i=0; i <N; i++) {
			for (int j=0; j<M; j++) {
				if(copy_map[i][j] == 2) {
					Q.add(new Loc(i,j));
				}
			}
		}
		
		while(!Q.isEmpty()) {
			
			Loc p = Q.poll();
			
			for (int i=0; i <dx.length; i++) {
				int moveX = p.x+dx[i];
				int moveY = p.y+dy[i];
				
				if (moveX >=0 && moveX <N && moveY >=0 && moveY <M && copy_map[moveX][moveY] == 0) {
					Q.add(new Loc(moveX, moveY));
					copy_map[moveX][moveY] = 2;
				}
			}
		}
		
		//안전구역세기
		int count =0;
		
		for (int i=0; i <N; i++) {
			for (int j=0; j<M; j++) {
				if (copy_map[i][j] == 0) {
					count++;
				}
			}
		}
		
		//최대 안전구역 값을 찾기위해 갱신
		Max = Math.max(Max, count);
		
	}



}
