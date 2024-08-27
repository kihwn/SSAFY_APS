package SWEA_4012_요리사;

import java.util.Scanner;

public class Solution {
	static int[][]map;
	static int n;
	static boolean[]visited;
	static long result;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		//테스트 케이스만큼 반복
		for (int round=1; round<=t; round++) {
		n = sc.nextInt();
		map = new int[n][n];
		//묶음을 구분하기 위한 boolean 배열(방문한 것과 방문 안한 것끼리 구분할 것)
		visited = new boolean[n];
		//일단 최댓값 넣어두고 묶음 별로 min값 업데이트 예정
		result = Long.MAX_VALUE;
		//input 칸 채우기
 		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				map[i][j]=sc.nextInt();
			}
		}
 		
 		//두 묶음의 차를 구할 것. 아무것도 안 들어있는 현재의 두 묶음은 차이가 없음.
 		//일단 인덱스 0의 재료를 한쪽에 넣었다고 고정하자.
 		visited[0]=true;
 
 		combination(0,1);
 		System.out.println("#"+round+" "+result);
		}
	}
	
	//n/2개씩 두 묶음의 조합을 구할 함수
	public static void combination(int idx, int size) {
		//묶음의 크기가 n/2가 되면 바로 두 묶음 간 차를 구해주기.
		 if (size==n/2) {
			 calculate();
			 return;
		 }
		 
		 //현재 바라보고 있는 idx의 바로 다음 숫자(idx2라고 가정)부터 순서대로
		 // idx2를 방문을 안했다면, 방문처리 하고, 재귀 시작.
		 // 해당 idx와 idx2를 포함하는 묶음을 재귀를 통해 n/2사이즈가 될 때까지 만들어주고 값 계산.
		 // 이후에 idx2를 방문한 것을 다시 false로 바꾸어서 복원수행이 가능하게 함.
		 
		 for (int i=idx+1; i<n; i++) {
			 if (!visited[i]) {
			 visited[i]=true;
			 combination(i,size+1);
			 visited[i]= false;
		 }
		}
	}
	
	public static void calculate() {
		//sum1은 visited가 된 애들끼리의 시너지 계산,
		//sum2는 visited가 안된 애들끼리의 시너지 계산
		int sum1 = 0;
		int sum2 =0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				if (visited[i] && visited[j]) {
					sum1+=map[i][j]+map[j][i];
				}
				else if (!visited[i]&&!visited[j]) {
					sum2+=map[i][j]+map[j][i];
				}
			}
		}
		//묶음이 정해질 때마다 이전까지의 result와 현재 구한 차 중 작은 값으로 업데이트
		result = Math.min(result,Math.abs(sum1-sum2));
	}
}