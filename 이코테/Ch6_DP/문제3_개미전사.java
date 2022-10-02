package 이코테.Ch6_DP;

import java.util.Scanner;

public class 문제3_개미전사 {

    // 계산된 값 캐싱하기
    public static int[] d = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 일직선으로 나열된 개미집 식량 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 2칸 떨어져도 최대값이면 그게 정답이다. (짝수, 홀수 나누는줄...;;;)
        d[0] = arr[0];
        d[1] = Math.max(d[0], arr[1]);
        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 1], d[i - 2] + arr[i]);
        }

        System.out.println("정답: " + d[n - 1]);

    }
}
