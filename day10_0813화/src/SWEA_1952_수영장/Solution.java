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
			
			//1월~12월까지 수영할 날짜 입력받기
			for (int i=1; i<=12; i++) {
				months[i]=sc.nextInt();
			}
			
			int[]dp = new int[13];
			dp[0]=0;
			
			//1월부터 12월까지 (이전 달까지의 비용 + 한 달 금액 더하기) vs 
			//(이전 달까지 비용+하루권으로 이번달 계산하기) vs 
			//(3달 전 비용 + 3달치 비용) 중 가장 작은 값으로 매달 업데이트
			for (int i=1; i<=12; i++) {
				dp[i]=Math.min(dp[i-1]+month, dp[i-1]+(months[i]*day));
				
				if (i>=3) {
					dp[i]=Math.min(dp[i], dp[i-3]+threemonths);
				}
			}
			
			//마지막으로 1년 권과, 앞에서 계산한 최솟값 중 더 작은 값으로 업데이트 
			int result = Math.min(year, dp[12]);
			
			System.out.println("#"+round+" "+result);
		}
		
	}
	

}