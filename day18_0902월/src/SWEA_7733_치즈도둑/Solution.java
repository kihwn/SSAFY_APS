package SWEA_7733_치즈도둑;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int[]dx = {-1,1,0,0}; //상하좌우
	static int[]dy= {0,0,-1,1};
	static int n;
	static int[][]map;
	static boolean[][]visited;
	static int max;
	public static void main(String[]args) {
		Scanner sc =  new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			n = sc.nextInt();
			map = new int[n][n];
			max =0;
			//최대 치즈의 맛 = maxT, 최소 치즈의 맛 = min
			int maxT=0;
			int min=100;
			//좌표평면 채워주고, 최대치즈맛과 최소치즈맛 구하기
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					map[i][j]=sc.nextInt();
					maxT = Math.max(map[i][j], maxT);
					min = Math.min(map[i][j], min);
				}
			}
			
			//최소치즈맛 직전부터 최대맛까지 매번의 덩어리 개수 체크하기.
			for (int s=min-1; s<=maxT; s++) {
				//s의 의미는 s초 지났을 때를 의미.
				//매 초마다 덩어리 개수를 구하기 위해 visited는 초기화
				visited=new boolean[n][n];
				int cnt=0;
				for (int i=0; i<n; i++) {
					for (int j=0; j<n; j++) {
						if (!visited[i][j] && map[i][j]>s) {
							bfs(i,j,s);
							//cnt는 덩어리 개수
							cnt++;
						}
					}
				}
				max = Math.max(max, cnt);
				
			}
			System.out.println("#"+round+" "+max);
			
		}
	}
	
	static void bfs(int x, int y,int z) {
		Queue<Pair>queue = new LinkedList<>();
		visited[x][y]=true;
		queue.add(new Pair(x,y));
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int i=0; i<4; i++) {
				int nextX = pair.x+dx[i];
				int nextY = pair.y+dy[i];
				//가능한 범위 체크
				if (nextX>=0 && nextX<n && nextY>=0 && nextY<n) {
					//방문한 적 없고, 해당 초보다 값이 커야 덩어리가 남아있음
					if (!visited[nextX][nextY]&& map[nextX][nextY]>z) {
						visited[nextX][nextY]=true;
						queue.add(new Pair(nextX,nextY));
					}
				}
			}
		}
	}
}

class Pair {
	int x;
	int y;
	
	Pair(int x, int y){
		this.x=x;
		this.y=y;
	}
}
