package day_0822;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

public class sw_1221 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int t=1; t <= N; t++) {
			sc.next();
			int n = sc.nextInt();
			String[] alphabet = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
			
			HashMap<String,Integer> gns = new HashMap<>();
			for (int i =0; i < 10; i++) {
				gns.put(alphabet[i], i);	
			}
			
			Number[] numbers = new Number[n];
			
			for (int i = 0; i<n; i++) {
				String tmp = sc.next();
				numbers[i] = new Number(tmp, gns.get(tmp));
			}
			
			Comparator<Number> com = new Comparator<Number>() {

				@Override
				public int compare(Number o1, Number o2) {
					// TODO Auto-generated method stub
					return o1.idx-o2.idx;
				}
			
			};
			
			Arrays.sort(numbers,com);
			
			System.out.println("#"+t);
			for (Number i : numbers) {
				System.out.print(i.s+ " ");
			}
		}
	}

}

class Number {
	String s;
	int idx;
	
	public Number(String s, int idx) {
		this.s = s;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Number [s=" + s + ", idx=" + idx + "]";
	}
	
}