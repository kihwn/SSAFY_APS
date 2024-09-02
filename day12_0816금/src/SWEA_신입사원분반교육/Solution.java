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
            //n명의 점수를 입력받기.
            for (int i=0; i<n; i++) {
                scores[i]=sc.nextInt();
            }
            //점수를 오름차순으로 정렬
            Arrays.sort(scores);
            //동일한 점수를 가진 사람이 max명을 초과하는지 체크하기 위한 변
            boolean isPossible = true;
            
            //점수 중 최댓값 
            int scoreMax = scores[n-1];
            //0점부터 최대 점수까지 배열로 생성 
            nums = new int[scoreMax+1];
            
            //특정 점수를 가진 사람의 수를 체크하고, 그 수가 max를 초과하는지 체크.
            for (int i=0; i<n; i++) {
                nums[scores[i]]++;
                if (nums[scores[i]]>max) {
                    isPossible=false;
                    break;
                }
            }
             
            //a : 0~score1 사이의 점수를 가진 사람의 수
            //b : score1+1 ~score2까지의 점수를 가진 사람 수 
            //c : score2+1 ~최대 점수까지 사이의 사람 수 
            int a = 0; 
            int b =0;
            int c =0;
            //a,b,c 간 차를 최소로 업데이트 변수 
            int diff = Integer.MAX_VALUE;
            //만일 최소로 업데이트 할 diff 값이 max보다 크면 조건 불만족 
            boolean isFlag = false;
            
            
            //j는 score1값, i는 score2값을 의미 
            for (int i=1; i<scoreMax; i++) {
                for (int j=0; j<i; j++) {
                    a = countPeople(0,j);
                    b = countPeople(j+1,i);
                    c = countPeople(i+1,scoreMax);
                    // 각 구역의 사람 수는 min값 이상이어야 함. 
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
    //start 점수 이상, finish 점수 이하 점수 구간에 속하는 사람 수 반환 
    public static int countPeople(int start, int finish) {
        int cnt = 0;
         
        for (int i=start; i<=finish; i++) {
            cnt+=nums[i];
        }
        return cnt;
         
    }
}