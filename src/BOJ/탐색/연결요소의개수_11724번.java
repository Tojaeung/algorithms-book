package BOJ.탐색;

import java.util.Scanner;

public class 연결요소의개수_11724번 {
    public static int n, m;
    public static boolean[] visited;
    public static int[][] graph;

    public static void dfs(int x) {
        visited[x] = true;

        for (int i = 1; i < graph[x].length; i++) {
            if (!visited[i] && graph[x][i] == 1)
                dfs(i);
        }
    }

    /*
     * 방문하지 않은 노드를 확인한다.
     * 
     * @return: 방문하지 않는 노드의 인덱스
     */
    // public static int checkVisited() {
    // int index = -1;
    // for (int i = 1; i < n + 1; i++) {
    // if (!visited[i]) {
    // index = i;
    // break;
    // }
    // }
    // return index;
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n + 1];
        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            // 간선을 양방향 설정해서 풀이를 쉽게 가져갔다.
            // 3 -> 4 -> 6 일때 dfs(4)라면 4,6만 연결되고 3은 연결되지 않는다.
            // 그러나,, 3 <-> 4 <-> 6 양방향으로 설정된다면 dfs로 모든 노드를 연결할 수 있다.
            graph[u][v] = graph[v][u] = 1;
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(i);
                cnt++;
            }
        }

        // 간선을 양방향 설정하지 않은 풀이
        // 심지어 (3 -> 4 -> 6 일때 dfs(4)라면 4,6만 연결되고 3은 연결되지 않는다.) 때문에 ...
        // 오답이다...

        // // 위에서 dfs를 한번 돌았기 때문에 1
        // int cnt = 1;
        // while (checkVisited() != -1) {
        // // 방문안한 노드의 인덱스 반환
        // int index = checkVisited();
        // dfs(index);
        // cnt++;
        // }
        System.out.println(cnt);
    }
}
