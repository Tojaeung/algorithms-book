package 이진탐색;

import java.util.Scanner;

public class 실전1_정렬된배열에서특정수의개수구하기 {
    // 이진탐색을 사용해서 찾을려는 수의 왼쪽 끝 인덱스를 반환한다.
    public static int lowerBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    // 이진탐색을 사용해서 찾을려는 수의 오른쪽 끝 인덱스를 반환한다.
    public static int upperBound(int[] arr, int target, int start, int end) {
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    public static int countByRange(int[] arr, int leftValue, int rightValue) {
        int leftIndex = lowerBound(arr, rightValue, 0, arr.length - 1);
        int rightIndex = upperBound(arr, leftValue, 0, arr.length - 1);
        //     ㅇ      ㅇ  -------> 인덱스 반환
        // 1 1 2 2 2 2 3
        // 6(rightIndex) -2(leftIndex)
        return rightIndex - leftIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int cnt = countByRange(arr, x, x);

        if (cnt == 0) System.out.println(-1);
        else System.out.println(cnt);

    }
}
