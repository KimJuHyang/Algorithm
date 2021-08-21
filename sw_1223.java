package day_0820;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class sw_1223 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
	
		
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for (int t=1; t <= 10; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			
			String s = sc.next();
			
			//-5면 +, -6이면 *
			for (int i = 0; i < N; i++) {
				arr[i] = s.charAt(i)-'0';
			}

			arr[arr.length-1] = -1;
			
			int res = 0;
			Deque<Integer> number = new ArrayDeque<>();
			Deque<Integer> math = new ArrayDeque<>();
			
			for (int i = 0; i < N+1; i++) {
			
				if (arr[i] == -5 || arr[i] == -1) {
					
					if (!math.isEmpty()) {
						//곱셈이 있다는것
						int temp = 1;
						
						while (!number.isEmpty()) {
							temp *= number.pop();
						}
						
						res += temp;
						math.clear();
					} else {
						res += number.pop();
					}
					
				} else if (arr[i] == -6) {
					math.push(arr[i]);
				} else {
					number.push(arr[i]);
				}
			}
			
			System.out.println("#"+t+" "+res);
			
		}
		
		
	}

}
