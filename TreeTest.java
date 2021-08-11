package ssafy.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 *         0
 *         
 * 		1		 2
 * 
 * 	3	 4	 	5	 6
 * 
 * 	이차원 배열로 저장하는 방법 설명.
 *  인접행렬로 할 수 있음.
 *  이차원 배열에 갈 수 있는 부분은 1로표시한다. 
 *  
 * dfs 0 1 3 4 2 5 6
 * bfs 0 1 2 3 4 5 6
 * */


public class TreeTest {
	static int N = 7;
	static int[][] tree = new int[N][N];
	//static boolean[] check = new boolean[N];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tree[0][1] = tree[0][2] = 1;
		tree[1][3] = tree[1][4] = 1;
		tree[2][5] = tree[2][6] = 1;
		tree[1][0] = tree[2][0] = 1;
		tree[3][1] = tree[4][1] = 1;
		tree[5][2] = tree[6][2] = 1;
		
		//print(tree);
		
		//dfs(0, new boolean[N]);
		bfs(0);
	}

	private static void bfs(int idx) {
		// TODO Auto-generated method stub
		boolean[] v = new boolean[N];
		Queue<Integer> Q = new LinkedList<>();
		//일단 첫번째거를 큐에 담고, 큐가 빌때까지 하나씩 꺼내면서
		// 그 노드와 연결된 노드를 큐에 넣는다.
		
		Q.add(idx);
		v[idx] = true;
		
		while(!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.println(p);
			
			for (int i = 0; i < N; i++) {
				if (tree[p][i] == 1 && !v[i]) {
					Q.add(i);
					v[i] = true;
				}
			}
		}
	}

	private static void dfs(int idx, boolean[] v) {
		// TODO Auto-generated method stub
		v[idx] = true;
		System.out.print(idx);
		
		for (int i =0; i < N; i++) {
			if (tree[idx][i] == 1 && !v[i]) {
				dfs(i, v);
			}
		}
		
	}

	private static void print(int[][] tree2) {
		// TODO Auto-generated method stub
		for (int i= 0; i < tree.length; i++) {
			for(int j= 0; j < tree.length; j++) {
				System.out.print(tree[i][j]);
			}
			System.out.println();
		}
	}

}
