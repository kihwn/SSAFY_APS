package SWEA_1860_진기의;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int sum;
	static int m;
	static int k;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 수 입력받음
		int t = sc.nextInt();
		//테스트케이스만큼 반복
		for (int round=1; round<=t; round++) {
			//자격을 얻은 사람 수
			int n = sc.nextInt(); 
			//m초에 k개의 붕어빵 제조.
			m = sc.nextInt();
			k = sc.nextInt();
			//n명의 사람들이 도착하는 시간을 담기 위한 배열
			int[]arrives = new int[n];
			//도착 시간 입력받기
			for (int i=0; i<n; i++) {
				arrives[i]=sc.nextInt();
			}
			//도착 시간 순으로 정렬
			Arrays.sort(arrives);

			//붕어빵의 수를 저장하기 위한 변수
			sum =0;
		
			//대기없는 붕어빵 제공 여부를 저장하기 위한 변수.
			boolean isPossible = true;
			
			//도착 순으로, 사람의 수만큼 돌면서 붕어빵 제공 여부 확인
			for (int i=0; i<n; i++) {
				//i번째에 도착하는 사람의 도착 시간을 저장하기 위한 변수
				int pre = arrives[i];
				
				//만일 처음으로 도착한 사람인 경우엔 이 사람의 앞 사람이 없기 때문에
				//0부터 처음 도착한 사람의 시간까지의 붕어빵 개수 업데이트.
				if (i==0) {
					updateSum(0,pre);
				}
				//첫 번째 도착 이외에는 자신의 앞 순서가 있기 때문에,
				//자신의 앞순서 이후부터 자신이 도착한 시간까지 제작된 붕어빵 수를 더해주기.
				else {
					int before = arrives[i-1];
					updateSum(before,pre);
				}
				
				//만일 현재 붕어빵이 존재한다면
				//맛있게 먹기(붕어빵 수 하나 줄여주기)
				if (sum>0) {
					sum--;
				}
				//붕어빵이 존재하지 않는다면
				//대기 없이 붕어빵 제공 실패
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
	
	
	//이전에 도착했던 사람의 시간 이후부터 현재 도착한 사람의 시간 사이에 제작된 붕어빵의 수를 update 해주기 위한 함수
	public static void updateSum(int before, int pre) {
		for (int i=before+1; i<=pre; i++) {
			if (i%m==0 && i!=0) {
				sum+=k;
			}
		}
	}
}