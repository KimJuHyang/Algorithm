package day_1007;
import java.util.*;
import java.io.*;
import java.net.Socket;
public class pro_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "[[100,90,98,88,65],[50,45,99,85,77],[47,88,95,80,67],[61,57,100,80,65],[24,90,94,75,65]]";
		//System.out.println(input.replace('[', '{').replace(']', '}'));
		
		int[][] arr = {{100,90,98,88,65},{50,45,99,85,77},{47,88,95,80,67},{61,57,100,80,65},{24,90,94,75,65}};
		System.out.println(solution(arr));
	}

	 public static String solution(int[][] scores) {
	        String answer = "";
	        int n = scores[0].length;
	        float[] grade = new float[n];
	        
	        int[][] myScore = new int[n][n];
	        
	        for (int i=0; i <n ; i++ ) {
	        	for (int j = 0; j <n; j++) {
	        		myScore[i][j]=scores[j][i];
	        		//System.out.print(myScore[i][j]);
	        	}
	        	//System.out.println();
	        }
	        
	        for (int i=0; i < n; i++) {
	        	int[] temp = new int[n];
	        	int min = 101;
	        	int max = -1;
	        	int min_cnt = 0;
	        	int max_cnt = 0;
	        	
	        	for (int j=0; j <n; j++) {
	        		
	        		temp[j] = myScore[i][j];
	        		
	        		 if (myScore[i][j] == min) {
	        			 min_cnt++;
	        		 }
	        		 
	        		 if (myScore[i][j] == max) {
	        			 max_cnt++;
	        		 }
	        		 	min = Math.min(min, myScore[i][j]);
	        		 	max = Math.max(max, myScore[i][j]);
	        	}
	        	
	        	if ((min == myScore[i][i] && min_cnt == 0) || (max == myScore[i][i] && max_cnt == 0)) {
	        		temp[i] = 0;
	        	}
	        	
	        	//System.out.println(Arrays.toString(temp));
	        	int sum =0;
	        	int tempNum = 0;
	        	for (int k =0; k <n; k++) {
	        		if (temp[k] != 0) {
	        			tempNum++;
	        		}
	        		sum += temp[k];
	        	}
	        	
	        	grade[i] = (float)sum/tempNum;
	        }
	        
	       
	        for (int i=0; i <n; i++) {
	        	if (grade[i] >= 90) {
	        		answer+="A";
	        	} else if (grade[i] >= 80) {
	        		answer+="B";
	        	} else if (grade[i] >= 70) {
	        		answer+="C";
	        	} else if (grade[i] >= 50) {
	        		answer+="D";
	        	} else {
	        		answer+="F";
	        	}
	        }
	        
	        return answer;
	    }
	
}
