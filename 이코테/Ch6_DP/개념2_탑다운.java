package 이코테.Ch6_DP;

public class 개념2_탑다운 {
    public static long[] d = new long[100];

    // 탑다운 방식은 재귀함수를 이용한다.
    // 큰 피보나치 수열을 계산해야할때 스택초과로 오류 발생할 수도 있다.
    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1L;
        }

        /*
         * 이미 dp테이블에 있다면 그것을 그냥 사용한다.
         * 그래서 d[x] = fibo(x - 1) + fibo(x - 2);를 또 사용하지 않게한다. (일 커짐 방지)
         * */
        if (d[x] != 0) {
            return d[x];
        }

        // 피보나치 수열을 dp테이블에 저장한다.
        d[x] = fibo(x - 1) + fibo(x - 2);

        // 재귀함수를 사용하여 스택으로 처리되기 때문에 낮은 x부터 처리되는걸 확인할 수 있다.
        System.out.println(d[x]);

        return d[x];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibo(5));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);    // 실행시간 168100
    }
}
