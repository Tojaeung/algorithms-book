package 이코테.Ch7_최단거리;

import java.util.Arrays;
import java.util.Scanner;

public class 문제1_미래도시 {

    public static int INF = (int) 1e9;

    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 노드
        int m = sc.nextInt();   // 간선

        /*
         * 이중배열 채우기
         * Arrays.fill(graph, INF); 그냥 이렇게 하면 이중배열 채우기 안된다.
         * */
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기에서 자기로 이동하는 경우 거리0
        for (int i = 1; i <= n; i++) {
            graph[i][i] = 0;
        }

        // 노드마다 1의 거리이므로 1로 초기화
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 양방향으로 간선이 연결된다.
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // 모든지점에서 모든지점으로의 최단거리를 계산한다.
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int k = sc.nextInt();   // 먼저 들러야할곳
        int x = sc.nextInt();   // 그 다음 들러야할곳

        int totalDistance = graph[1][k] + graph[k][x];
        if (totalDistance >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(totalDistance);
        }

    }
}
