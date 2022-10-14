package BOJ.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class 가장긴증가하는부분수열_11722번 {
    public static int n;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // dp배열 1로 초기화
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
