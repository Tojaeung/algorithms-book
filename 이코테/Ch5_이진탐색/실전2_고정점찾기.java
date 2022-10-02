package 이코테.Ch5_이진탐색;

import java.util.Scanner;

public class 실전2_고정점찾기 {
    public static int n;

    public static int binarySearch(int[] arr, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 이 문제에서는 target이 mid가 된다. 
            // 그런데 mid는 계속 바뀌는데...ㄷㄷ 어떻게 정답이 도출되는걸까
            if (arr[mid] == mid) return mid;
            else if (arr[mid] > mid) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, 0, n - 1);
        System.out.println(result);
    }

}
