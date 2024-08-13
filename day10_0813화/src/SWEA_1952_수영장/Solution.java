package SWEA_1952_수영장;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			int day = sc.nextInt();
			int month = sc.nextInt();
			int threemonths = sc.nextInt();
			int year = sc.nextInt();
			
			int[]months = new int[13];
			months[0]=0;
			for (int i=1; i<=12; i++) {
				months[i]=sc.nextInt();
			}
			
			int[]dp = new int[13];
			dp[0]=0;
			
			for (int i=1; i<=12; i++) {
				dp[i]=Math.min(dp[i-1]+month, dp[i-1]+(months[i]*day));
				
				if (i>=3) {
					dp[i]=Math.min(dp[i], dp[i-3]+threemonths);
				}
			}
			
			int result = Math.min(year, dp[12]);
			
			System.out.println("#"+round+" "+result);
		}
		
	}
	

}