package SWEA_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		for (int round = 1; round<=10; round++) {
			//테스트케이스 번호 필요X.
			sc.next();
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int result =1;
			
			result = pow(n,m);
			System.out.println("#"+round+" "+result);
		}
	}
	
	static int pow(int n, int m) {
		if (m==1) {
			return n;
		}
		if (m%2==0) {
			int tmp = pow(n,m/2);
			return tmp*tmp;
		}
		else {
			int tmp = pow(n,(m-1)/2);
			//홀수 개일 때 n을 한 번 더 곱해줘야 함.
			return tmp*tmp*n;
		}
	}

}