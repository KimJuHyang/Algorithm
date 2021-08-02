package day_0729;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class blackJack {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/input.txt");
		
		//블랙잭
		Scanner sc = new Scanner(file);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int max = 0;
		
		int[] arr = new int[N+1];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for(int i =N; i > 0; --i) {
			int temp = M - arr[i];
			
			for(int j= i-1; j >0; --j) {
				if(temp >= arr[j] && arr[i]+arr[j] <= M) {
					
					int temp2 = temp-arr[j];
					
					for (int k = j-1; k>0; --k) {	
						if(temp2 >= arr[k] && max < arr[i]+arr[j]+arr[k] ) {
							max = arr[i]+arr[j]+arr[k];
						}
					}
				} 
			}
		}
		
		System.out.println(max);
		
	}
}
