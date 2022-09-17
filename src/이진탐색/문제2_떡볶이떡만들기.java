package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 문제2_떡볶이떡만들기 {

    // 떡을 자르고 모두 더한 값
    public static int total(int[] arr, int mid) {
        int result = 0;
        for (int i : arr) {
            // int re = (i - mid);
            // if (re < 0) re = 0;
            // result += re;

            // 위의 주석을 간단히.....
            if (i > mid) result += (i - mid);
        }
        return result;
    }

    public static int binarySearch(int[] arr, int m, int start, int end) {
        int mid = (start + end) / 2;

        /*
         * 잘라진 떡을 모두 더한 값
         * 떡이 잘라진대도 떡의 길이가 몇십억 이기때문에.... int 타입이 아니라 long타입을 써준다.
         * */
        long total = total(arr, mid);

        if (total == m) return mid;
        else if (total > m) {
            // 앞에 짜름
            return binarySearch(arr, m, mid + 1, end);
        } else {
            // 뒤에 짜름
            return binarySearch(arr, m, start, mid - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 떡의개수 (백만)
        int m = sc.nextInt();   // 원하는 떡의 길이 (20억)

        // 각 떡의 길이정보
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        // 떡중에 최대길이 떡
        int maxLength = arr[arr.length - 1];

        // 최대높이
        int height = binarySearch(arr, m, 0, maxLength);

        System.out.println(height);
    }
}
