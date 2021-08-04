package day_0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NM2 {
	static int[] input; 
	static int[] sel;
	//static boolean[] check;
	
 public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String s = br.readLine();
	StringTokenizer st = new StringTokenizer(s);
	
	int N = Integer.parseInt(st.nextToken());
	int M = Integer.parseInt(st.nextToken());
		
		input = new int[N] ;
		sel = new int[M];
		//check = new boolean[input.length];
		
		for (int i = 0; i < input.length; i++) {
			input[i] = i+1;
		}
		
		result(0,0);
	
 }
 public static void result(int idx, int k) {
	 
	 
	 if (idx == sel.length) {
			
			System.out.println(Arrays.toString(sel));

			return;
		}
	 
	 		
	 		//1,7 & 7,1	이 출력되면 안되는 조합이므로, 시작 인덱스를 ++하며 출력
		 	for (int i = k; i <input.length; i++) {
	
				sel[idx] = input[i];
				result(idx+1, i+1); 
				
				
			}
			
		}
	 
	 
 }
 

