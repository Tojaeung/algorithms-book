package 이코테.Ch4_정렬;

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

        /*
         * 기본타입의 정렬은 오름차순만 가능하다 (예를들어서 int)
         * 이 문제는 내림차순 정렬도 필요하므로 int를 Integer 래퍼클래스로 변경하였다.
         * Arrays.sort는 배열을 정렬하고, collections.sort는 컬렉션을 정렬할때 사용된다.
         * */
        Arrays.sort(a);
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
