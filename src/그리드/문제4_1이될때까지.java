package 그리드;

import java.util.Scanner;

public class 문제4_1이될때까지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;

        while (true) {
            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            cnt += (n - target);
            n = target;

            /*
             * n == 1 일때 반복문을 탈출한다면, 간단하지만 치명적인 오류가 있다.
             * 바로 0으로 무한루프를 돌게된다. 그 이유는 target이 0이 되기 떄문이다. (자료형이 int이다.)
             * 그래서 for루프를 n < k까지 돌려주고 나머지는 for루프를 탈출해서 해결해준다.
             */
            if (n < k) {
                break;
            }
            // K로 나누기
            cnt += 1;
            n /= k;
        }

        /*
         * 마지막으로 남은 수에 대하여 1씩 빼기
         * 다 뺴버리면 0이 되기 떄문에...
         */
        cnt += (n - 1);
        System.out.println(cnt);

        /*
         * 나의 풀이로도 풀수있지만... -1를 해주는 과정을 일일이 for루프를 돌면서 처리하기 떄문에
         * 시간 복잡도가 위의 풀이보다 복잡해진다....
         * 
         */
        // while (true) {
        // if (n == 1)
        // break;

        // if (n % k == 0) {
        // n /= k;
        // cnt++;
        // } else {
        // n--;
        // cnt++;
        // }

        // }
    }
}
