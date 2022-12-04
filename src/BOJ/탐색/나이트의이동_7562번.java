package BOJ.탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 나이트의이동_7562번 {
    public static int testCase, n;
    public static int[][] map;
    public static boolean[][] visited;

    public static int[] dx = {-2, -1, 2, 1, 2, 1, -2, -1};
    public static int[] dy = {1, 2, 1, 2, -1, -2, -1, -2};

    public static int startX, startY, endX, endY;

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
        if (x == endX && y == endY)
            return;

        visited[x][y] = true;

        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));

        while (!q.isEmpty()) {
            Position position = q.poll();
            // 변수 재활용
            x = position.getX();
            y = position.getY();

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny])
                    continue;

                q.add(new Position(nx, ny));
                visited[nx][ny] = true;
                // 전의 이동 횟수에 +1 씩 더해주며 이동 횟수를 증가시켜준다.
                map[nx][ny] = map[x][y] + 1;


            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        testCase = sc.nextInt();
        while (testCase-- > 0) {
            n = sc.nextInt();
            map = new int[n][n];
            visited = new boolean[n][n];

            startX = sc.nextInt();
            startY = sc.nextInt();
            endX = sc.nextInt();
            endY = sc.nextInt();

            bfs(startX, startY);
            System.out.println(map[endX][endY]);
        }

    }
}
