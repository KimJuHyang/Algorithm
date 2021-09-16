package day_0916;
import java.io.*;
import java.util.*;

class Loc {
	int x, y;

	public  Loc(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Loc [x=" + x + ", y=" + y + "]";
	}
	
	
}

public class sw_9205 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		//핵심 > 도착점까지 1000미터ㅓ마다 편의점을 들려야함.
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int testCase= sc.nextInt();
		
		for (int t=0; t < testCase; t++) {
		
			
			// 편의점 개수는 N개이고, 우리는 상근이네집 / 페스티발좌표도 받아야하니까 +2
			int N = sc.nextInt()+2;
			
			// 4개의 좌표 ( 상근 집, 편의점 1, 편의점2, 페스티발)
			ArrayList<Loc> songdo = new ArrayList();
			
			for (int i = 0; i < N; i++) {
				songdo.add(new Loc(sc.nextInt(), sc.nextInt()));
			}
			
			// 1. 이차원 배열 만들기
			// 이차원 배열을 만드는 이유는 -> 다익스트라는 1차원 배열 / 플로이드와샬은 2차원배열 사용
			// 이차원 배열을 만들어서 연결되어있다면 true로 표시.
			// 1000 이하이면 맥주먹으면서 갈 수 있으므로, 연결되었다고 표시하기!!
			// 반대로, 1000 넘으면 갈 수 없는 곳 이므로 기본값 (false) 유지
			
			boolean[][] map = new boolean [N][N];
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					
					//두 거리가 1000 이하라면 연결되어있음(갈 수 있음) true 표
					if (distance(songdo.get(i), songdo.get(j)) <= 1000) {
						map[i][j] = true;
						map[j][i] = true;
					}
				}
			}
			
			// 2. 플로이드 와샬
			
			for(int k = 0; k < N; k++) {
	            for(int i = 0; i < N; i++) {
	                for(int j = 0; j < N; j++) {
	                	// 이웃한 애들이 연결되어있어서 경유지로 사용할 수 있는 경우 true
	                	// 페스티벌 까지 가능한 길을 모두 true
	                    if(map[i][k] && map[k][j]) {
	                        map[i][j] = true;
	                    }
	                }
	            }
	        }
			
			
			// 3. 상근이 집 좌표의 맨 마지막이 true면 갈수있다.
			// (즉 상근이네 집 - 도착지 부분) - 각 배열의 맨 마지막이 페스티벌 인덱스
			
			//System.out.println(Arrays.deepToString(map));
			System.out.println(map[0][N-1] ? "happy" : "sad");
		}
		
	}



	private static int distance(Loc d1, Loc d2) {
		return Math.abs(d1.x-d2.x) + Math.abs(d1.y-d2.y);
	}

}
