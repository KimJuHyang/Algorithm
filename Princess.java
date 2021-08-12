package hw_20210812;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Princess {
	static int[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File ("input.txt");
		Scanner sc = new Scanner(file);
		
		arr = new int [9];
		
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		
		res(0, new int[7],0, 0);
	}
	private static void res(int idx, int[] sel, int k, int sum) {
		// TODO Auto-generated method stub
		if (k == 7) {
			if (sum == 100) {
				for (int i : sel) {
					System.out.println(i);
				}
				System.out.println();
			}
				
			return;
		}
		
		for (int i = idx; i < 9; i++) {
			sel[k] = arr[i];
			res(i+1, sel, k+1 , sum+arr[i]);
		}
	}

}
