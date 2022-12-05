package BOJ.탐색;

import java.util.*;

// https://www.acmicpc.net/problem/1012
public class 유기농배추_1012번 {
	public static int n, m, k, testCase;
	public static int[][] graph;

	// 좌우하상
	public static int[] dx = { 0, 0, 1, -1 };
	public static int[] dy = { -1, 1, 0, 0 };

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		testCase = sc.nextInt();

		while (testCase-- > 0) {
			n = sc.nextInt();
			m = sc.nextInt();
			k = sc.nextInt();

			// 그래프 초기화
			graph = new int[n][m];
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				graph[x][y] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (graph[i][j] != 1)
						continue;
					else {
						bfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		}

	}

	public static void bfs(int x, int y) {
		Queue<Position> q = new LinkedList<>();
		q.offer(new Position(x, y));
		graph[x][y] = 0; // 방문했다는 의미

		while (!q.isEmpty()) {
			Position position = q.poll();

			for (int idx = 0; idx < 4; idx++) {
				int nx = dx[idx] + position.getX();
				int ny = dy[idx] + position.getY();

				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;

				if (graph[nx][ny] == 0)
					continue;

				graph[nx][ny] = 0; // 방문했다는 의미
				q.offer(new Position(nx, ny));

			}
		}

	}

}
