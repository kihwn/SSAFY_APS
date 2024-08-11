package SWEA_의석이의_세로로_말해요;

import java.util.*;

public class Solution {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int round=1; round<=testCase; round++) {
			StringBuilder sb = new StringBuilder();
			String[]words = new String[5];
			int maxLength = 0;
			
			for (int i=0; i<5; i++) {
				words[i]=sc.next();
				if (words[i].length()>maxLength) {
					maxLength = words[i].length();
				}
			}
			
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
