import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 복습연습장 {

    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(15, 11, 4, 8, 5, 2, 4));
        int dp[] = new int[7];

        Collections.reverse(arr);

        // for (int i = 1; i < 7; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (arr.get(j) < arr.get(i)) {
        //             dp[i] = Math.max(dp[i], dp[j] + 1);
        //         }
        //     }
        // }

        // 다이나믹 프로그래밍을 위한 1차원 DP 테이블 초기화
        for (int i = 0; i < 7; i++) {
            dp[i] = 1;
        }

        // 가장 긴 증가하는 부분 수열(LIS) 알고리즘 수행
        for (int i = 1; i < 7; i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }


        for (int i = 0; i < 7; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++) {
            System.out.print(dp[i] + " ");
        }

        int maxValue = 0;
        for (int i = 0; i < 7; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }

        System.out.println(System.lineSeparator() + (7 - maxValue));
    }


}
