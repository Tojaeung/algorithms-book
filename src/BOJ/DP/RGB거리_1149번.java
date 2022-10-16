package BOJ.DP;

import java.util.Scanner;

public class RGB거리_1149번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] dp = new int[1001][3];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + dp[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + dp[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + dp[i][2];
        }

        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}

// 첫번째에서 제일 작은값을 선택하는게 베스트라고 착각
// public class Main {
//     public static int n;
//     public static int[][] map = new int[1001][3];
//     public static int[] dp = new int[1001];
//
//     // 자바 배열내 최소값 구하기
//     public static int minFunc() {
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < 3; i++) {
//             min = Math.min(min, map[1][i]);
//         }
//
//         return min;
//     }
//
//     // 최소값의 인덱스
//     public static int idxFunc(int row, int min) {
//         int idx = -1;
//         for (int i = 0; i < 3; i++) {
//             if (map[row][i] == min) {
//                 idx = i;
//                 break;
//             }
//         }
//         return idx;
//     }
//
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//
//         n = sc.nextInt();
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j < 3; j++) {
//                 map[i][j] = sc.nextInt();
//             }
//         }
//
//         for (int i = 1; i <= n; i++) {
//             dp[i] = Integer.MAX_VALUE;
//         }
//
//         // 처음 최소값, 인덱스
//         int min = minFunc();
//         dp[1] = min;
//
//         int idx = idxFunc(1, min);
//         for (int i = 2; i <= n; i++) {
//             for (int j = 0; j < 3; j++) {
//                 if (j == idx) continue;
//                 dp[i] = Math.min(dp[i], map[i][j]);
//             }
//             idx = idxFunc(i, dp[i]);
//         }
//
//         int result = 0;
//         for (int i = 1; i <= n; i++) {
//             result += dp[i];
//         }
//         System.out.println(result);
//
//     }
// }
