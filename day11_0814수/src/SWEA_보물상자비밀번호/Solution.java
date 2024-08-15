package SWEA_보물상자비밀번호;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
	static int oneSide;
	static String[]inputs;
	static ArrayList<Integer>nums;
	static String[]passwords;
	
	public static void main(String[]args) {
		Scanner sc= new Scanner (System.in);
		int t = sc.nextInt();
		
		for (int round=1; round<=t; round++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			oneSide = n/4;
			inputs = new String[n];
			nums = new ArrayList<>();
			String s = sc.next();
			String[]sarr = s.split("");
			passwords = new String[n];
			for (int i=0; i<n; i++) {
				inputs[i]=sarr[i];
			}
			
			for (int i=0; i<n; i++) {
				String password = "";
				for (int j=i; j<i+oneSide; j++) {
					if (j<n) {
					password += inputs[j];}
					else {
						int idx = j-n;
						password+=inputs[idx];
					}					
				}
				passwords[i]=password;
			}
			
			findPossibleNum();
			
			ArrayList<Integer>nums2 = new ArrayList<>();
			for (int i=0; i<nums.size(); i++) {
				int tmp = nums.get(i);
				if (!nums2.contains(tmp)) {
					nums2.add(tmp);
				}
			}
			Collections.sort(nums2);

			int idx = nums2.size()-m;
			System.out.println("#"+round+" "+nums2.get(idx));
			
		}
		

	}
	
	static void findPossibleNum() {
		for (int i=0; i<passwords.length; i++) {
			String original = passwords[i];
			String[]splitOrigin = original.split("");
			int afterPassword = 0;
			for (int j=0; j<oneSide; j++) {
				int tmp =matchAlpha(splitOrigin[j]);
				tmp *= for16(oneSide-1-j);
				afterPassword+=tmp;
			}
			nums.add(afterPassword);
		}
		
	}
	
	static int for16(int place) {
		int num=1;
		for (int i=0; i<place; i++) {
			num*=16;
		}
		return num;
	}
	
	static int matchAlpha(String s) {
		int num=1;
		
		char c = s.charAt(0);
		if (c>='0' && c<='9') {
			num = c-'0';
		}
		else {
			num = c-'A'+10;
		}
		return num;
	}
}
