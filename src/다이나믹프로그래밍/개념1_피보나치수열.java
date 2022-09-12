package 다이나믹프로그래밍;

public class 개념1_피보나치수열 {

    public static int fibo(int x) {
        if (x == 1 || x == 2) {
            return 1;
        }

        return fibo(x - 1) + fibo(x - 2);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(fibo(30));
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);    // 실행시간 3134600

    }
}
