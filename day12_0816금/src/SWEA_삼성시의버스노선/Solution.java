package SWEA_삼성시의버스노선;

import java.io.*;
import java.util.*;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int round=1; round<=t; round++) {
        	//버스정류장들. 이 곳에 몇 개의 노선이 방문할 지를 담게 됨. 
            int[]bus = new int[5001];
            int n = sc.nextInt();
            
            //버스 노선 n번만큼 반복하여 각 노선이 방문하는 정류장들의 값을 업데이트해주기 
            for (int i=0; i<n; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                 
                for (int j=a; j<=b; j++) {
                    bus[j]++;
                }
            }
             
            int p = sc.nextInt();
            //최종적으로 정답을 담을 변수. p개의 버스 정류장에 대해 몇 개의 노선이 다니는지 담을 것. 
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