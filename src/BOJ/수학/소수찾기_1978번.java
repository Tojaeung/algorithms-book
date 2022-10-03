package BOJ.수학;

import java.util.Scanner;

public class 소수찾기_1978번 {
    public static boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    public static boolean isPrime2(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0;
        for (int i = 0; i < n; i++) {

            if (isPrime(sc.nextInt())) result++;
        }

        System.out.println(result);

    }
}
