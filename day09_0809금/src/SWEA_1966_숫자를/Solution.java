package SWEA_1966_숫자를;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			int n = sc.nextInt();
			int[]arr = new int[n];
			for (int i=0; i<n; i++) {
				arr[i]=sc.nextInt();
			}
			arr=doInsertionSort(arr);
			
			System.out.print("#"+round+" ");
			for (int i=0; i<n; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
		}
	}

	public static int[] doInsertionSort(int[] arr) {
		// 삽입 정렬
		// i : 정렬되지 않은 집합의 첫번째 원소
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i];
			int j;
			// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
			for (j = i - 1; j >= 0 && arr[j] > data; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;
			//System.out.println(Arrays.toString(arr));
		}
		return arr;
	}

}