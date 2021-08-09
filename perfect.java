package day_0809;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class  perfect{

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		
		for(int t = 1; t<=testCase; t++) {
			int num = sc.nextInt();
			int size = num/2;
			
			if (num%2 != 0) {
				size = num/2+1;
			}
			
			String[] arr1 = new String[size];
			String[] arr2 = new String[num/2];
			
			for (int i = 0; i < size; i++) {
				arr1[i] = sc.next();
			}
			
			for (int i = 0; i < num/2; i++) {
				arr2[i] = sc.next();
			}
			

			System.out.print("#"+t+" ");
			for(int i = 0; i < size; i++) {
				
					System.out.print(arr1[i]+" ");
					if (arr2[i] != null) {
					System.out.print(arr2[i]+" ");
					}
				
			}
			
			
			
			System.out.println();
			
		}
	}

}
