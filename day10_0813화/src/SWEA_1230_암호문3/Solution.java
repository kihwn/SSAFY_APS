package SWEA_1230_암호문3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		
		for (int round=1; round<=10; round++) {
			//암호문 길이
			int size = sc.nextInt();
			//원본 암호문
			ArrayList<Integer>nums = new ArrayList<>();
			
			for (int i=0; i<size; i++) {
				int tmp = sc.nextInt();
				nums.add(tmp);
			}
			
			//명령어 개수
			int missonSize = sc.nextInt();
			for (int i=0; i<missonSize; i++) {
				//명령어
				String s = sc.next();
				
				if (s.equals("I")) {
					//삽입할 위치
					int idx = sc.nextInt();
					
					//삽입할 숫자 개수
					int inputSize = sc.nextInt();
					
					//삽입할 숫자들
					ArrayList<Integer>inputNums = new ArrayList<>();
					
					//삽입할 숫자들 입력받고
					for (int j=0; j<inputSize; j++) {
						int tmp = sc.nextInt();
						inputNums.add(tmp);
					}
					
					
					//삽입할 idx부터 삽입할 숫자 사이즈만큼 원본 배열에 추가해주기
					for (int k=idx,cnt=0; k<idx+inputSize; k++,cnt++) {
						nums.add(k,inputNums.get(cnt));
					}
				}
				else if (s.equals("D")) {
					//삭제할 위치
					int idx = sc.nextInt();
					//삭제할 개수
					int deleteSize = sc.nextInt();
					
					for (int k=0; k<deleteSize; k++) {
						nums.remove(idx);
					}
				}
				else if (s.equals("A")) {
					//더할 개수
					int addSize = sc.nextInt();
					
					//삽입할 숫자들
					ArrayList<Integer>inputNums = new ArrayList<>();
					
					//삽입할 숫자들 입력받고
					for (int j=0; j<addSize; j++) {
						int tmp = sc.nextInt();
						inputNums.add(tmp);
					}
					
					//맨 마지막 위치 찾아서 더해주기
					int last = nums.size();
					for (int j=0; j<addSize; j++) {
						nums.add(last+j,inputNums.get(j));
					}

				}
			}
					
			
				
				
			System.out.print("#"+round+" ");
			for (int i=0; i<nums.size(); i++) {
				if (i<10) {
				System.out.print(nums.get(i)+" ");
				}
				else {
					break;
				}
				
			}
			System.out.println("");
		}
		
	}

}