package BOJ.구현;

import java.util.Scanner;

// https://www.acmicpc.net/problem/16935
public class 배열돌리기3_16935번 {

    public static int n, m, r;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        map = new int[n][m];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                map[i][j] = sc.nextInt();
            }
        }

        while (r-- > 0) {
            int calc = sc.nextInt();

            switch (calc) {
                case 1:
                    one();
                    break;
                case 2:
                    two();
                    break;
                case 3:
                    three();
                    break;
                case 4:
                    four();
                    break;
                case 5:
                    five();
                    break;
                case 6:
                    six();
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.print("\n");
        }

        System.out.println();
    }

    // 상하 반전 (swap 방식도 가능)
    private static void one() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[n - 1 - i][j];
            }
        }

        map = temp;
    }

    // 좌우 반전 (swap 방식도 가능)
    private static void two() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = map[i][m - 1 - j];
            }
        }

        map = temp;
    }

    // 오른쪽 회전
    private static void three() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[n - 1 - j][i];
            }
        }

        int tempNum = n;
        n = m;
        m = tempNum;

        map = temp;
    }

    // 왼쪽 회전
    private static void four() {
        int[][] temp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = map[j][m - 1 - i];
            }
        }

        int tempNum = n;
        n = m;
        m = tempNum;

        map = temp;
    }

    private static void five() {
        int[][] temp = new int[n][m];

        // 1애서 2
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                temp[i][j] = map[i][j - (m / 2)];
            }
        }
        // 2애서 3
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                temp[i][j] = map[i - (n / 2)][j];
            }
        }
        // 3애서 4
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = map[i][j + (m / 2)];
            }
        }
        // 4애서 1
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = map[i + (n / 2)][j];
            }
        }

        map = temp;
    }

    private static void six() {
        int[][] temp = new int[n][m];

        // 2에서 1
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = map[i][j + (m / 2)];
            }
        }

        // 3에서 2
        for (int i = 0; i < n / 2; i++) {
            for (int j = m / 2; j < m; j++) {
                temp[i][j] = map[i + (n / 2)][j];
            }
        }

        // 4에서 3
        for (int i = n / 2; i < n; i++) {
            for (int j = m / 2; j < m; j++) {
                temp[i][j] = map[i][j - (m / 2)];
            }
        }

        // 1에서 4
        for (int i = n / 2; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                temp[i][j] = map[i - (n / 2)][j];
            }
        }

        map = temp;
    }
}
