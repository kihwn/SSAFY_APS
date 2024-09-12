package SWEA_1970_쉬운거스름돈;

import java.util.Scanner;

//1. 그리디 풀이 (금액 단위가 이전 단위의 배수들이기 때문에 그리디 가능)
public class Solution {
	//금액 단위.
	static int[] money = new int[]{50000,10000,5000,1000,500,100,50,10};
	static int size = money.length;
	//각 화폐 단위가 몇 번 쓰였는지 체크를 위한 배열
	static int[] cnt;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			//계산할 가격
			int n = sc.nextInt(); 
			cnt = new int[size];
			//화폐 단위는 큰 값부터 작은 값 순서로 저장되어 있음. 만일 정리되어 있지 않으면 정렬 후 마지막 인덱스부터 0까지 돌기.
			for (int i=0; i<size; i++) {
				//업데이트 된 n이 현재 보고 있는 화폐 단위보다 크면 빼주기.
				while(n>=money[i]) {
					n-=money[i];
					cnt[i]++;
				}
			}
			System.out.println("#"+round);
			for (int i=0; i<size; i++) {
				System.out.print(cnt[i]+" ");
			}
			System.out.println();
		}
	}

}