package 정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 문제3_두배열의원소교체 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();


        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        // 기본 오름차순정렬
        Arrays.sort(a);
        // 내림차순 정렬
        Arrays.sort(b, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]) {

                // 두 배열 요소를 바꿔주기 위해 temp에 임시저장한다.
                int temp = a[i];
                a[i] = b[i];
                b[i] = temp;
            } else break;
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i];
        }

        System.out.println(result);

    }
}
