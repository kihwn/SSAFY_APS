package SWEA_의석이의_세로로_말해요;

import java.util.*;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//테스트케이스 수 입력받
		int testCase = sc.nextInt();
		
		//테스트케이스만큼 반
		for (int round=1; round<=testCase; round++) {
			//정답 단어를 묶기 위한 StringBuilder 객체 생
			StringBuilder sb = new StringBuilder();
			//초기에 input으로 들어오는 다섯 개의 단어를 담기 위한 배
			String[]words = new String[5];
			//입력 받은 단어들 중 가장 긴 길이를 저장할 변
			int maxLength = 0;
			
			//5번 반복하며 단어를 입력 받고, 가장 긴 단어 길이 업데이트
			for (int i=0; i<5; i++) {
				words[i]=sc.next();
				if (words[i].length()>maxLength) {
					maxLength = words[i].length();
				}
			}
			
			//단어의 최장 길이만큼 반복하여,
			//5개의 단어를 한 글자씩 가져오기.
			//만일 다섯 개의 단어 중 현재 체크할 단어의 길이가
			//체크할 인덱스인 i보다 작거나 같으면
			//해당 단어의 i번째 인덱스 글자는 없기 때문에,
			//단어의 길이가 i보다 클 경우에만 가져오기.
			for (int i=0; i<maxLength; i++) {
				for (int j=0; j<5; j++) {
					if (i<words[j].length()) {
						sb.append(words[j].charAt(i));
					}
				}
			}
			
			System.out.println("#"+round+" "+sb);
			 
		}
		
		
	}

}
