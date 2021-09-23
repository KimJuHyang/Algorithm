package day_0923;

import java.util.*;
import java.io.*;

public class hw_1681 {
	
	static int[][] map;
	static int N;
	static int totalCnt = 999;
	public static void main(String[] args) throws FileNotFoundException {
		// 아이디어
		// 시도한 방법 : 
		// 1. BFS(가중치 잇어서안됨) 
		// 2. 플로이드 와샬 (1번으로 가는 길을 어떻게 해야할지 모르겠음)
		// 3. 조합(시간초과)
		// 4. DFS 백트래킹 << 해결
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner (System.in);
		
		N = sc.nextInt();
		
		map = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
			for (int j =1; j<=N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		//dfs 탐색 전에 시작부분 방문 체크해주기
		boolean[] check = new boolean[N+1];
		check[1] = true;
		dfs(1,1,check, 0);
	

		System.out.println(totalCnt);
	}
	
	
	// 총 몇번 돌았는지 깊이, 현재 내 위치, 체크배열, 누적 거리  
	private static void dfs(int depth, int idx, boolean[] check, int cnt) {
		
		
		if (depth == N) { // 깊이가 N만큼 - 즉 다 돌았을경우 1번 집 가야함
			
			//1번으로 가는길이 있을경우에만
			if (map[idx][1] != 0) {
				
				// 현재 누적 거리 + 1번 집 들리는 거리
				int temp = cnt+map[idx][1];
				
				// 더 작은값으로 갱신
				totalCnt = Math.min(totalCnt, temp);
			}
		}
		
		// 연결된 부분 탐색 시작
		for (int i = 1; i <= N; i++) {
			
			// 이부분 없으면 시간초과남. 이전의 누적거리 + 내 누적거리가 이미 최소값을 넘으면 제외
			if (cnt + map[idx][i] > totalCnt) continue;
			
			// 방문하지 않았고, 가는 길이 있을경우
			if (!check[i] && map[idx][i] != 0) {
				
				//방문표시
				check[i] = true;
				dfs(depth+1, i, check, cnt+map[idx][i]);
				//방문표시 제외. 다시갈수있음, 즉 모든경로를 탐색하도록 하기 위함
				check[i] = false;
			}
		}
		
	}

}
