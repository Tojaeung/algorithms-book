package 다이나믹프로그래밍;

import java.util.Arrays;
import java.util.Scanner;

public class 문제4_효율적인화폐구성 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 화폐갯수
        int m = sc.nextInt();   // 목표금액

        // 화폐단위 저장
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        /*
         * 인덱스는 목표금액
         * 값은 필요한 최소한의 화폐갯수
         * */
        int[] d = new int[m + 1];
        // 10001은 특정화폐를 만듦이 가능하지 않다.
        Arrays.fill(d, 10001);

        // 0은 화폐를 하나도 사용하지 않아야 만들수 있다.
        d[0] = 0;

        // 화폐단위 하나씩 dp테이블을 갱신시켜주고 있다.
        // arr[i]는 화폐단위를 말한다.
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {

                /*
                 * 현재 화폐에서 해당 화폐단위 이전의 상황일때 못만드는 화폐이면...
                 * 화폐단위를 더해도 못만든다...
                 * */
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
