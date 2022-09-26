package 최단거리;

import java.util.Arrays;
import java.util.Scanner;

public class 실전1_플로이드 {
    // 비용 최댓값
    public static int maxCost = 100001;
    // n: 도시번호, m : 버스 간선
    public static int n, m;
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        /*
         * 모든 그래프 최대비용으로 초기화
         * i < n 으로 하면 안된다.
         * 도시의 좌표는 1부터 n까지 이기 때문에
         * 0부터 n-1를 초기화 시키면 싱크가 안맞게 된다.
         * */
        for (int i = 0; i < 101; i++) {
            Arrays.fill(graph[i], maxCost);
        }

        // 자기 자신으로 가는건 0으로
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= m; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        // 인풋값 그래프에 초기화 시키기
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();   // a 도시
            int b = sc.nextInt();   // b 도시
            int c = sc.nextInt();   // 비용

            /*
             * 인력값중에 각 도시사이에 곁치는 간선정보가 있을수도있다.
             * 그런 경우에 대비해서 특정 도시사이의 간선정보 중,, 가장 짧은 간선정보로 초기화 시킨다.
             * */
            if (c < graph[a][b]) graph[a][b] = c;
        }

        // 각 도시에서 도시로의 최단거리 구하기
        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][b] == maxCost) System.out.print(0 + " ");
                else System.out.print(graph[a][b] + " ");
            }
            System.out.println();
        }

    }
}
