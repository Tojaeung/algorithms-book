package 이코테.Ch5_이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 문제1_부품찾기 {

    public static String binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return "no";
        // 시작과 끝의 중간 인덱스 int형이어서 소수점이하는 없어진다.
        int mid = (start + end) / 2;

        if (arr[mid] == target) return "yes";
        else if (arr[mid] > target) return binarySearch(arr, target, start, mid - 1);
        else return binarySearch(arr, target, mid + 1, end);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 부품 몇개? 
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진탐색을 수행하기위해 정렬
        Arrays.sort(arr);

        // 부품 몇개 찾을거야?
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }


        for (int target : targets) {
            /*
             * 이진탐색은 배열의 인덱스를 사용하는것이다.
             * 그러므로, 이진탐색 함수의 end에 n-1은 마지막 인덱스가 몇인지 나타내는것이다..
             * */
            String result = binarySearch(arr, target, 0, n - 1);
            System.out.print(result + " ");
        }

    }
}
