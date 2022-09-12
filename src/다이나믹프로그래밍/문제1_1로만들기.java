package 다이나믹프로그래밍;

import java.util.Scanner;

public class 문제1_1로만들기 {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
    public static int[] d = new int[30001];

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {

            // 전에 배열요소에서 1을 더하면 된다.  
            d[i] = d[i - 1] + 1;

            // 최근 2로 나누어떨어지는거에서 1을 더하면됨 
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 최근 3로 나누어떨어지는거에서 1을 더하면됨 
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 최근 5로 나누어떨어지는거에서 1을 더하면됨
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }
        for (int i : d) {
            System.out.println(i);
        }
        System.out.println(d[x]);

    }
}
