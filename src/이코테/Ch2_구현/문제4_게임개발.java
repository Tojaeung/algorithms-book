package 이코테.Ch2_구현;

import java.util.Scanner;

public class 문제4_게임개발 {
    public static int n, m, x, y, direction;
    // 맵 방문처리
    public static int[][] d = new int[50][50];
    // 맵 테이블
    public static int[][] arr = new int[50][50];

    // 북, 동, 남, 서
    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void turnLeft() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();
        // 처음 방문 확인
        d[x][y] = 1;

        // 맵 생성
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;


    }
}
