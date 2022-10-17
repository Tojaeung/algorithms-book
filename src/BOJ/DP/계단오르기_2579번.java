package BOJ.DP;

import java.util.Scanner;

public class 계단오르기_2579번 {
    public static int n;
    public static int[] arr = new int[301];
    public static int[] dp = new int[301];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }


        // 마지막 계단은 반드시 밝는다.
        dp[1] = arr[1]; // 첫계단을 오를때 최대값
        dp[2] = arr[1] + arr[2];    // 두번째 계단을 오를때 최대값은 분명히 첫번째와 두번째 계단을 더하는것이다.
        for (int i = 3; i <= n; i++) {
            // OXO
            // XOO -> 연속으로 3계단을 밟을수 없기 때문에 조건을 추가한다.
            // OXOO 
            // OX -> 반드시 마지막 계단을 밟아야하므로 이 조건은 제외된다.
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]);
        }

        System.out.println(dp[n]);
    }
}
