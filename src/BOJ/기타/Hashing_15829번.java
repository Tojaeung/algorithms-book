package BOJ.기타;

import java.util.Scanner;

public class Hashing_15829번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        String str = sc.next();

        int[] arr = new int[l];

        for (int i = 0; i < l; i++) {
            arr[i] = str.charAt(i) - 'a' + 1;
        }

        long result = 0;

        long M = 1234567891;
        long r = 1;

        // 모듈러연산으로 int long 범위를 벗어나는 31제곱을 효율적으로 처리한다.
        // (a + b) mod M = ((a mod M) + (b mod M)) mod M
        // (a - b) mod M = ((a mod M) - (b mod M)) mod M
        // (a * b) mod M = ((a mod M) * (b mod M)) mod M
        for (int i = 0; i < l; i++) {
            result += (arr[i] * r) % M;
            r = (r * 31) % M;
        }

        // for (int i = 0; i < l; i++) {
        // result += arr[i] * Math.pow(31, i);
        // }

        System.out.println(result % M);

    }
}
