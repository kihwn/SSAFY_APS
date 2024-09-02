package SWEA_1952_수영장;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
        //테스트 케이스만큼 반복
		for (int round=1; round<=t; round++) {
            //각 기간에 해당하는 이용권 요금 입력 받기
			int day = sc.nextInt();
			int month = sc.nextInt();
			int threemonths = sc.nextInt();
			int year = sc.nextInt();
			
            //12달의 이용 계획표 (12까지 받기 위해 사이즈를 13으로 결정)
			int[]months = new int[13];
            //1~12월까지 입력 받기
			for (int i=1; i<=12; i++) {
				months[i]=sc.nextInt();
			}
			
            //앞 달부터 해당 idx의 달까지 합산된 최소 요금을 찾기 위한 배열
            //마찬가지로 1~12월까지 담기 위해 사이즈를 13으로 설정
			int[]dp = new int[13];
			dp[0]=0;
			
            //1월~12월까지 바라보기
			for (int i=1; i<=12; i++) {
                //바라보고 있는 idx에 해당하는 달의 누적합의 최솟값을 찾기 위한 과정
                //1.  해당 달의 직전 달 요금에서 한달 요금을 더한 값과,
                //      해당 달의 직적 달 요금에서 하루 요금 * 해당 달의 이용 예정 날짜 를 더한 값 중 최솟값으로 업데이트.
				dp[i]=Math.min(dp[i-1]+month, dp[i-1]+(months[i]*day));
				
                //2. 앞에서 업데이트한 최솟값과 만일 달이 3월 이상일 경우
                //해당 달의 세달 전 요금으로부터 3달 요금을 더한 값 중 더 작은 값으로 업데이트
                //예를 들어 지금 바라보고 있는 달이 3월일 경우 dp[0]+세달치 요금이 됨.
                //즉, 1~3월은 세달치 요금 한 번을 내서 해결한 것.
				if (i>=3) {
					dp[i]=Math.min(dp[i], dp[i-3]+threemonths);
				}
			}
			
            //최종적으로 앞에서 비교한 12월까지의 최소 누적 합산 값과 1년 요금을 비교하여 더 작은 값으로 결정
			int result = Math.min(year, dp[12]);
			
			System.out.println("#"+round+" "+result);
		}
		
	}
	

}