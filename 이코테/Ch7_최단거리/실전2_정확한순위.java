package 이코테.Ch7_최단거리;

import java.util.Arrays;
import java.util.Scanner;

public class 실전2_정확한순위 {
    public static int INF = (int) 1e9;
    public static int n, m;
    public static int[][] graph = new int[501][501];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < 501; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (a == b) graph[a][b] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <= n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                /*
                 * graph[i][j] != INF 한개만 하면 점수에서 다른점수로 방향이기떄문에 4보다 높은점수만 확인하게 된다.
                 * graph[i][j] != INF || graph[j][i] != INF
                 * 4보다 높은 점수와 4보다 낮은점수를 모두 확인할 수 있다.
                 * */
                if (graph[i][j] != INF || graph[j][i] != INF) cnt++;
            }
            // cnt == n 은 특정 학생의 점수가 다른 모든 점수와 상하관계를 가지고 있는것이다.
            if (cnt == n) result++;
        }
        System.out.println("\n" + result);


        // // 풀이를 쉽게 이해하기위해 그래프를 출력하는 코드이다. 
        // for (int a = 1; a <= n; a++) {
        //     for (int b = 1; b <= n; b++) {
        //         if (graph[a][b] == INF) System.out.print("INF ");
        //         else System.out.print(graph[a][b] + " ");
        //     }
        //     System.out.println();
        // }

    }
}
