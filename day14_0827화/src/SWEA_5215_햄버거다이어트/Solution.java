package SWEA_5215_햄버거다이어트;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int n,l;
	static int[]scores,cals;
	
	static int max;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			//n: 재료 수, l : 제한 칼로린, scores: 재료맛, cals:재료칼로리
			n = sc.nextInt();
			l = sc.nextInt(); 
			scores = new int[n];
			cals = new int[n];
			//가능한 최대의 맛 최댓값으로 업데이트
			max =0;
			for (int i=0; i<n; i++) {
				scores[i]=sc.nextInt();
				cals[i]=sc.nextInt();
			}
			combination(0,0,0);
			
			System.out.println("#"+round+" "+max);
		}
	}
	
	public static void combination(int idx, int cal, int flavor) {
		if (cal>l) {
			return;
		}
		
		max = Math.max(max, flavor);
		//i번 인덱스 선택 시, 맛과 칼로리와 업데이트 후, 인덱스 값 늘려주기
		for (int i=idx; i<n; i++) {
			combination(i+1,cal+cals[i],flavor+scores[i]);
			
		}
	}

}