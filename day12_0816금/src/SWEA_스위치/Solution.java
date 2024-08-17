package SWEA_스위치;

import java.io.*;
import java.util.*;

public class Solution {
    static int[]lights;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]lights = new int[n+1];
        lights[0]=0;

        
        for (int i=0; i<n; i++){
            lights[i+1]=sc.nextInt();
        }

        int st = sc.nextInt();

        for (int i=0; i<st; i++){
            int a = sc.nextInt();
            int b= sc.nextInt();

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
            else{
                if (lights[b]==1){
                    lights[b]=0;
                }
                else{
                    lights[b]=1;
                }
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