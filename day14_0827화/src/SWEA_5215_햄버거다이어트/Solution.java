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
			//가능한 최대 맛
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
		//칼로리 초과 반환
		if (cal>l) {
			return;
		}
		//칼로리 초과 안하면 해당 맛과 max값 비교 업데이트
		max = Math.max(max, flavor);
		
		//i번째 인덱스 재료 선택
		for (int i=idx; i<n; i++) {
			combination(i+1,cal+cals[i],flavor+scores[i]);
		}
	}

}