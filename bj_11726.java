package day_1026;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class bj_11726 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 최대 n의 범위가 1000이므로 배열할당
		int[] arr = new int[1001];
		
		arr[1] = 1;
		arr[2] = 2;
		
		for (int i=3; i <= n; i++) {
			// 애초부터 배열에 값 넣을때 10007을 나눠주어야 자료형을 넘어가는걸 방지.
			// 마지막 프린트할때 나눠주면 에러납니다.
			arr[i] = (arr[i-1]+arr[i-2]) % 10007;
		}
		System.out.println(arr[n]);
	}

}
