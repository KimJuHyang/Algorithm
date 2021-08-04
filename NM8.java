package day_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM8 {
	static int[] input; 
	static int[] sel;
	
 public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String s = br.readLine();
	StringTokenizer st = new StringTokenizer(s);
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
		
		input = new int[N] ;
		sel = new int[M];
		
		String nums = br.readLine();
		StringTokenizer nst = new StringTokenizer(nums);
		
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(nst.nextToken());
		}
		
		//오름차순으로 나와야하니까 정렬
		Arrays.sort(input);
		result(0,0);
	
 }
 public static void result(int idx, int k) {
	 	
	 
		 if (idx == sel.length) {
			
			System.out.println(Arrays.toString(sel));

			return;
		}
		
		 	//같은수를 여러번 골라도 되니까 check배열사용할 필요없음 
		 	//1,7 & 7,1	이 출력가능한 순열이므로, 시작 인덱스를 0으로 출력
		 	// 비내림차순이여야 하므로 직전의 k값보다 같거나 커야하는 조건문 추가
		 
			for (int i =0; i <input.length; i++) {
				if (k <= input[i]) {
					sel[idx] = input[i];
					result(idx+1, i+1); 
				}
			}
			
	}
	 
	 
 }
 

