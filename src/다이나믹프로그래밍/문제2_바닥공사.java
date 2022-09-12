package 다이나믹프로그래밍;

import java.util.Scanner;

public class 문제2_바닥공사 {

    public static int[] d = new int[1001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        d[1] = 1;
        d[2] = 3;
        for (int i = 3; i <= n; i++) {

            // 점화식 도출 어렵고 이해안되 ㅠㅠ
            d[i] = d[i - 1] + (2 * d[i - 2]) % 796796;
        }
        System.out.println(d[n]);
    }
}
