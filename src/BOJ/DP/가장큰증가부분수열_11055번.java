package BOJ.DP;

import java.util.Scanner;

public class 가장큰증가부분수열_11055번 {
    public static int n;
    public static int[] arr = new int[1001];
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = arr[0]; // 이전에 더해주는 값이 없으므로 dp배열에 할당
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i]; // 점화식에서 dp배열 계산시 0이기때문에 arr배열값을 삽입해주면서 계산한다.
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {

                    // dp배열: 1, 101, 3, 53
                    // 어떻게 101을 건너띄고 dp[3]의 값 53을 계산할 수 있을까?? 의 물음에 대한 코드
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
