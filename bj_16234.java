package day_1111;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;
import java.util.*;

class Loc {
	int x,y;

	public Loc(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
}

public class bj_16234 {

	static int N,L,R, type, day;
	static int[] areaSum;
	static int[] areaCnt;
	static int[][] check;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		//1. BFS로 연합을 표시한다.
		//2. 연합의 합, 개수를 배열에  저장한다.
		//3. 해당 값을 기반으로 연합의 인구를 재분배 한다.
		//4. 연합이 없을때까지 계속 반복한다.
		
		N = sc.nextInt();
		L = sc.nextInt();
		R = sc.nextInt();
		
		int[][] arr = new int[N][N];  // 기준이 될 배열
		check = new int[N][N]; //연합을 표시하고, 인구를 재분배 할 배열
		type = 1; // 연합의 수
		day = 0; // 인구 이동이 걸리는 날짜
		areaSum = new int[(N*N)+1]; // 각 연합의 인구 합
		areaCnt = new int[(N*N)+1]; // 각 연합의 인구 수
		
		for (int i =0; i<N; i++) {
			for (int j=0; j <N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			//연합을 표시하는 함수
			countArea(arr);
			
			// 연합의 수가 총 나라의 개수보다 크면 더이상 인구이동 불가. (type의 초기값이 1이므로 N*N 보다 클경우)
			// 즉 모든 칸이 인구이동 조건을 만족하지 못한경우 
			
			if(type > N*N) {
				// 최종 인구이동에 얼마나 걸렸는지 출력
				System.out.println(day);
				return;
			}
					
			//인구수 재분포
			restore();
			
			
			//재분포 한 값을 다시 기준 배열인 arr에 덮어쓰기
			for (int i=0; i < N; i++) {
				for (int j=0; j<N; j++) {
					arr[i][j] = check[i][j];
				} 
			};
			
			// 전역변수 초기화 작업
			type = 1;
			check = new int[N][N];
			areaSum = new int[(N*N)+1];
			areaCnt = new int[(N*N)+1];
			
			// 소요날짜 증가
			day++;
		}
		
		
	}

	private static void countArea(int[][] arr) {

		// 배열을 전체 탐색하며 국경선을 표시한다.
		// BFS 작업을 끝내고 돌아오면,  type을 늘려서 다시 BFS 호출
		// for 문은 연합이 모두 표시될때까지 돈다.
		// 이 메서드가 끝나게되면 arr에 연합이 같은 숫자로 표시된다.
		
		for (int i=0; i <N; i++) {
			for (int j=0; j<N; j++) {
				if (check[i][j] == 0) {
					isOpen(arr, i, j, type); 
					++type;
				}
			}
		}

	}


	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	private static void isOpen(int[][] arr, int x, int y, int type) {
		
		// 각 연합을 표시할 BFS 메서드
		
		Queue<Loc> Q = new LinkedList();
		Q.add(new Loc(x,y));
		
		check[x][y] = type; //연합의 시작점 표시
		areaSum[type] += arr[x][y]; //해당 연합에 인구 수 더하기
		areaCnt[type]++; // 해당 연합 개수 1추가
		
		while(!Q.isEmpty()) {
			
			Loc q = Q.poll();
			
			for (int i=0; i<dx.length; i++) {
				int moveX = q.x+dx[i];
				int moveY = q.y+dy[i];
				
				if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && check[moveX][moveY] == 0) {
					
					
					// 인구수의 차이가 L,R 사이에 있을때 (국경선이 열릴 조건을 만족할때)
					if ( L <= Math.abs(arr[q.x][q.y] - arr[moveX][moveY]) 
						&& R >= Math.abs(arr[q.x][q.y] - arr[moveX][moveY])) {
						
						check[moveX][moveY] = type; //몇번 연합인지 표시
						Q.add(new Loc(moveX, moveY));
						areaSum[type] += arr[moveX][moveY]; //해당 연합에 인구 수 더하기
						areaCnt[type]++;  // 해당 연합 개수 1추가
					} 
				}
			}
		}
	}
	
	private static void restore() {
		
		// 인구수 재분배 메서드
		// 해당 타입의 연합군 인구수 배열 / 해당 타입의 연합군 인구수 개수
		for (int i=0; i <N; i++) {
			for (int j=0; j <N; j++) {
				
				check[i][j] = areaSum[check[i][j]]/areaCnt[check[i][j]];
				
			}
		}
		
		
	}

}
