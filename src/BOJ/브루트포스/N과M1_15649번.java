package BOJ.브루트포스;

import java.util.Scanner;

// 순열
public class N과M1_15649번 {
    public static int n, m;
    public static int[] arr;
    public static boolean[] visit;

    private static void dfs(int depth) {
        // 순열이 담기는 배열 arr에 다 채워지면 반환
        if (depth == m) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = i + 1; // for문이 0부터 시작하기 떄문에 i + 1 
                dfs(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // nPm 순열구하기
        m = sc.nextInt();   // nPm 순열구하기

        arr = new int[m];   // 순열이 담기는 배열
        visit = new boolean[n]; // arr에 순열을 구성할때 방문했는지 여부 확인

        // 순열 재귀방법으로 탐색한다.
        dfs(0);
    }
}
