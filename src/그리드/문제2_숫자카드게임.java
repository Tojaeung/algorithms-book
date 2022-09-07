package 그리드;

import java.util.Scanner;

public class 문제2_숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 카드 행, 열 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {

            // 최댓값이 10000이므로... 10001으로 초기화
            int min_value = 10001;

            for (int j = 0; j < m; j++) {

                // 카드 행 입력 받기
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }

            result = Math.max(result, min_value);

        }

        System.out.println(result);

    }
}
