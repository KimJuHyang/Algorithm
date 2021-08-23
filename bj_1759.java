package day_0823;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class bj_1759 {
	static int L,C;
	static String[] arr;
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		
		//중복 없는 순열
		L = sc.nextInt();
		C = sc.nextInt();
		arr = new String[C];
		
		for (int i =0; i<C; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
		prem(0,new boolean[arr.length],new String[L],0);
	}

	private static void prem(int idx, boolean[] check, String[] numbers, int k) {
		// TODO Auto-generated method stub
		
		if (k == numbers.length) {
			
			//최소 한 개 이상의 모음(a, e, i, o, u)과 최소 두 개의 자음 
			// 즉 모음의 개수가 len-2를 넘으면 안된다는것 
			
			String[] alpha = {"a", "e", "i", "o", "u"};
			
			boolean flag = false;
			
			int cnt = 0;
			for (int i = 0; i<numbers.length; i++) {
				for (int j = 0; j<alpha.length; j++) {
					if (alpha[j].equals(numbers[i])) ++cnt;
				}
			
			}
			
			if (cnt < numbers.length-1 && cnt > 0) {
				flag = true;
			}
			
			for (int i = 0; i<numbers.length-1; i++) {
				
				if (numbers[i].compareTo(numbers[i+1]) > 0) {
					flag = false;
				}
				
			}
			
			if (flag) {
				for (int i =0; i< numbers.length; i++) {
					System.out.print(numbers[i]);
				}
				System.out.println();
			}
			
			return;
		}
		
		for (int i = idx; i<arr.length; i++) {
			if (check[i]) continue;
			
			check[i] = true;
			numbers[k] = arr[i];
			prem(i+1,check, numbers, k+1);
			check[i] = false;
		}
		
	}

}
