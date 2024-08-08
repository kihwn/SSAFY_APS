package SWEA_1966_숫자를;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 입력받기
		int t = sc.nextInt();
		//테스트케이스만큼 반복
		for (int round=1; round<=t; round++) {
			//각 테스트케이스에서 들어오는 숫자의 수
			int n = sc.nextInt();
			//숫자들을 저장할 배열
			int[]arr = new int[n];
			//숫자 입력받기
			for (int i=0; i<n; i++) {
				arr[i]=sc.nextInt();
			}
			printArr (doInsertionSort(arr),round);
		
		}
	}
	// 삽입 정렬
	public static int[] doInsertionSort(int[] arr) {
		// i : 정렬되지 않은 집합의 첫번째 원소
		for (int i = 1; i < arr.length; i++) {
			int data = arr[i];
			int j;
			// 정렬된 집합의 뒤에서부터 비교하여 위치 찾아주기
			for (j = i - 1; j >= 0 && arr[j] > data; j--) {
				arr[j + 1] = arr[j];
			}
			arr[j + 1] = data;	
		}
		return arr;
	}
	
	//각 라운드의 배열을 프린트
	public static void printArr (int[]arr,int round){
		System.out.print("#"+round+" ");
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}