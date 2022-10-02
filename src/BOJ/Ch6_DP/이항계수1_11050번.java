package BOJ.Ch6_DP;

import java.util.Scanner;

public class 이항계수1_11050번 {

    public static int n, r;
    public static int[][] dp = new int[11][11];

    public static int factorial(int x) {
        if (x == 1) {
            return 1;
        }

        return x * factorial(x - 1);
    }

    // 탑다운 방식 이항꼐수 메서드
    public static int bc(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];

        if (r == 0 || n == r) return dp[n][r] = 1;

        return dp[n][r] = bc(n - 1, r - 1) + bc(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();

        // ( a + b )^n일때 a^(n-r) * b^r의 계수를 구하여라
        // a^(n-r) * b^r의 계수는 nCr이다.

        // 방법1: n! / r!(n-r)!
        // System.out.println(factorial(n) / (factorial(r) * factorial(n - r)));

        // 방법2: 파스칼의 삼각형 nCr = (n-1)C(r-1) + (n-1)Cr
        // 보텀업 방식 풀이
        // for (int i = 0; i <= n; i++) {
        //     dp[i][i] = 1;
        //     dp[i][0] = 1;
        //     dp[i][1] = i;
        // }
        //
        // for (int i = 2; i <= n; i++) {
        //     for (int j = 1; j < i; j++) {
        //         dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        //     }
        // }
        // System.out.println(dp[n][r]);


        // 톱다운 방식 풀이
        System.out.println(bc(n, r));
    }


}
