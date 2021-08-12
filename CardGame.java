package day_0812;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CardGame {
	static int[] A;
	static int[] B;
	static boolean[] check;
	static int win;
	static int lose;
	static int cnt;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		File file = new File ("input.txt");
		Scanner sc = new Scanner(file);
		
		int tc = sc.nextInt();
		
		for (int t =1; t<= tc; t++) {
			
			A = new int[9];
			B = new int[9];
			check = new boolean[9];
			
			win = 0;
			lose = 0;
			cnt = 0;
			for (int i =0; i <9; i++) {
				A[i] = sc.nextInt();
			}
			
			
			int tt = 0;
			loop: for (int j=1; j<=18; j++) {
				//인영이가 낼 수 있는 숫자들을 B에 넣기
				for (int k : A) {
					if (k == j) {
						continue loop;
					}
				}
				B[tt] = j;
				tt++;
			}
			
		 
		
			// 순서가 중요하니까 순열..
			
			res(new int[9],0);
			System.out.println("#"+t+" "+win+ " "+lose);
		}
	}

	private static void res(int[] sel, int k) {
		// TODO Auto-generated method stub
		if (k == 9) {
			//승패확인.
			int Asum =0, Bsum =0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] > sel[i]) Asum += A[i]+sel[i];
				else Bsum += A[i]+sel[i];
			}
			
			if (Asum > Bsum) win++;
			else lose++;
			
			return;
		}
		
		for (int i = 0; i < B.length; i++) {
			if (check[i] == true) continue;
			
			check[i] = true;
			sel[k] = B[i];
			res(sel,k+1);
			check[i] = false;
		}
	}

}
