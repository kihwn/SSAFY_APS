package SWEA_2805_농작물;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //테스트케이스 수 입력받기
        int t = sc.nextInt();

        //테스트 케이스만큼 반복
        for (int round = 1; round <= t; round++) {
            //출력할 합산의 값을 위한 변수
            int sum = 0;
            //각 라운드마다 map의 사이즈를 받기 위한 변수
            int n = sc.nextInt();
            //이후에 들어올 값이 띄어쓰기 없이 들어오기 때문에
            //한 줄씩 받아오기 위해 비워주기.
            sc.nextLine();
            //사이즈에 맞는 map생성
            int[][] map = new int[n][n];
            //각 위치가 방문됐는지 체크를 위한 boolean 2차배열
            boolean[][] checked = new boolean[n][n];
            //map 채우기
            for (int i = 0; i < n; i++) {
                String line = sc.nextLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = line.charAt(j) - '0';
                }
            }


            // 농작물의 값 계산하는 부분 수정!
            //첫 행에서 더할 열의 좌표는 가운데 부분으로,
            //더할 열의 왼쪽과 오른쪽은 같음.
            int leftRow = n / 2;
            int rightRow = n / 2;
            //행만큼 반복
            for (int i = 0; i < n; i++) {
                for (int j = leftRow; j <= rightRow; j++) {
                    sum += map[i][j];
                }
                //행이 절반보다 작을 경우, 열의 시작점을 왼쪽으로 한 칸, 오른쪽으로 한 칸씩 넓혀주기
                if (i < n / 2) {
                    leftRow--;
                    rightRow++;
                }
                //그 다음부턴, 열의 시작점을 왼쪽과 오른쪽 모두 한 칸식 좁혀주기
                else {
                    leftRow++;
                    rightRow--;
                }
            }
            System.out.println("#" + round + " " + sum);
        }
    }
}
