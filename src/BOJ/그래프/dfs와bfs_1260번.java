package BOJ.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class dfs와bfs_1260번 {
    public static int n, m, start;
    public static boolean[] dfsVisited;
    public static boolean[] bfsVisited;
    public static int[][] graph;

    public static void dfs(int x) {
        dfsVisited[x] = true;
        System.out.print(x + " ");

        for (int i = 1; i < graph[x].length; i++) {
            if (!dfsVisited[i] && graph[x][i] == 1) dfs(i);
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        bfsVisited[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for (int i = 1; i < graph[x].length; i++) {
                if (!bfsVisited[i] && graph[x][i] == 1) {
                    bfsVisited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        graph = new int[n + 1][n + 1];
        dfsVisited = new boolean[n + 1];
        bfsVisited = new boolean[n + 1];


        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            // arraylist가 아니라 2차원 배열을 사용한다.
            // 1. 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문
            // 2. 입력으로 주어지는 간선은 양방향이다.
            // 그 장점으로 문제에서 주어진 위와같은 조건을 쉽게 만족할 수 있다.
            graph[start][end] = graph[end][start] = 1;
        }

        // 아래의 주석은 ArrayList를 사용했을때 코드이다.
        // 복잡하고 심지어 출력초과로 에러가 난다.

        // for (int i = 0; i <= n; i++) {
        //     graph.add(new ArrayList<>());
        // }

        // for (int i = 0; i < m; i++) {
        //     int start = sc.nextInt();
        //     int end = sc.nextInt();
        //     graph.get(start).add(end);
        //     graph.get(end).add(start);
        // }
        //
        // for (int i = 1; i <= n; i++) {
        //     Collections.sort(graph.get(i));
        // }

        dfs(start);
        System.out.println();
        bfs(start);
        System.out.println();
    }
}
