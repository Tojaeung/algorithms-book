package 이진탐색;

import java.util.Arrays;
import java.util.Scanner;

public class 문제1_부품찾기 {

    public static String binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) return "no";
        int mid = (start + end) / 2;

        if (arr[mid] == target) return "yes";
        else if (mid > target) return binarySearch(arr, target, 0, mid - 1);
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
            String result = binarySearch(arr, target, 0, n - 1);
            System.out.print(result + " ");
        }

    }
}
