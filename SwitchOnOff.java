package day_0802;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwitchOnOff {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int total = Integer.parseInt(br.readLine()); 
		int[] switches = new int[total];
        
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<total; i++)
			switches[i] = Integer.parseInt(st.nextToken());
		
		int cnt = Integer.parseInt(br.readLine()); 
        
        
		for(int i=0; i<cnt; i++) {
            
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int getNum = Integer.parseInt(st.nextToken());
			
			//남학생
			if(gender == 1) {
				for(int j=0; j<total; j++) 
					if((j+1) % getNum == 0)
						switches[j] = Math.abs(switches[j]-1);
			}
			//여학생
			else {
				
				switches[getNum - 1] = Math.abs(switches[getNum - 1]-1);
                
				for(int j=1; j<total/2; j++) {
					if(getNum-1+j >= total || getNum-1-j < 0)
						break;
                    
					if(switches[getNum-1-j] == switches[getNum-1+j]) {
						switches[getNum-1-j] = Math.abs(switches[getNum-1-j]-1);
						switches[getNum-1+j] = Math.abs(switches[getNum-1+j]-1);
					}
					else break; 
				}
			}
		}
		
		for(int i=0; i<total; i++) {
			System.out.print(switches[i] + " ");
			if((i+1) % 20 == 0)
				System.out.println();
		}
	}
}