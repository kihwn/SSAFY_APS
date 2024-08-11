//package SWEA_1974_스도쿠;

import java.util.Scanner;

public class Solution {
	static int[][]map;
	static int check;
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		for (int round=1; round<=t; round++) {
			//스도쿠가 맞을 때 1, 아닐 때 0을 저장하는 변수
			check = 1; 
			map = new int[9][9];
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					if (i==0) {
						int[]nums = makeColNums(j);
						checkRepeated(nums);
						if (check==0) {
							break;
						}
					}
					if (j==0) {
						int[]nums = makeRowNums(i);
						checkRepeated(nums);
						if (check==0) {
							break;
						}
					}
					if (i%3==0 && j%3==0) {
						int[]nums = makeSquareNums(i,j);
						checkRepeated(nums);
						if (check==0) {
							break;
						}
					}
				}
			}
			
			System.out.println("#"+round+" "+check);
		}
	}
	//배열 내에 중복 숫자 있는지 체크
	public static void checkRepeated(int[]nums) {
		boolean[]checked = new boolean[10];
		for (int i=0; i<9; i++) {
			if (checked[nums[i]]) {
				check = 0;
				break;
			}
			else {
				checked[nums[i]]=true;
			}
		}
	}
	//세로줄
	public static int[] makeColNums(int x) {
		int[]nums = new int[9];
		for (int i=0; i<9; i++) {
			nums[i]=map[x][i];
		}
		return nums;
	}
	
	//가로줄
	public static int[]makeRowNums(int x){
		int[]nums = new int[9];
		for (int i=0; i<9; i++) {
			nums[i]=map[i][x];
		}
		return nums;
	}
	
	//정사각형
	public static int[]makeSquareNums(int x, int y){
		int[]nums = new int[9];
		int idx = 0;
		for (int i=x; i<x+3; i++) {
			for(int j=y; j<y+3; j++) {
				nums[idx++]=map[i][j];
			}
		}
		return nums;
	}
}