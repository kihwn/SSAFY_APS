package SWEA_1228_암호문1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		for (int round=1; round<=10; round++) {
			int size = sc.nextInt();
			ArrayList<Integer>nums = new ArrayList<>();
			
			for (int i=0; i<size; i++) {
				int tmp = sc.nextInt();
				nums.add(tmp);
			}
			int missonSize = sc.nextInt();
			for (int i=0; i<missonSize; i++) {
				String s = sc.next();
				int idx = sc.nextInt();
				int inputSize = sc.nextInt();
				ArrayList<Integer>inputNums = new ArrayList<>();
				
				for (int j=0; j<inputSize; j++) {
					int tmp = sc.nextInt();
					inputNums.add(tmp);
				}
				
				for (int k=idx,cnt=0; k<idx+inputSize; k++,cnt++) {
					nums.add(k,inputNums.get(cnt));
				}
			}
			System.out.print("#"+round+" ");
			for (int i=0; i<nums.size(); i++) {
				System.out.print(nums.get(i)+" ");
			}
			System.out.println("");
		}
		
	}

}