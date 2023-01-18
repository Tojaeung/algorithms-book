package BOJ.구현;

import java.util.Scanner;

// https://www.acmicpc.net/problem/16931
public class 겉넓이구하기_16931번 {
	public static int n, m;
	public static int[][] map = new int[100][100];

	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result += 2; // 정육면체의 상하 넓이를 더해준다.
				for (int k = 0; k < 4; k++) { // 사방탐색
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m) { // 탐색 범위를 벗어날때 그 칸의 정육면체 높이를 더해준다.
						result += map[i][j];
					} else {

						if (map[i][j] > map[nx][ny]) {
							result += map[i][j] - map[nx][ny];
						}
					}

				}
			}
		}

		System.out.println(result);
	}

}
