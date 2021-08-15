package day_0813;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class card2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File ("input.txt");
		Scanner sc = new Scanner(file);
		
		int N = sc.nextInt();
		Deque<Integer> q = new ArrayDeque<>();
		
		for (int i = N; i >= 1; i--) {
			q.push(i);
		}
		
		while (q.size() != 1) {
			q.remove();
			q.addLast(q.removeFirst());
		}
		
		System.out.println(q.peek());
	}

}
