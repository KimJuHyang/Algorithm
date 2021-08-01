package day_0729;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ATM {

	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("/Users/juhyang/SSAFY/algorithm/SW_EXPERT/src/input.txt");
		//2. ATM
		Scanner sc = new Scanner(file);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum =0;
		for (int i = 0; i <N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i< arr.length; i++) {
			sum += arr[i];
			for (int j = 0; j < i; j++) {
				sum += arr[j];
			}
		}
		
		System.out.println(sum);
	}
	
}
