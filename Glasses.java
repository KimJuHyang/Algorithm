package algo1;

import java.io.*;
import java.util.*;

public class Glasses {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

	
		File input = new File("/Users/juhyang/algo/SW_Expert_Academy/input.txt");
		
		Scanner sc = new Scanner(input);
		
		char[] noHole = {'C','E','F','G','H','I','J','K','L','M','N','S','T','U','V','W','X','Y','Z'};
		char[] hole = {'A','D','O','P','Q','R'};
		
		int testCase = sc.nextInt();
		
		for (int t = 1; t <= testCase; t++) {
			
			String a = sc.next();
			String b = sc.next();
			
			char[] aArr = new char[a.length()];
			char[] bArr = new char[b.length()];
			
			if (a.length() != b.length()) {
				System.out.println("#"+t+" "+"DIFF");
				continue;
			} 
			
			for(int i = 0; i < a.length(); i++) {
				aArr[i] = a.charAt(i);
				bArr[i] = b.charAt(i);
			}
		
			boolean flag;
			
			for (int i = 0; i < aArr.length; i++) {
				flag = false;
				for(int j = 0; j < noHole.length; j++) {
					if (aArr[i] == noHole[j]) {
						aArr[i] = '0';
						flag = true;
						break;
					} 
					if (aArr[i] == 'B') {
						aArr[i] = 'B';
						flag = true;
					}
	
				}
				if(!flag) aArr[i] = '1'; 
			}
			
			for (int i = 0; i < bArr.length; i++) {
				flag = false;
				for(int j = 0; j < noHole.length; j++) {
					if (noHole[j] == bArr[i]) {
						bArr[i] = '0';
						flag = true;
						break;
					}
					if (bArr[i] == 'B') {
						bArr[i] = 'B';
						flag = true;
					}
				}
				if(!flag) bArr[i] = '1';
			}
			
			flag = true;
			for (int i = 0; i < aArr.length; i++) {
				if (aArr[i] != bArr[i]) {
					flag=false; 
					break;
				}	
			}
			
			if (!flag) {
				System.out.println("#"+t+" "+"DIFF");
			} else {
				System.out.println("#"+t+" "+"SAME");
			}
			
		}
	}

}
