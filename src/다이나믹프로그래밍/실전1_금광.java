package 다이나믹프로그래밍;

import java.util.Scanner;

public class 실전1_금광 {
    // t: 테스트 갯수, n: 행의 갯수, m: 열의 갯수
    public static int testCase, n, m;
    public static int[][] dp = new int[20][20];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 테스트 케이스(Test Case) 입력
        testCase = sc.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            // 금광 정보 입력
            n = sc.nextInt();
            m = sc.nextInt();

            // 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dp[i][j] = sc.nextInt();
                }
            }

            /*
             * 발상의전환: 왼쪽에서 오는 최대값과 합해서 dp테이블을 갱신한다.
             * 열의 갯수만 이동할수있기때문에 m을 루프돌리는 for문이 먼저나왔다.
             * 열의 갯수의 두번째부터 연산이 시작되기 떄문에 m의 값이 1부터 시작된다.
             * */
            for (int j = 1; j < m; j++) {
                for (int i = 0; i < n; i++) {
                    int leftUp, leftDown, left;
                    /*
                     * 왼쪽 위에서 오는 경우
                     * 행의 맨위라면 왼쪽위에서 오는값은 없으므로 leftUp을 0으로 초기화한다.
                     * */
                    if (i == 0) leftUp = 0;
                    else leftUp = dp[i - 1][j - 1];

                    /*
                     * 왼쪽 아래에서 오는 경우
                     * 행의 맨아래라면 왼쪽아래에서 오는값이 없으므로 leftDown을 0으로 초기화한다.
                     * */
                    if (i == n - 1) leftDown = 0;
                    else leftDown = dp[i + 1][j - 1];

                    // 왼쪽에서 오는 경우
                    left = dp[i][j - 1];

                    // 왼쪽에서 올수있는 값중에 최대값을 dp테이블에 초기화된값과 더해나간다. (결국 그게 최대값이 된다)
                    dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(leftDown, left));
                }
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                result = Math.max(result, dp[i][m - 1]);
            }
            System.out.println(result);
        }

    }
}
