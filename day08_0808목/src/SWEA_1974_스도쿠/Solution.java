package SWEA_1974_스도쿠;

import java.util.Scanner;

public class Solution {
	//스도쿠 판과, 번호가 겹치지 않는지 확인하는 변수를 메서드에서 사용하기 위해 static선언
	static int[][]map;
	static int check;
	public static void main(String[]args) {
		Scanner sc= new Scanner(System.in);
		int t = sc.nextInt();
		//테스트 케이스만큼 반복
		for (int round=1; round<=t; round++) {
			//스도쿠가 맞을 때 1, 아닐 때 0을 저장하는 변수. 매라운드마다 초기화
			check = 1; 
			//매라운드마다 스도쿠판 초기화
			map = new int[9][9];
			//스도쿠판 값 입력받기
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			
			//스도쿠 한 칸씩 돌면서, 행이 0일 때, 열이 0일때, 행과 열 모두 3의 배수일 때마다
			//검사할 숫자 9개를 뽑아내고, 숫자 중복 여부 체크하기
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					//행이 0일 때 세로줄 만들어서 검사하기
					if (i==0) {
						int[]nums = makeColNums(j);
						checkRepeated(nums);
						if (check==0) {
							break;
						}
					}
					
					//열이 0일 때 가로줄 만들어서 검사하기
					if (j==0) {
						int[]nums = makeRowNums(i);
						checkRepeated(nums);
						if (check==0) {
							break;
						}
					}
					
					//행과 열의 값이 3의 배수일 때 정사각형 모양 만들어서 검사하기
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
	
	//중복 여부 검사를 위한 메서드
	public static void checkRepeated(int[]nums) {
		//1~9까지 나왔는지 체크하기 위한 boolean 배열
		//index로 해당 숫자가 나왔는지 체크하기
		boolean[]checked = new boolean[10];
		for (int i=0; i<9; i++) {
			//현재 체크하는 숫자가 이미 이전에 나온 적이 있다면,
			//check변수를 0으로 변경.
			if (checked[nums[i]]) {
				check = 0;
				break;
			}
			//나온 적이 없다면 true로 바꿔주기
			else {
				checked[nums[i]]=true;
			}
		}
	}
	//세로줄. 해당 행의 값을 기준으로 map판에서 세로줄을 뽑아 9자리 배열로 만들어주기
	public static int[] makeColNums(int x) {
		int[]nums = new int[9];
		for (int i=0; i<9; i++) {
			nums[i]=map[x][i];
		}
		return nums;
	}
	
	//가로줄 . 해당 열의 값을 기준으로 map판에서 가로줄을 뽑아 9자리 배열로 만들어주기.
	public static int[]makeRowNums(int x){
		int[]nums = new int[9];
		for (int i=0; i<9; i++) {
			nums[i]=map[i][x];
		}
		return nums;
	}
	
	//정사각형 . 해당 행과 열의 값을 기준으로 3*3 정사각형 안에 있는 값을 9자리 배열에 담아주기
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