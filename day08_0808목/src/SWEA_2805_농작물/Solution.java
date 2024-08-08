package SWEA_2805_농작물;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 수 입력받기
		int t = sc.nextInt();
		
		//테스트 케이스만큼 반복
		for (int round=1; round<=t; round++) {
			//출력할 합산의 값을 위한 변수
			int sum =0;
			//각 라운드마다 map의 사이즈를 받기 위한 변수
			int n = sc.nextInt();
			//이후에 들어올 값이 띄어쓰기 없이 들어오기 때문에
			//한 줄씩 받아오기 위해 비워주기.
			sc.nextLine();
			//사이즈에 맞는 map생성
			int[][]map = new int[n][n];
			//각 위치가 방문됐는지 체크를 위한 boolean 2차배열
			boolean[][]checked = new boolean[n][n];
			//map 채우기
			for (int i=0; i<n; i++) {
				String line = sc.nextLine();
				for (int j=0; j<n; j++) {
					map[i][j]=line.charAt(j) - '0';
				}
			}
			
			// 절반 윗부분을 채우기 위한 메서드.
			//한 줄씩 해당 줄의 행의 idx 값만큼 중간을 기준으로 좌 우로 더해주기
			//단, 방문을 안한 경우에만 더해주고, 방문 시 방문 표시!
			for (int i=0; i<n/2; i++) {
				for (int j=0; j<=i; j++) {
					if (!checked[i][n/2-j]) {
						sum+=map[i][n/2-j];
						checked[i][n/2-j]=true;
					}
					
					if (!checked[i][n/2+j]) {
						sum+=map[i][n/2+j];
						checked[i][n/2+j]=true;
					}
					
				}
			}
			
			//절반 아랫부분을 채우기 위한 메서드
			//한 줄씩 해당 줄의 행의 n-1-idx값만큼 중간을 기준으로 좌 우로 더해주기
			//단, 방문을 안한 경우에만 더해주고, 방문 시 방문 표시!
			for (int i=n-1; i>n/2; i--) {
				for (int j=0; j<=n-1-i; j++) {
					if (!checked[i][n/2-j]) {
						sum+=map[i][n/2-j];
						checked[i][n/2-j]=true;			
					}
					
					if (!checked[i][n/2+j]) {
						sum+=map[i][n/2+j];
						checked[i][n/2+j]=true;
					}
				
				}
			}
			
			//가운데 행의 열 모두 더해주기
			for (int i=0; i<n; i++) {
				if (!checked[n/2][i]) {
				sum+=map[n/2][i];
				checked[n/2][i]=true;
				}
			}
			System.out.println("#"+round+" "+sum);
			
		}
	}
	
	

}