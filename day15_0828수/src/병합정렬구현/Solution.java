package 병합정렬구현;

import java.util.Arrays;

public class Solution {
	static int[]arr = {2,91,20,21,13,9,38,11};
	static int n = arr.length;
	static int[]tmp = new int[n];
	public static void main(String[]args) {
		mergeSort(0,n-1);
		System.out.println(Arrays.toString(arr));
		
	}
	
	static void mergeSort(int left, int right) {
		if (left<right) {
			int mid = (left+right)/2;
			//가운데 기준으로 앞부분 정렬,
			//뒷부분 정렬
			//후 두 개 합치기
			mergeSort(left,mid);
			mergeSort(mid+1,right);
			merge(left,mid,right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left; //왼쪽은 left~mid까지
		int R = mid+1; //오른쪽은 mid+1~right까지
		int idx = left; //tmp배열의 인덱스
		
		//L과 R이 각각 가리키는 요소를 비교하며 작은 값을 tmp 배열에 복사하기.
		while(L<=mid && R<=right) {
			//L이 더 작을 경우 L에 해당하는 값을 tmp에 저장
			if (arr[L]<=arr[R]) {
				tmp[idx++]=arr[L++];
			}else {
			//R이 더 작을 경우 R에 해당하는 값을 tmp에 저장
				tmp[idx++]=arr[R++];
			}
		}
		
		//왼쪽이든 오른쪽이든 동시에 끝나지 않음. 무언가 남게 됨.
		//왼쪽 구간의 값이 남은 경우
		if (L<=mid) {
			for (int i=L; i<=mid; i++) {
				tmp[idx++]=arr[i];
			}
		}
			
			//오른쪽 구간의 값이 남은 경우.
			else {
				for (int i=R; i<=right; i++) {
					tmp[idx++]=arr[i];
				}
				
			}
		
		
		for (int i=left; i<=right; i++) {
			arr[i]=tmp[i];
		}
	}

}