package day_0929;
import java.io.*;
import java.util.*;

public class sw_5643 {
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		// 아이디어 및 시도한 방법
		// 나와작거나 크게 모든 정점이 연결되어있다면 가능
		
		// bfs -> 조건문 짜기 실패
		// dfs -> 시간초과
		// 플로이드 -> 작은 애들 플로이드 || 큰애들 플로이드 한 값(성공)
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int t =1; t <= testCase; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			
			int[][] arr = new int[N+1][N+1];
			int[][] reverseArr = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				// 테케에서 주어지는 나보다 작은애들 연결
				arr[a][b] = 1;
				// 반대로 나보다 큰 애들도 연결
				reverseArr[b][a] = 1;

			}
			
		
			//플로이드 두번하기. 왜냐? 작은애들에 대한 모든 정점 || 큰애들에 대한 모든 정점이 있어야 내 위치 파악 가능
			// 테케에서 주어진 작은애들만 하면 문제점 발생.. 사실 나보다 큰 애들이랑도 파악 가능하니까!!!
			for (int k =1; k <= N; k++) {
				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= N; j++) {
						
						if (arr[i][k] != 0 && arr[k][j] != 0) {
							arr[i][j] = 1;
						}
						
						if (reverseArr[i][k] != 0 && reverseArr[k][j] != 0) {
							reverseArr[i][j] = 1;
						}
					}
				}
			}
			
			
			int totalCnt = 0;
			
			// arr 배열과 reverse 배열을 or 연산을 할 배열. 최종 전체 연결 노드 상황을 보여준다. 
			int[][] or = new int[N+1][N+1];
			
			for (int i =1; i <= N; i++) {
				
				for (int j =1; j <= N; j++) {
					
					// 작은애들 플로이드 워셜 한 정점 || 내 큰 애들에 대한 정점 둘중 하나라도 1이면 해당 노드랑 연결된거임
					if (arr[i][j] == 1 || reverseArr[i][j] == 1) {
						or[i][j] = 1;
					}
					
				}
			
			}	
			
			
			// arr 배열과 reverse 배열을 or 연산을 할 배열. 최종 전체 연결 노드 상황을 보여준다. 
			
			
			for (int i =1; i <= N; i++) {
				
				for (int j =1; j <= N; j++) {
					
					System.out.print(arr[i][j]);
					
				}
				System.out.println();
			}	
			
			System.out.println();
			
			for (int i =1; i <= N; i++) {
				
				for (int j =1; j <= N; j++) {
					
					System.out.print(reverseArr[i][j]);
					
				}
				System.out.println();
			}
						
			
			for (int i =1; i <= N; i++) {
				int cnt = 0;	
				for (int j =1; j <= N; j++) {
					
					// 이 한줄 때문에 몇시간 고생.. 자기 자신인 경우는 제외.
					if (i == j) continue;
					
					// or 배열이 0이라면, 얘넨 연결되어있지 않으므로 작거나 크다는 것을 판단할 수 없음. 
					if (or[i][j] != 0) {
						cnt++;
					}
				
					// 연결된 노드 개수가 자기자신을 제외한 N-1 개이면 모두 연결되어서 판단가능.
					// 즉 토탈 카운트를 더해주어서 파악 가능한 애들 개수 추가
					if (cnt == N-1) totalCnt++;
					
				}
			
			}	
			
			System.out.println("#"+t+" "+totalCnt);
		}
	}

	

}
