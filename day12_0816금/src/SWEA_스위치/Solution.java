package SWEA_스위치;

import java.io.*;
import java.util.*;

public class Solution {
    static int[]lights;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        //스위치 1~n까지 입력받기. idx를 위해 n+1까지로 받고, idx 0은 0으로 초기화 명시 
        int[]lights = new int[n+1];
        lights[0]=0;

        //스위치 상태 입력받
        for (int i=1; i<=n; i++){
            lights[i]=sc.nextInt();
        }
        
        //학생 수
        int st = sc.nextInt();

        for (int i=0; i<st; i++){
        	//a : 성별, b =받은 수 
            int a = sc.nextInt();
            int b= sc.nextInt();

            // 성별 1이면, b의 배수 전등의 상태 바꿔주기 
            if (a==1){
                for (int j=1; j*b<=n; j++){
                    if (lights[j*b]==0){
                        lights[j*b]=1;
                    }
                    else{
                        lights[j*b]=0;
                    }
                }
            }
            // 성별이 2(여자)인 경우 일단 내가 받은 번호의 스위치 값 변경 
            else{
                if (lights[b]==1){
                    lights[b]=0;
                }
                else{
                    lights[b]=1;
                }
                //start : 왼쪽 시작 값
                //end : 오른쪽 시작 값 
                //start와 end를 둘 값이 같은 경우 start는 왼쪽으로, end는 오른쪽으로 계속 옮기며
                //최대 대칭 범위를 찾아 계산 
                int start = b-1;
                int end = b+1;

                while(start>0 && end<=n){
                    if (lights[start]==lights[end]){
                        if (lights[start]==0){
                            lights[start]=1;
                            lights[end]=1;
                        }
                        else{
                            lights[start]=0;
                            lights[end]=0;

                        }
                        start--;
                        end++;
                    }
                    else{
                        break;
                    }
                }

            }
        }
        for (int i=1; i<=n; i++){
            System.out.print(lights[i]+" ");
            if (i%20==0){
                System.out.println();
            }
        }
    }
}