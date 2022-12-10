package BOJ.탐색;

import java.util.*;

public class 숨박꼭질_1697번 {
	private static Scanner sc = new Scanner(System.in);

	private static int n; // 수빈 위치
	private static int k; // 동생 위치
	private static int[] arr = new int[100001];

	public static void main(String[] args) {
		n = sc.nextInt();
		k = sc.nextInt();

		if (n == k) {
			System.out.println(0);
		} else if (n > k) { // 수빈이 위치가 더 클때
			System.out.println(n - k); // -1밖에 없다.
		} else {
			System.out.println(bfs());
		}

	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);

		while (!q.isEmpty()) {
			int x = q.poll(); // 수빈이의 현재위치
			int nx;

			for (int i = 0; i < 3; i++) { // -1, +1 , *2
				if (i == 0) { // -1
					nx = x - 1;
				} else if (i == 1) { // +1
					nx = x + 1;
				} else { // *2
					nx = x * 2;
				}

				if (nx == k) { // 수빈이의 위치와 동생의 위치가 같을때
					return arr[x] + 1;
				}

				/*
				 * 위치범위를 벗어나면 안된다.
				 * arr[nx] == 0 이어선 안된다. (이미 방문한 배열의 index)
				 */
				if (nx >= 0 && nx <= 100000 && arr[nx] == 0) {
					arr[nx] = arr[x] + 1;
					q.offer(nx);
				}
			}

		}
		return 0;
	}
}
