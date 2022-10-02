package 이코테.Ch7_최단거리;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node implements Comparable<Node> {
    private int x;
    private int y;
    private int distance;

    public Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node o) {
        // 우선순위 큐에서 Node객체가 distance가 짧은순으로 우선순위를 가지도록 한다.
        if (this.distance < o.distance) return -1;
        return 1;
    }
}


public class 실전3_화성탐사 {
    public static int INF = (int) 1e9;
    public static int[][] graph = new int[3][3];
    public static int[][] dp = new int[3][3];
    public static int testCase, n;
    public static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();

        for (int tc = 0; tc < testCase; tc++) {
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], INF);
            }

            int x = 0;  // 시작위치
            int y = 0;  // 시작위치
            PriorityQueue<Node> pq = new PriorityQueue<>();

            // 시작위치로 가는데 거리 = graph[x][y]
            pq.offer(new Node(0, 0, graph[x][y]));
            dp[x][y] = graph[x][y];

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                x = node.getX();
                y = node.getY();
                int distance = node.getDistance();

                if (dp[x][y] < distance) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                    /*
                     * 각 좌표에서 상하좌우를 모두 확인하기 때문에
                     * 결국, dp테이블의 모든 위치는 시작위치(0,0)으로 부터의 최소거리로 갱신이 된다.
                     * */
                    int cost = distance + graph[nx][ny];
                    if (cost < dp[nx][ny]) {
                        dp[nx][ny] = cost;
                        pq.offer(new Node(nx, ny, cost));
                    }
                }
            }

            // dp테이블을 확인해보면 모든 좌표가 최소값으로 갱신되어있다.
            // System.out.println(Arrays.deepToString(dp));

            // dp테이블이 시작위치(0,0)으로부터의 최소거리로 갱신되어 있기때문에 dp[n - 1][n - 1]로 확인할 수 있다. 
            System.out.println("\n" + dp[n - 1][n - 1]);
        }
    }
}
