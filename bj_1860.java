package day_0817;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_1860 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		
		File file = new File("input.txt");
		Scanner sc = new Scanner (file);
		
		int N = sc.nextInt();
		
		for (int t = 1; t <= N; t++) {
			
			int customerNum = sc.nextInt();
			int time = sc.nextInt();
			int cnt = sc.nextInt();
			
			
			int[] customers = new int[customerNum];
			
			for (int i =0 ; i<customerNum; i++) {
				customers[i] = sc.nextInt();
			}
			
			Arrays.sort(customers);
			
			boolean flag = true;
			int sale = 0;
			
			for (int i = 0; i < customers.length; i++) {
				int temp = customers[i] / time * cnt - sale;
				
				if(temp < 1) {
					flag = false;
					break;
				}
				sale++; 
			}
			
			System.out.println("#"+t+" "+(flag?"Possible" : "Impossible"));
		}
	}

}
