package BOJ.구현;

import java.util.Scanner;

public class 배열복원하기_16967번 {
    public static int h, w; // 배열 a크기
    public static int x, y; // 배열 a에 더해지는 값
    public static int[][] b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        h = sc.nextInt();
        w = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();

        // b배열 초기화
        b = new int[h + x][w + y];
        for (int i = 0; i < h + x; i++) {
            for (int j = 0; j < w + y; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // 겹치는 부분 빼주기
        for (int i = x; i < h + x; i++) {
            for (int j = y; j < w + y; j++) {
                b[i][j] = b[i][j] - b[i - x][j - y];
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println();
    }
}
