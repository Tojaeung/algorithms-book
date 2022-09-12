package 다이나믹프로그래밍;

public class 개념2_탑다운 {
    public static long[] d = new long[100];

    public static long fibo(int x) {
        if (x == 1 || x == 2) {
            return 1L;
        }

        if (d[x] != 0) {
            return d[x];
        }

        d[x] = fibo(x - 1) + fibo(x - 2);

        return d[x];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibo(30));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);    // 실행시간 168100
    }
}
