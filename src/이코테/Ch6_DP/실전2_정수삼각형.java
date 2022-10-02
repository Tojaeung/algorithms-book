package 이코테.Ch6_DP;

import java.util.Scanner;

public class 실전2_정수삼각형 {
    public static int n;
    public static int[][] dp = new int[500][500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            // 정수형 삼각형 2중배열을 구현하기 위해 j < i + 1; 처리하였다.
            for (int j = 0; j < i + 1; j++) {
                dp[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int leftUp = 0;
                int rightUp = 0;

                // 각 층의 맨 왼쪽값
                if (j == 0) leftUp = 0;
                else leftUp = dp[i - 1][j - 1];

                // 각 층의 맨 오른쪽값
                if (j == i) rightUp = 0;
                else rightUp = dp[i - 1][j];

                dp[i][j] = dp[i][j] + Math.max(leftUp, rightUp);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[n - 1][i]);
        }

        System.out.println(result);
    }
}
