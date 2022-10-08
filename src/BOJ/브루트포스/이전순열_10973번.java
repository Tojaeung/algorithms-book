package BOJ.브루트포스;

import java.util.Scanner;

public class 이전순열_10973번 {
    public static int n;
    public static int[] nums;

    public static boolean prevPermutation() {
        int i = nums.length - 1;
        // 다음순열과 부등호가 반대이다.
        while (i > 0 && nums[i - 1] <= nums[i]) i--;
        if (i <= 0) return false;

        int j = nums.length - 1;
        // 다음순열과 부등호가 반대이다.
        while (nums[i - 1] <= nums[j]) j--;
        swap(i - 1, j);

        j = nums.length - 1;
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

        if (prevPermutation()) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else System.out.println(-1);
    }
}
