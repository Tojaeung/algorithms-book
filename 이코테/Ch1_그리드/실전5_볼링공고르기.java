package 이코테.Ch1_그리드;

import java.util.Scanner;

public class 실전5_볼링공고르기 {
    public static int n, m;
    public static int[] arr = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            arr[sc.nextInt()] += 1;
        }

        int result = 0;
        for (int i = 1; i <= m; i++) {
            n -= arr[i];
            result += arr[i] * n;
        }

        System.out.println(result);
    }
}
