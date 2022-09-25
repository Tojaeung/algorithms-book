package 다이나믹프로그래밍;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 실전3_병사배치하기 {
    public static int n;

    // 배열을 뒤집기 위해 배열이 아니라 ArrayList를 사용하였다.
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static int[] dp = new int[2000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        /*
         * 이 문제는 오름차순으로 열외되는 방법이므로 가장 긴 감소하는 부분수열을 구하는 문제이다.
         * 배열을 뒤집어서 LIS를 구하면 그게 곧 가장 긴 감소하는 부분수열을 구하는 방법이다.
         * */
        Collections.reverse(arr);

        // LIS를 간단한 식으로 구현하기위해 dp테이블을 1로 초기화한다.
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                // i를 기준으로 0~(i-1) 원소중에서 i번째 원소보다 작은 원소값중에서 가장 큰값을 +1해서 dp[i]로 한다.
                if (arr.get(j) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        /*
         * LIS 최대값을 구한다.
         * 이는 곧 열외된후 병사의 수를 구하는 것이다.
         * */
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        // 열외된 병수의 수를 구한다.
        System.out.println(n - maxValue);
    }
}
