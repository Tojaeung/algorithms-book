package BOJ.브루트포스;

import java.util.Scanner;

public class 외판원순회2_10971번 {
    public static int n;
    public static boolean[] visit;
    public static int[][] map;

    public static int min = Integer.MAX_VALUE;

    public static void dfs(int start, int now, int sum, int depth) {
        // 모든경로를 탐색한후 마지막으로 시작한 지점으로 돌아오는 비용을 더한다.
        if (depth == n - 1) {
            if (map[now][start] != 0) {
                sum += map[now][start];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            // 길이 없는 경우는 제외된다.
            if (!visit[i] && map[now][i] != 0) {
                visit[i] = true;
                // 마지막에는 자기자신 노드로 돌아와야하므로 start를 계속 인자로 가지고 간다.
                // 경로의 합을 계속 더해주는 변수를 만들지 않고 dfs인자를 사용하였다.
                dfs(start, i, sum + map[now][i], depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        visit = new boolean[n];
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        // start하는 노드를 분기하기위해 for루프 사용
        for (int i = 0; i < n; i++) {
            visit[i] = true;
            dfs(i, i, 0, 0);
            visit[i] = false;
        }

        System.out.println(min);
    }
}
