package day_0808;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class rollCake_3985 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] cake = new int[L+1];
		int preMax = -1, afterMax = -1;
		int preMaxPerson = 0, afterMaxPerson = 0;
		
		for (int n = 1; n<= N; n++) {
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			if (Math.abs(x-y) > preMax) {
				preMax = Math.abs(x-y);
				preMaxPerson = n;
			}
			
			for (int i = x; i <= y; i++) {
				if (cake[i] != 0)  {
					continue;
				}
				cake[i] = n;
			}
			
		}
		
		
		//  인덱스에 맞게 카운트 배열에 넣은뒤, 그것의 최대값을 세는 과정인데 이걸 줄이고 싶어요 ㅠㅠ
		// 포문을 2개나 돌렸는데.. 뭔가 포문 하나로 최대값 + 인덱스 얻을 수 있는 방법 있을까여?!
		
		int[] cnt = new int[N+1];
		for (int i = 0; i < cake.length; i++) {
			if (cake[i] != 0) {
				cnt[cake[i]]++;
			}
		}
		
		
		for(int i = 0; i< cnt.length; i++) {
			if (cnt[i] > afterMax) {
				afterMax = cnt[i];
				afterMaxPerson = i;
			}
		}
		
		System.out.println(preMaxPerson);
		System.out.println(afterMaxPerson);
		
		
	}

}
