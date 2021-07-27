package day_0727;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class youngSik {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/day_0727/input.txt");
		//2. 영식이와 친구들
		Scanner sc = new Scanner(file);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		
		int cnt = -1;
		int i = 1;
		int[] arr = new int [N+1];
		
		while(true) {
		
			if (arr[i] == M) break;
			
			if(i+L > N) {
				i = (i+L)-N;
				arr[i]++;
				cnt++;
			} else {
				i = i+L;
				arr[i]++;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
