package day_0810;

import java.io.*;
import java.util.*;

public class bj_1158 {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int idx = K;
		
		String answer = "<";
		
		List<Integer> list = new LinkedList<Integer>();
		
		for (int i =1; i <= N; i++) {
			list.add(i);
		}
		
		while(!list.isEmpty()) {

			while (idx > list.size()) {
				idx = idx-list.size();
			}

			answer += list.get(idx-1)+", ";
			list.remove(idx-1);
			
			idx = idx+K-1;
			
		}
			
		answer = answer.substring(0, answer.length() - 2);
		answer += ">";
		System.out.println(answer);
		
	}

}
