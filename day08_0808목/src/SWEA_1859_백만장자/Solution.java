package SWEA_1859_백만장자;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 입력받기
		int t = sc.nextInt(); 
		
		
		//테스트케이스만큼 반복
		for (int round=1; round<=t; round++) {
			//각 테스트케이스마다 들어올 숫자의 값(1,000,000이하의 자연수로 int형)
			int size = sc.nextInt(); 
			int[]nums = new int[size];
			//최대 매매가를 저장하기 위한 변수(1,000,000이하의 자연수로 int형)
			int max = 0;
			
			//이익의 총합을 저장하기 위한 변수(1,000,000 * 10,000 가 최대이기 때문에 int 범위 초과)
			long sum = 0;
			//들어오는 매일의 매매값 순서대로 저장.
			for (int i=0; i<size; i++) {
				int tmp = sc.nextInt();
				nums[i]=tmp;	
			}
			
			//뒤에서부터 최대 매매값 찾기. 현재 내 위치 기준으로 내 뒤에 나보다 더 큰 매매값이 있다면 해당 날에 판매하면 됨.
			//내 뒤부터 바라본 매매값보다 내 매매값이 더 크면 현재 매매값으로 max값 업데이트
			//내 뒤에 나보다 더 큰 매매값이 존재하면 해당 날에 팔면 되기 때문에 해당 값의 차이를 총합에 저장.
			for (int i=size-1; i>=0; i--) {
				if (max<nums[i]) {
					max = nums[i];
					}
				else {
					int minus = max - nums[i];
					sum+=minus;
				}
			}
			System.out.println("#"+round+" "+sum);
		
		}
	}
}