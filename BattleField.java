package day_0804;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BattleField {
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File ("BattleField_input.txt");
		Scanner sc = new Scanner(file);
		
		int testCase = sc.nextInt();
		
		

		for(int t = 1; t <= testCase; t++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			
			char[][] map = new char [H+1][W+1];

			for (int h = 0; h < H; h++) {
				String temp = sc.next();
				for(int w = 0; w < W; w++) {
					map[h][w] = temp.charAt(w);
				}
			}
			
			int num = sc.nextInt();
			String[] userString = new String[num];
			userString = sc.next().split("");
			
			//이동 좌표
			int x = 0;
			int y = 0;
			
			//시작점 찾기
			for (int h =0; h<H; h++) {
				for (int w=0; w <W; w++) {
					if (map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
						x = h;
						y = w;
					}
				}
			}
			
			for (String c : userString) {
				
				switch(c) {
			     
				case "U":
					
					map[x][y] ='^';
					if (x-1 >= 0 && map[x-1][y] == '.') {
						map[x][y]='.';
						map[x-1][y] = '^';
						x = x-1;
						
					}
					
					break;
				
				case "D":
					map[x][y] ='v';
					if (x+1 < H && map[x+1][y] == '.') {
						map[x][y] = '.';
						map[x+1][y] = 'v';
						x = x+1;
					
					}
					break;
					
				case "L":
					map[x][y] ='<';
					if (y-1 >= 0 && map[x][y-1] == '.') {
						map[x][y] = '.';
						map[x][y-1] = '<';
						y = y-1;
					
					}
					
					break;
					
				case "R":
					map[x][y] ='>';
					if (y+1 < W && map[x][y+1] == '.') {
						map[x][y] = '.';
						map[x][y+1] = '>';
						y = y+1;
					
					}
					break;
					
				case "S":
					//전차의 방향
					switch(map[x][y]) {
					
						case '^':
							for (int i=x; i >=0 ; --i) {
								if (map[i][y] == '*') {
									map[i][y] = '.';
									break;
								} else if (map[i][y] == '#') {
									break;
								}
							}
							break;
						case 'v':
							
							
							for (int i=x; i < H ; i++) {
								
								if (map[i][y] == '*') {
									map[i][y] = '.';
									break;
								} else if (map[i][y] == '#') {
									break;
								}
							}
													
							break;
													
						case '<':
							for (int i=y; i >= 0 ; i--) {
								if (map[x][i] == '*') {
									map[x][i] = '.';
									break;
								} else if (map[x][i] == '#') {
									break;
								}
							}
							break;
							
						case '>':
							for (int i=y; i < W ; i++) {
								if (map[x][i] == '*') {
									map[x][i] = '.';
									break;
								} else if (map[x][i] == '#') {
									break;
								}
							}
							break;
					
					
							
					}
					
					
					break;
				}
				
			}
			
			System.out.print("#"+t+" ");
			for(int i = 0; i <H; i++) {
				for (int j =0; j <W; j++) {
					System.out.print(map[i][j]);
				}
				
				System.out.println();
			} 
			
			
		}
	}
}
