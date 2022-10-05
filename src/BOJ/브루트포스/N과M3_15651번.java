package BOJ.브루트포스;

import java.util.Scanner;

// 중복순열
public class N과M3_15651번 {
    public static int n, m;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {
        if (depth == m) {
            for (int val : arr) {
                sb.append(val + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            dfs(depth + 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(0);
        System.out.print(sb);
    }
}
