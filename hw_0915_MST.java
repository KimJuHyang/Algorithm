package day_0915;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class hw_0915_MST {
	
	static class Edge implements Comparable<Edge>{
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			// return Integer.compare(this.weight, o.weight); 간선의 부호가 모두 같을때
			return Integer.compare(this.weight, o.weight);
			//앞쪽에 있는게 기준임.
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
		
		
	}
	
	static int[] parents;
	
	private static void make() {
		parents = new int[V];
		
		for (int i =0; i <V; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if ( a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		
		int aRoot = find(a-1);
		int bRoot = find(b-1);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot; //b를a밑에 붙인다.
		return true;
	}
	
	static int V,E;
	static Edge[] edgeList;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		for (int t =1; t <= testCase; t++) {
			
			
			V = sc.nextInt(); //정점 개수
			E = sc.nextInt(); //간선 개수
			
			//간선리스트를 만들어야겠다.
			
			edgeList = new Edge[E];
			
			for (int i =0; i<E; i++) {
				edgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
				//System.out.println(edgeList[i]);
			}
			
			Arrays.sort(edgeList); //오름차순 정렬
		
			
			make(); // 모든 정점을 각각 집합으로 만들고 출발
			
			//간선을 하나씩 시도하면서 트리를 만들어간다.
			long cnt = 0, result = 0;
			
			for (Edge edge  : edgeList) {
				if (union(edge.start, edge.end)) {
					//합치기 성공, 값 누적, 신장트리 완성하면 멈추기
					result += edge.weight;
					if (++cnt == V-1) break;
				}
			}
			
			System.out.println(result);
			
		}
		
		
	}

}
