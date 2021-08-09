package day_0809;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class password {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
	
		
		for(int t = 1; t<=10; t++) {

			List<String> s = new ArrayList<>();
			int num = sc.nextInt();
			
			for(int i = 0; i < num; i++) {
				s.add(sc.next());
				
			}
			
			int txt = sc.nextInt();
			
			for (int i = 0; i < txt; i++) {
				String temp = sc.next();
				int idx = sc.nextInt();
				int size = sc.nextInt();
				
				for (int j = 0; j < size; j++ ) {
					s.add(idx,sc.next());
					idx++;
				}
			}
			
			System.out.println("#"+t+" ");
			
			for (int i =0; i< 10; i++) {
				System.out.print(s.get(i)+" ");
			}
			
		}
	}

}
