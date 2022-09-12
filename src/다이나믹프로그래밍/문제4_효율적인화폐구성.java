package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 문제4_효율적인화폐구성 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 화폐갯수
        int m = sc.nextInt();   // 목표금액

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                if (d[j - arr[i]] != 10001) {

                    // 기존의 d[j]
                    // 화폐단위 arr[i]를 빼면 최근의 최적해가 나온다. 거기서 1을 더하면 d[j]가 된다.
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        if (d[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }

    }
}
