package hw_20210805;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Buger_PowerSet {
	static int num;
	static int cal;
	static int maxTasty;
	static int[] tasty;
	static int[] cals;
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++ ) {
			
			num = sc.nextInt();
			cal = sc.nextInt();
			
			tasty = new int[num];
			cals = new int [num];
		
			maxTasty = 0;
			
			for (int i = 0; i < num; i++) {
				tasty[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			

			powerSet(0,new boolean[num]);
			
			System.out.println("#"+t+" "+maxTasty);
		}
	}

	private static void powerSet(int idx, boolean[] sel) {
		// TODO Auto-generated method stub
		
		if (idx == num) {
			
			int sumCal = 0;
			int sumTasty = 0;
			
			//계산
			for (int i =0; i < num; i++) {
				if (sel[i]) {

					sumCal += cals[i];
					sumTasty += tasty[i];
				}
			}
			
			//칼로리가 cal을 넘지 않고, 선호도가 가장 높으면
			if (sumCal <= cal && sumTasty > maxTasty ) {
				maxTasty = sumTasty;
			}
			
			return;
		}
		
		sel[idx] = true;
		powerSet(idx+1, sel);
		sel[idx] = false;
		powerSet(idx+1, sel);
	}
}
