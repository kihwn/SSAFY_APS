package SWEA_2806_NQueen;

import java.util.Scanner;

public class Solution {
	static int n;
	static int[][]board;
	static int ans;
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			n = sc.nextInt();
			board = new int[n][n];
			ans = 0;
			combination(0);
			System.out.println("#"+round+" "+ans);
		}
		
	}
	
	static void combination(int depth) {
		//depth는 행을 의미.
		//체스판 완성혀려면 n-1번 행까지 퀸이 위치해야 함
		if (depth==n) {
			ans++;
			return;
		}
		
		for (int i=0; i<n; i++) {
			
			if (board[depth][i]==0) {
				
				makeBoard(depth,i,1);
				combination(depth+1);
				//원상태로 복귀
				makeBoard(depth,i,-1);}
		}
	}
	//x,y : 퀸을 놓으려는 위치, make는 1과 -1을 넣어서 해당 위치에 둘 경우 나머지 부분 변화와, -1로 원상태 복귀
	static void makeBoard(int x, int y, int make) {
		for (int i=0; i<n; i++) {
			//가로세로
			board[x][i]+=make;
			board[i][y]+=make;
			//대각선
			if (isPossible(x-i,y+i))
				board[x-i][y+i]+=make;
			
			if (isPossible(x+i,y-i))
				board[x+i][y-i]+=make;
			
			if (isPossible(x+i,y+i))
				board[x+i][y+i]+=make;
			
			if (isPossible(x-i,y-i))
				board[x-i][y-i]+=make;
		}
		
		board[x][y]-=5*make;
		
		
	}
	static boolean isPossible(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}