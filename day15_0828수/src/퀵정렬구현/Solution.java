package 퀵정렬구현;

import java.util.Arrays;

public class Solution {
	static int[]arr = {2,91,20,21,13,9,38,11};
	static int n = arr.length;
	public static void main(String[]args) {
		quickSort(0,n-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int left, int right) {
		//left : 시작 인덱스 , right : 마지막 인덱스
		if (left<right) {
			//배열을 피봇을 기준으로 두 부분으로 나누고, 피봇 리턴받음.
			int pivot = partition(left,right);
			quickSort(left,pivot-1);
			quickSort(pivot+1,right);
		}
	}
	
	//피봇의 위치 반환
	static int partition (int left, int right) {
		//피봇 초기값
		int pivot = arr[left];
		//피봇이 left값이기 때문에 L은 그 다음 값부터 피봇보다 큰 값을 찾기 위한 값.
		//R은 배열 끝부터 피봇보다 작은 값 찾기 위한 값
		int L = left+1, R = right;
		while(L<=R) {
			while(L<=R && arr[L]<=pivot)
				L++;
			while(arr[R]>pivot)
				R --;
			
			//L이 R보다 작거나 같은 경우까지는
			//pivot보다 큰 L과 pivot보다 작은 R을 서로 뒤바꿔줌.
			if (L<R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R]=tmp;
			}
		}
		
		//R의 위치는 피봇이 가야 할 위치. R의 위치가 피봇보다 작은 값과 큰 값의 경계가 되기 때문.
		
		int tmp = arr[left];
		arr[left]=arr[R];
		arr[R]=tmp;
		return R;
	}

}