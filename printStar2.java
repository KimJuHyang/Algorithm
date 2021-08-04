package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class printStar2 {

	public static void main(String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int n = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(st.nextToken());	
		
		if (n > 100 || m < 1 || m > 4 || n%2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}
		
		if (m == 1) {
			
			for (int i = 0; i < n; i++) {
				if (i <= n/2) {
					for (int j = 0; j <= i; j++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > n/2) {
					for (int k = n-i; k > 0; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}	
		} else if (m == 2) {
			
			for (int i = 0; i < n; i++) {
				if (i <= n/2) {
					for (int j = n/2-i; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = 0; k <= i; k++) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > n/2) {
					for (int j = 0; j < i-n/2; j++) {
						System.out.printf(" ");
					}
					for (int k = n-i; k > 0; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			
		} else  if (m == 3) {
			
			for (int i = 0; i < n; i++) {
				if (i <= n/2) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = n; k > 2*i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}
				if (i > n/2) {
					for (int j = n-i-1; j > 0; j--) {
						System.out.printf(" ");
					}
					for (int k = n-1; k < 2*i+1; k++) {
						System.out.printf("*");
					}
					System.out.println();
				}
			}
			
		} else {
			
			for (int i = 0; i < n; i++) {
				if (i <= n/2) {
					for (int j = 1; j <= i; j++) {
						System.out.printf(" ");
					}
					for (int k = n/2+1; k > i; k--) {
						System.out.printf("*");
					}
					System.out.println();
				}

				if (i > n/2) {
					for (int j = 1; j <= n/2; j++) {
						System.out.printf(" ");
					}
					for (int k = n/2-1; k < i; k++) {
						System.out.printf("*");
					}
					System.out.println();

				}
				
			}
			
			
		}
	}
}
