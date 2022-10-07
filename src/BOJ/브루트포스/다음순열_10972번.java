package BOJ.브루트포스;

import java.util.Scanner;

public class 다음순열_10972번 {
    public static int n;
    public static int[] nums;

    public static boolean nextPermutation() {
        int i = nums.length - 1;    // 배열길이
        while (i > 0 && nums[i - 1] >= nums[i]) i--;
        // 순열의 맨마지막 7 6 5 4 3 2 1 이런경우 밖에 없다.
        if (i <= 0) return false;

        int j = nums.length - 1;
        while (nums[i - 1] >= nums[j]) j--;
        swap(i - 1, j);

        // j 재활용
        j = nums.length - 1;
        // 1 2 3 4 5 6 -> 6 5 4 3 2 1  swap메서드를 이용한 배열뒤집기 구현
        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        if (nextPermutation()) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else System.out.println(-1);
    }
}
