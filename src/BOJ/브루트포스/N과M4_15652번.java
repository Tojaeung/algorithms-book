package BOJ.브루트포스;

import java.util.Scanner;

// 중복조합
public class N과M4_15652번 {
    public static int n, m;
    public static int[] arr;

    public static void dfs(int start, int depth) {
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            arr[depth] = i;
            dfs(i, depth + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(1, 0);
    }
}
