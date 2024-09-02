package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int[]a;
	static int[]b;
	static boolean[]visited;
	static boolean[]nums;
	static int gyu;
	static int young;
	static int eachGyu;
	static int eachYoung;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			gyu=0;
			young=0;
			visited = new boolean[9];
			//a는 규영이의 카드, b는 인영이의 카드를 의미.
			a = new int[9];
			b = new int[9];
			nums = new boolean[18];
			for (int i=0; i<9; i++) {
				a[i]=sc.nextInt();
				nums[a[i]-1]=true;
			}
			
			//nums의 0~17 인덱스를 바라보며 규영이가 갖지 않은 카드는 인영이에게 줌
			//카드는 1~18 사이의 숫자이므로 b배열에는 i+1로 값을 넣음.
			for (int i=0,idx=0; i<18; i++) {
				if(!nums[i])
					b[idx++]=i+1;
			}
			
			
			combination(0,0,0);
			System.out.println("#"+round+" "+gyu+" "+young);
		}//각라운드
	}//메인
	
	//eachGyu와 eachYoung은 바뀌는 인영이의 카드 조합마다의 카드 점수 총합을 의미.
	public static void combination(int depth, int eachGyu, int eachYoung) {
		//9번 카드까지 비교했을 때 총점이 높은 사람에게 점수 부여 (gyu와 young이 최종적으로 프린트할 규영이와 인영이의 점수)
		if (depth==9) {
			if (eachGyu>eachYoung)
				gyu++;
			else if (eachGyu<eachYoung)
				young++;
			return;
		}
		
		//i는 인영이의 카드 인덱스를 나타냄. visited[]를 통해 중복 방문 방지. 
		for (int i=0; i<9; i++) {
			if (!visited[i]) {
				visited[i]=true;
				if (a[depth]>b[i])
					combination(depth+1,eachGyu+a[depth]+b[i],eachYoung);
				else if (a[depth]<b[i])
					combination(depth+1,eachGyu,eachYoung+a[depth]+b[i]);

				visited[i]=false;
			}
			
		}
	}
	
	

}