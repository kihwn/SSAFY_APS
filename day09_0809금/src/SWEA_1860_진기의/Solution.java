package SWEA_1860_진기의;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int sum;
	static int m;
	static int k;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			//자격을 얻은 사람 수
			int n = sc.nextInt(); 
			//m초에 k개의 붕어빵 제조.
			m = sc.nextInt();
			k = sc.nextInt();
			//도착 시간 입력받을 배열 
			int[]arrives = new int[n];
			for (int i=0; i<n; i++) {
				arrives[i]=sc.nextInt();
			}
			// 도착 빠른 순으로 정렬 
			Arrays.sort(arrives);
			
			//붕어빵 개수 업데이트하여 담아줄 변수 
			sum =0;
		
			boolean isPossible = true;
			
			//도착 시간들만큼 돌면서 그 사이에 만들어진 붕어빵 개수를 업데이트 해주고,
			// 그 다음에 업데이트 된 붕어빵 개수 기준으로
			// 붕어빵이 존재하면 붕어빵 개수 하나 줄여주고,
			// 붕어빵 존재 안하면 대기가 발생하므로 isPossible 체크 후, 반복문 탈출 
			for (int i=0; i<n; i++) {
				int pre = arrives[i];
				if (i==0) {
					updateSum(0,pre);
				}
				else {
					int before = arrives[i-1];
					updateSum(before,pre);
				}
				
				if (sum>0) {
					sum--;
				}
				else {
					isPossible = false;
					break;
				}
			}
			
			if (isPossible) {
				System.out.println("#"+round+" Possible");
			}
			else {
				System.out.println("#"+round+" Impossible");
			}
		}
	}
	
	// 바로 이전 사람이 도착한 시간 다음부터 현재 바라보고 있는 도착 시간 사이에
	// 구워진 붕어빵 업데이트 
	public static void updateSum(int before, int pre) {
		for (int i=before+1; i<=pre; i++) {
			if (i%m==0 && i!=0) {
				sum+=k;
			}
		}
	}
}