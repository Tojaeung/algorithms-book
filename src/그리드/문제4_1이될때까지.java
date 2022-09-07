package 그리드;

import java.util.Scanner;

public class 문제4_1이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        /*
         * 나의 답안
         * */

        int cnt = 0;

        long startTime = System.nanoTime();

        while (true) {
            if (n == 1) break;

            if (n % k == 0) {
                n /= k;
                cnt++;
            } else {
                n--;
                cnt++;
            }

        }
        long endTime = System.nanoTime();

        System.out.println(cnt);
        System.out.println("수행시간: " + (endTime - startTime));


        /*
         * 문제집 답안
         * 문제집 답안은 나머지를 cnt에 미리 더해서 루프를 감소시켰다.
         * 그래서 나의 답안보다 문제집답안이 빠르고 효율적이라고 할 수 있겠다. (별루 차이는 안나는뎅;;;)
         * */

        // int result = 0;
        //
        // long startTime = System.nanoTime();
        // while (true) {
        //     // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
        //     int target = (n / k) * k;
        //     result += (n - target);
        //     n = target;
        //     // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
        //     if (n < k) break;
        //     // K로 나누기
        //     result += 1;
        //     n /= k;
        // }
        //
        // long endTime = System.nanoTime();
        //
        // // 마지막으로 남은 수에 대하여 1씩 빼기
        // result += (n - 1);
        // System.out.println(result);
        // System.out.println("수행시간: " + (endTime - startTime));


    }
}
