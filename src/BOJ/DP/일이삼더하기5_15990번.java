package BOJ.DP;

import java.util.Scanner;

public class 일이삼더하기5_15990번 {
    // tesst케이스 문제는 미리 map을 다 구해놓고 찾는 방식이 합리적이다. (이 문제와 같이...)
    // 나눠지는 값이 10억대인것을 보면 자료형 int의 용량을 초과할 수 있음을 고려한다.
    public static int testCase, n, mod = 1000000009;

    // 나눠지는 값이 10억대 인것을 고려해 long자료형을 사용하였다.
    public static long[][] dp = new long[100001][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        dp[2][1] = 0;
        dp[2][2] = 1;
        dp[2][3] = 0;

        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        // 1
        // 2 
        // 1 2 , 2 1 , 3
        // 1 3 , 3 1, 1 2 1
        // 2 3 , 3 2 , 2 1 2 , 1 3 1
        for (int i = 4; i <= 100000; i++) {
            // 숫자가 굉장히 크기떄문에 모듈러연산을 사용하였다.
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % mod;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % mod;
        }

        testCase = sc.nextInt();
        for (int i = 0; i < testCase; i++) {
            n = sc.nextInt();
            // 숫자가 굉장히 크기떄문에 모듈러연산을 사용하였다.
            long result = (dp[n][1] + dp[n][2] + dp[n][3]) % mod;
            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}
