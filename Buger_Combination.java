package hw_20210805;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Buger_Combination {
	static int num;
	static int cal;
	static int maxTasty;
	static int[] tasty;
	static int[] cals;
	static boolean[] check;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++ ) {
			
			num = sc.nextInt();
			cal = sc.nextInt();
			
			tasty = new int[num];
			cals = new int [num];
			check = new boolean[num];
		
			maxTasty = 0;
			
			for (int i = 0; i < num; i++) {
				tasty[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			
			for (int i = 1; i <= num; i++) {
				Combination(0,new int[i],new int[i],0);
			}
			
			System.out.println("#"+t+" "+maxTasty);
		}
	}

	private static void Combination(int idx, int[] selT, int[] selC, int k) {
		// TODO Auto-generated method stub
		
		if (idx == selT.length) {
			
			int sumCal = 0;
			int sumTasty = 0;
			
			// 계산
			for (int i =0; i < selT.length; i++) {
				sumCal += selC[i];
				sumTasty += selT[i];
				
			}
			
			//칼로리가 cal을 넘지 않고, 선호도가 가장 높으면
			if (sumCal <= cal && sumTasty > maxTasty ) {
				maxTasty = sumTasty;
			}
			
			return;
		}
		
				for (int i = k; i < num; i++) {
					if (check[i] == false) {
						check[i] = true;
						selT[idx] = tasty[i];
						selC[idx] = cals[i];
						Combination(idx+1,selT, selC, i+1);
						check[i] = false;
					}
				}
				
	}
}
