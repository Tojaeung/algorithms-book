package BOJ.브루트포스;

import java.util.Scanner;

// 조합
public class N과M2_15650번 {

    public static int[] arr;
    public static int n, m;

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
            dfs(i + 1, depth + 1);
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
