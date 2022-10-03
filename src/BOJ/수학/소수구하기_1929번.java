package BOJ.수학;

import java.util.Scanner;

public class 소수구하기_1929번 {
    // m이상, n이하
    public static int n, m;
    public static boolean[] prime;

    public static boolean[] es() {
        // 0,1은 소수 아님
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < n + 1; j += i) {
                prime[j] = true;
            }
        }

        return prime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();   // 이상
        n = sc.nextInt();   // 이하
        prime = new boolean[n + 1]; // 소수 표시 배열

        boolean[] primes = es();
        for (int i = m; i < primes.length; i++) {
            if (!primes[i]) {
                System.out.println(i);
            }
        }

    }
}
