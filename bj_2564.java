package day_0813;

import java.io.*;
import java.util.*;

public class bj_2564 {
	static int res = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] shop = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			shop[i][0] = sc.nextInt();
			shop[i][1] = sc.nextInt();
		}
		
		int myX = sc.nextInt();
		int myY = sc.nextInt();
		
		for (int i =0; i <N; i++) {
			int shopX = shop[i][0];
			int shopY = shop[i][1];
			
			//만약 나랑 방향이 같다면, Y만 빼면 됨
			if (shopX == myX) res += Math.abs(myY-shopY);
			
			else {
				//북쪽
				if (shopX == 1) {
					if (myX == 2)
                        cross(x, myY, shopY, y, 1);
                    else if (myX == 3)
                        res += shopY + myY;
                    else if (myX == 4)
                        res += (x - shopY) + myY;
				} 
				//남쪽
				else if (shopX == 2) {
					if (myX == 1)
						cross(x, myY, shopY, y, 1);
                    else if (myX == 3)
                        res += (y - myY) + shopY;
                    else if (myX == 4)
                        res += (x - shopY) + (y - myY);
				}
				//서쪽
				else if (shopX == 3) {
					if (myX == 1)
                        res += (myY + shopY);
                    else if (myX == 2)
                        res += myY + (y - shopY);
                    else if (myX == 4)
                    	cross(x, myY, shopY, y, 2);
				}
				//동쪽
				else if (shopX == 4) {
					if (myX == 1)
                        res += shopY + (x - myY);
                    else if (myX == 2)
                        res += (y - shopY) + (x - myY);
                    else if (myX == 3)
                    	cross(x, myY, shopY, y, 2);
				}
			}
			
		}
		
		System.out.println(res);
		
	}

	//마주보는 경우 계산하기
	private static void cross(int x, int myY, int shopY, int y, int type) {
		// TODO Auto-generated method stub
		
		if (type == 1) {
			int left = myY + shopY + y;
			int right = (x - myY) + (x - shopY) + y;
			
			if (left > right) {
				res+= right;
			} else {
				res+= left;
			}	
		} else {
			
			int left = myY + shopY + x;
			int right = (y - myY) + (y - shopY) + x;
			
			if (left > right) {
				res+= right;
			} else {
				res+= left;
			}	
		}
		
	}
	
	

}
