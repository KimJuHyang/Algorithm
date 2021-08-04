package day_0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class printStar1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
         
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
         
        if (n > 100 || m < 1 || m > 3) {
            System.out.println("INPUT ERROR!");
            return;
        }
         
        if (m == 1) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j<i; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else if (m == 2) {
            for (int i = n; i >= 0; i--) {
                for (int j = i; j>0; j--) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else { 
                 
            for (int i = 1; i <= n; i++) {
                 
                for (int j = n; j>i; j--) {
                    System.out.print(" ");
                }
                 
                for (int j=0; j <i+(i-1); j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } 
    }
}