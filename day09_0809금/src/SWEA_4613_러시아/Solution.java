package SWEA_4613_러시아;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		for (int round=1; round<=testCase; round++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			char[][]flags = new char[n][m];
			
			//입력값으로 배열 채우기 
			for(int i=0; i<n; i++) {
				String tmp = sc.next();
				for (int j=0; j<m; j++) {
					flags[i][j] = tmp.charAt(j);
				}	
			}
			
			//각 횟수마다 최솟값을 비교하여 최종적으로 출력할 값.
			//일단 최댓값으로 설정.
			int minResult = n*m;
			
			//cnt : 각 반복문마다의 바꾼 값.
			//i : 흰색 칠할 범위
			//j : 파란색 칠할 범위 
			for (int i=0; i<n-2; i++) {
				for (int j=i+1; j<n-1; j++) {
					int cnt =0;
					
					// 흰색 칠할 행 범위는 i까지. 
					for (int z=0; z<=i; z++) {
						for (int p=0; p<m; p++) {
							if (flags[z][p]!='W') {
								cnt++;
							}
						}
					}
					
					// 파란색 칠할 행 범위는 흰색 이후부터 j까지.
					for (int z=i+1; z<=j; z++) {
						for (int p=0; p<m; p++) {
							if (flags[z][p]!='B') {
								cnt++;
							}
						}
					}
					
					// 빨간색 칠할 행 범위는 파란색 이후부터 n-1인덱스까지. 
					for (int z=j+1; z<n; z++) {
						for (int p=0; p<m; p++) {
							if (flags[z][p]!='R') {
								cnt++;
							}
						}
					}
					
					//매번 최솟값 비교하여 minResult에 업데이트 
					minResult = Math.min(cnt, minResult);					
					
				}
			}
			
			System.out.println("#"+round+" "+minResult);
			
			
		}
	}
}