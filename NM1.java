package day_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM1 {
	static int[] input; 
	static int[] sel;
	static boolean[] check;
	
 public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String s = br.readLine();
	StringTokenizer st = new StringTokenizer(s);
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
		
		input = new int[N] ;
		sel = new int[M];
		check = new boolean[input.length];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = i+1;
		}
		
		result(0);
	
 }
 public static void result(int idx) {
	 
	 if (idx == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		
	 	//같은수를 여러번 고르면 안되므로 check배열사용
		//1,7 & 7,1	이 출력가능한 순열이므로 i는 0부터 시작

		for (int i =0; i <input.length; i++) {
			if(check[i]) continue; 
		
			sel[idx] = input[i];
			check[i] = true;

			result(idx+1); 
			
			check[i] = false;
			
		}
	 
	 
 }
 
}
