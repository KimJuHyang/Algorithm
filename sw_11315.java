package day_0827;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sw_11315 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			int N = sc.nextInt();
			char[][] arr = new char[N][N];
			
			for (int i = 0; i<N; i++) {
				String s = sc.next();
				for (int j =0; j<N; j++) {
					arr[i][j] = s.charAt(j);
					//System.out.print(arr[i][j]);
				}
				//System.out.println();
			}
			
			int[] dx = {0,0,-1,1,1,-1,-1,1};
			int[] dy = {1,-1,0,0,1,-1,1,-1};
			boolean flag = false;
			
			outer: for (int i =0; i<N; i++) {
				for (int j=0; j<N; j++) {
					
					if (arr[i][j] == 'o') {
						
						for (int a =0; a<dx.length; a++) {
							int cnt = 0;
							
							for (int k=1; k<5; k++) {
								int moveX = i+dx[a]*k;
								int moveY = j+dy[a]*k;
								
								
								if (moveX >= 0 && moveX <N && moveY >= 0 && moveY < N && arr[moveX][moveY] == 'o' ) { 
									cnt++;
								} 
							}
							
							
							if (cnt == 4) {
								flag = true;
								break outer;
							}
						}
					
						
					}
				}
			}
			
			
			if(flag) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
						
		}
	}

}
