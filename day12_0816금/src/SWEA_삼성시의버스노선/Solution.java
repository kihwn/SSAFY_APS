package SWEA_삼성시의버스노선;

import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int round=1; round<=t; round++) {
            int[]bus = new int[5001];
            int n = sc.nextInt();
             
            for (int i=0; i<n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                 
                for (int j=a; j<=b; j++) {
                    bus[j]++;
                }
            }
             
            int p = sc.nextInt();
            int[]nums = new int[p];
            for (int i=0; i<p; i++) {
                int tmp = sc.nextInt();
                nums[i]=bus[tmp];
            }
             
             
            System.out.print("#"+round+" ");
            for (int i=0; i<p; i++) {
                System.out.print(nums[i]+" ");
            }
            System.out.println();
        }
    }
}