package BOJ.그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 미로탐색 {
    public static int n, m;
    public static int[][] map = new int[100][100];
    public static boolean[][] visited = new boolean[100][100];

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {-1, 0, 1, 0};

    public static class Position {
        private int x;
        private int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void bfs(int x, int y) {
        // 목표 포지션에 도착하면 종료
        if (x == n - 1 && y == m - 1) return;

        visited[x][y] = true;

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (!q.isEmpty()) {
            Position position = q.poll();
            // 변수 재활용
            x = position.getX();
            y = position.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.offer(new Position(nx, ny));
                visited[nx][ny] = true;
                // 전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                map[nx][ny] = map[x][y] + 1;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // (0, 0) 에서 (n-1, m-1)
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);
    }
}
