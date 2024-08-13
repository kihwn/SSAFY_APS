package SWEA_1859_백만장자;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			int size = sc.nextInt();
			int[]nums = new int[size];
			int max = 0;
			//최종적으로 답이 될 변수. 
			long sum = 0;
			
			for (int i=0; i<size; i++) {
				int tmp = sc.nextInt();
				nums[i]=tmp;	
			}
			
			//뒤부터 바라보면서, 업데이트 된 최댓값보다 크면 max값 업데이트 
			//max값보다 작으면 max값과의 차이를 더해주기. 
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