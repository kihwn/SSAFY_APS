package SWEA_신입사원분반교육;

import java.util.Arrays;
import java.util.Scanner;
 
 
public class Solution {
    static int[]nums;
    public static void main(String[]args) {
        Scanner sc= new Scanner (System.in);
        int t = sc.nextInt();
        for (int round=1; round<=t; round++) {
            int n = sc.nextInt();
            int min = sc.nextInt();
            int max = sc.nextInt();
            int[]scores = new int[n];
            for (int i=0; i<n; i++) {
                scores[i]=sc.nextInt();
            }
            Arrays.sort(scores);
            boolean isPossible = true;
             
            int scoreMax = scores[n-1];
            nums = new int[scoreMax+1];
             
            for (int i=0; i<n; i++) {
                nums[scores[i]]++;
                if (nums[scores[i]]>max) {
                    isPossible=false;
                }
            }
             
             
            int a = 0;
            int b =0;
            int c =0;
            int diff = Integer.MAX_VALUE;
            boolean isFlag = false;
             
            for (int i=1; i<scoreMax; i++) {
                for (int j=0; j<i; j++) {
                    a = countPeople(0,j);
                    b = countPeople(j+1,i);
                    c = countPeople(i+1,scoreMax);
                    if (a>=min && b>=min && c>min) {
                        isFlag = true;
                        int[] peoples = new int[3];
                        peoples[0]=a;
                        peoples[1]=b;
                        peoples[2]=c;
                        Arrays.sort(peoples);
                        diff = Math.min(diff, peoples[2]-peoples[0]);
                    }
                 
                }
            }
            if (diff>max) {
                isFlag = false;
            }
             
            if (isPossible && isFlag) {
                System.out.println("#"+round+" "+diff);
            }
            else {
                System.out.println("#"+round+" -1");
            }
             
             
        }
         
         
    }
     
    public static int countPeople(int start, int finish) {
        int cnt = 0;
         
        for (int i=start; i<=finish; i++) {
            cnt+=nums[i];
        }
        return cnt;
         
    }
}