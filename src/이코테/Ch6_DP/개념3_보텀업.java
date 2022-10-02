package 이코테.Ch6_DP;

public class 개념3_보텀업 {

    public static long[] d = new long[100];

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // 첫 번째 피보나치 수와 두 번째 피보나치 수는 1
        d[1] = 1;
        d[2] = 1;
        int n = 30; // 30번째 피보나치 수를 계산

        /*
         * 피보나치 함수(Fibonacci Function) 반복문으로 구현(보텀업 다이나믹 프로그래밍)
         * 일반적으로 dp는 보텀업방식을 사용한다. (스택 오버 초과문제, 간결한 코드)
         * */
        for (int i = 3; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        System.out.println(d[n]);

        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);    // 실행시간 123500
    }
}
