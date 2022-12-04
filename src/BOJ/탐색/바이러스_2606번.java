package BOJ.탐색;

import java.util.*;

public class 바이러스_2606번 {
	public static int n, m; // 노드수, 간선수
	public static int[][] graph;
	public static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= m; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start][end] = graph[end][start] = 1;
		}

		bfs(1);
		int result = 0;
		for (boolean visitedComputer : visited) {
			if (visitedComputer)
				result += 1;
		}

		// 1번 컴퓨터를 제외한 바이러스 걸린 컴퓨터 수
		System.out.println(result - 1);

	}


	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		visited[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int x = q.poll();

			for (int i = 1; i < graph[x].length; i++) {
				if (!visited[i] && graph[x][i] == 1) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}

	}


}
