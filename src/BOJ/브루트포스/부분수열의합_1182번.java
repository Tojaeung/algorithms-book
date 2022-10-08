package BOJ.브루트포스;

import java.util.Scanner;

public class 부분수열의합_1182번 {
    public static int n, s, cnt = 0;
    public static int[] arr;

    public static void subSeq(int[] arr, int n) {
        for (int i = 0; i < (1 << n); i++) {
            // 수열조합의 합
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    sum += arr[j];
                }
            }
            if (sum == s) cnt++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 부분수열 구하는 메서드
        subSeq(arr, n);

        // s가 0일떄는 결과값에 1을 뺴준다.
        // 공집합일 경우 모든 원소의 합이 0이기 때문이다.
        if (s == 0) System.out.println(cnt - 1);
        else System.out.println(cnt);
    }
}
