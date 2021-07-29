//농작물 수확
package algo1;
import java.io.*;
import java.util.*;

public class farm {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/algo/SW_Expert_Academy/input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		for(int t = 1; t <=testCase; t++) {
			
			int N = sc.nextInt();
			int[][] Board =  new int [N][N];
			int sum = 0;
		
			for (int i = 0; i < N; i++) {
					String temp = sc.next();
					for (int j =0; j<N; j++) {
						Board[i][j] = (int)temp.charAt(j)-48;
					}
			}
			
			for (int i=0; i <= N/2; i++) {
				sum+= Board[i][N/2];
				for(int j = 1; j<= i; j++) {
					sum+= Board[i][(N/2)+j];
					sum+= Board[i][(N/2)-j];					
				}
			}
			
			for(int i = N-1; i > N/2; i--) {
				sum+= Board[i][N/2];
				for(int j = 1; j < N-i; j++) {
					sum+= Board[i][(N/2)+j];
					sum+= Board[i][(N/2)-j];
				}
			}

			System.out.println("#"+t+" "+sum);
			
		}
	}
}
