package hw_20210811;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class arrayChange3 {
	 static int N;
	 static int M;
	 static int R;
	 static int[][] arr;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		 N = sc.nextInt();
		 M = sc.nextInt();
		 R = sc.nextInt();
		
		arr = new int[N][M];
		
		for (int i =0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				arr[i][j] = sc.nextInt();
				
			}
		}
		
		
		sc.nextLine();
		String[] V  = sc.nextLine().split(" ");
		
		
			for (int i = 0; i < V.length; i++) {
				int temp = Integer.parseInt(V[i]);
				
				switch(temp) {
				case 1:
					rowHighChange();
					break;
				case 2:
					leftRightChange();
					break;
				case 3:
					right90Change();
					break;
				case 4:
					left90Change();
					break;
				case 5:
					Change5();
					break;
				case 6:
					Change6();
					break;
				}
				
			}
		
		
		
		for(int i = 0; i < arr.length; i++) {
			for (int j =0; j < arr[0].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}


	private static void rowHighChange() {
		// TODO Auto-generated method stub

	
			for (int i =0; i < N/2; i++) {
				for (int j =0; j < M; j++ ) {
					int temp = arr[i][j];
					arr[i][j] = arr[N-1-i][j];
					arr[N-1-i][j] = temp;
					
				}
			}

	}
	
	private static void leftRightChange() {
		// TODO Auto-generated method stub
		
			
			for (int i =0; i < M/2; i++) {
				for (int j =0; j < N; j++ ) {
					int temp = arr[j][i];
					arr[j][i] = arr[j][M-1-i];
					arr[j][M-1-i] = temp;
				}
				
			}

	}
	
	private static void right90Change() {
		// TODO Auto-generated method stub
		
		int temp = N;
		N = M;
		M = temp;
		
		int[][] res = new int[N][M];

			
			int x =0;
			int y =0;
			
			for (int i =M-1; i >=0; i--) {
				y = 0;
				for (int j = 0; j < N; j++) {
					res[j][i] = arr[x][y];
					y++;
				}
				x++;
			}
		
		
		arr = res;
		
	}
	
	private static void left90Change() {
		// TODO Auto-generated method stub
		
		int temp = N;
		N = M;
		M = temp;

		int[][] res = new int[N][M];
			

				int x =0;
				int y =0;
				for (int i = N-1; i >=0; i--) {
					x = 0;
					for (int j = 0; j < M; j++) {
						res[i][j] = arr[x][y];
						x++;
					}
					y++;
				}

		arr = res;
		
	}


	private static void Change5() {
		
		
		int[][] res = new int[N][M];

			for (int i =0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if (i < N/2 && j < M/2) {
						//1
						res[i][j] = arr[i+N/2][j];
					} else if (i >= N/2 && j < M/2) {
						//4
						res[i][j] = arr[i][j+M/2];
					} else if (i < N/2 && j >= M/2) {
						//res[i][j] = 2;
						res[i][j] = arr[i][j-M/2];
					} else {
						//res[i][j] = 3;
						res[i][j] = arr[i-N/2][j];
					}
				}
			}

				
		arr = res;
	}
	
	private static void Change6() {
			// TODO Auto-generated method stub
		
		int[][] res = new int[N][M];
	
			for (int i =0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					
					if (i < N/2 && j < M/2) {
						//1
						res[i][j] = arr[i][j+M/2];
					} else if (i >= N/2 && j < M/2) {
						//4
						res[i][j] = arr[i-N/2][j];
					} else if (i < N/2 && j >= M/2) {
						//res[i][j] = 2;
						res[i][j] = arr[i+N/2][j];
					} else {
						//res[i][j] = 3;
						res[i][j] = arr[i][j-M/2];
					}
				}
			}

			
		arr = res;
	}
	

}
