package SWEA_1248_공통조상;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int[] parent;
	static int[][]binary;
	static int subtreeSize;
	static int maxAnc;
	static ArrayList<Integer> anc1;
	static ArrayList<Integer> anc2;
	static int v;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		for (int round=1; round<=t; round++) {
			//정점 개수
			v = sc.nextInt();
			// 간선의 개수
			int e = sc.nextInt();
			//정점1
			int node1 = sc.nextInt();
			//정점2
			int node2 = sc.nextInt();
			binary = new int[v+1][2];
			parent = new int[v+1];
			subtreeSize = 0;
			maxAnc = 0;
			for (int i=0; i<e; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				if (binary[start][0]==0) {
					binary[start][0]=end;
				}
				else {
					binary[start][1]=end;
				}
				parent[end]=start;
			}
			findAncList(node1, node2);
			Collections.sort(anc1);
			Collections.sort(anc2);
			for (int i=0; i<anc1.size(); i++) {
				System.out.print(anc1.get(i)+" ");
			}
			System.out.println();
			for (int i=0; i<anc2.size(); i++) {
				System.out.print(anc2.get(i)+" ");
			}
			System.out.println();
			findMaxAnc();
			calSubSize(maxAnc);
			System.out.println("#"+round+" "+maxAnc+ " "+subtreeSize);
			
		}
	}
	
	public static void findAncList(int node1, int node2) {
		anc1 = new ArrayList<>();
		anc2 = new ArrayList<>();
		while(node1!=0) {
			anc1.add(node1);
			node1 = parent[node1];
		}
		while(node2!=0) {
			anc2.add(node2);
			node2 = parent[node2];
		}
	}
	
	public static void findMaxAnc() {
			for (int i=anc1.size()-1; i>=0; i--) {
				for (int j=anc2.size()-1; j>=0; j--) {
					if (anc1.get(i)==anc2.get(j)) {
						maxAnc = Math.max(maxAnc, anc1.get(i));
					}
				}
			}
    }

	
	
	public static void calSubSize(int node) {
		if (node==0)
			return;
		subtreeSize++;
		calSubSize(binary[node][0]);
		calSubSize(binary[node][1]);
	}

}