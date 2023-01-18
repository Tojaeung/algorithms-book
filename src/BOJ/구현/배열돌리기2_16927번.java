package BOJ.구현;

import java.util.Scanner;

public class 배열돌리기2_16927번 {
	public static int N, M, r;
	public static int[][] map;

	// 우, 하 , 좌, 상
	public static int[] dx = { 0, 1, 0, -1 };
	public static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		r = sc.nextInt();

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		// 테두리 갯수
		int cnt = Math.min(N, M) / 2;

		// 테두리를 회전을 마칠때마다 n,m이 줄어들기 때문에
		// 가독성을 위헤 N,M의 값을 유지하기위해서 n,m을 선언했다.
		int n = N;
		int m = M;
		for (int i = 0; i < cnt; i++) {
			// 회전수
			rotate(i, (n + m) * 2 - 4);

			// 안쪽 테두리 회전을 위해 가로세로 2를 뺴준다.
			n -= 2;
			m -= 2;
		}

		print();
	}

	public static void rotate(int start, int len) {
		// r을 10억까지 갈수 있기때문에 시간초과 가능성이 있다.
		// 실제 도는 회전 수
		int realRotation = r % len;

		for (int i = 0; i < realRotation; i++) {
			// 방향 인덱스
			// 우, 상, 좌, 하
			int idx = 0;

			// 아래 루프를 돌리면 마지막 자리에 시작값이 없어지기 때문에 시작값을 임시저장해둔다.
			int temp = map[start][start];

			int x = start;
			int y = start;

			while (idx < 4) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];

				if (nx == start && ny == start)
					break;
				if (nx >= start && ny >= start && nx < N - start && ny < M - start) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				} else {
					// 더이상 갈수없는 곳이므로 방향을 바꿔준다.
					// 우, 상, 좌, 하
					idx++;
				}
			}

			// 마지막 빈자리에
			map[start + 1][start] = temp;

		}
	}

	public static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.print("\n");
		}

		System.out.println();
	}
}
