package hw_20210809;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class SpotMart {

	static int total;
	static int max;
	static int[] sel;
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		
		for (int t =1; t <= testCase; t++) {
			
			int num = sc.nextInt();
			total = sc.nextInt();
			max = -1;
			
			sel = new int[2];
			arr = new int[num];
			
			for (int i =0; i< num; i++) {
				arr[i] = sc.nextInt();
			}
			
			result(0,0);
			
			System.out.println("#"+t+" "+max);
		}
		

	}
	private static void result(int idx, int k) {
		// TODO Auto-generated method stub
	
		
	
		
		if (k == 2) {
			System.out.println(Arrays.toString(sel));
			//합 계산
			int sum = 0;
			for (int i : sel) {
				sum += i;
			}
			
			if (sum > total) return;
			if (max < sum) max = sum;
			
			return;
		}
	
		
			for (int i = idx; i < arr.length; i++) {
				sel[k] = arr[i];
				result(i+1, k+1);
			}
            
		
	}

}
