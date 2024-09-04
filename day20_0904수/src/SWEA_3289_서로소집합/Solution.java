package SWEA_3289_서로소집합;

import java.util.Scanner;

public class Solution {
	static int n;
	static int m;
	static int[]parents;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(round);
			sb.append(" ");
			n = sc.nextInt();
			m = sc.nextInt();
			parents = new int[n+1];
			
			for (int i=1; i<=n; i++) {
				parents[i]=i;
			}
			
			for (int i=0; i<m; i++) {
				int cal = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if (cal==0) {
					if (findParents(a)!=findParents(b)) {
						union(a,b);
					}
				}else {
					if (findParents(a)==findParents(b)) {
						sb.append("1");
					}
					else {
						sb.append("0");
					}
				}
			}//m번의 연산 끝.
			System.out.println(sb);
		}
	}
	
	static void union(int a, int b) {
		int p = findParents(a);
		int q = findParents(b);
		parents[q]=p;
	}
	
	static int findParents(int n) {
		if (parents[n]==n) {
			return n;
		}
		return parents[n]=findParents(parents[n]);
	}
	
	
}