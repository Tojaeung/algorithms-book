package 이코테.Ch1_그리드;

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

        /*
         * 나는 배열에 최솟값을 저장했다가 정렬 후 최대값을 반환하는 방법으로 풀이
         * 카드맵을 만들고 마지막에 정렬을 하므로 시간복잡도가 O((N * M) + logN)로 생각한다.
         * 그러나, 답안풀이는 for루프를 돌면서 할당하는 방법으로 심플하고 아름답게 구현하였다.
         * 시간복잡도가 O(N * M)이다.
         * 답안풀이가 더 효율적이다.
         */
        // Scanner sc = new Scanner(System.in);
        //
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // int[] arr = new int[n];
        // int result = 0;
        //
        // for (int i = 0; i < n; i++) {
        // int minValue = 10001;
        // for (int j = 0; j < m; j++) {
        // int num = sc.nextInt();
        // minValue = Math.min(num, minValue);
        // arr[i] = minValue;
        // }
        // }
        //
        // Arrays.sort(arr);
        // System.out.println(arr[arr.length - 1]);
    }
}
