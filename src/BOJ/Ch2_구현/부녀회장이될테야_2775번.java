package BOJ.Ch2_구현;

import java.util.Scanner;

public class 부녀회장이될테야_2775번 {
    public static int testCase, k, n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        for (int tc = 0; tc < testCase; tc++) {
            k = sc.nextInt();
            n = sc.nextInt();

            int[][] arr = new int[k + 1][n];

            // 맨아래층은 1~14로 초기화
            for (int i = 0; i < n; i++) {
                arr[0][i] = i + 1;
            }

            for (int i = 1; i <= k; i++) {
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    sum += arr[i - 1][j];
                    arr[i][j] = sum;
                }
            }

            System.out.println(arr[k][n - 1]);

        }
    }
}
