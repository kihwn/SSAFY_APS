package SWEA_2817_부분수열의합;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	static int n;
	static int k;
	//뽑은 숫자들
	static ArrayList<Integer>selects;
	//입력받은 n개의 숫자
	static int[]nums;
	//뽑은 숫자 합
	static int cnt;
	//중복 방진ㄴ
	static boolean[]visited;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			n = sc.nextInt();
			k = sc.nextInt();
			cnt = 0;
			selects = new ArrayList<>();
			visited = new boolean[n];
		
			nums=new int[n];
			for (int i=0; i<n; i++) {
				nums[i]=sc.nextInt();
			}
			combination(0,0);
			System.out.println("#"+round+" "+cnt);
		}

	}
	
	static void combination(int idx,int depth) {
		int sum = 0;
		//합이 k이면 count하고 반환.
		if (selects.size()>0) {
		for (int i=0; i<selects.size(); i++) {
			sum+=selects.get(i);
		}}
		if (sum==k) {
			cnt++;
			return;
		}

		
		for (int i = idx; i<n; i++) {
			if (!visited[i]) {
				visited[i]=true;
				selects.add(nums[i]);
				combination(i+1,depth+1);
				visited[i]=false;
				selects.remove(selects.size()-1);
				
			}
		}
	}

}
