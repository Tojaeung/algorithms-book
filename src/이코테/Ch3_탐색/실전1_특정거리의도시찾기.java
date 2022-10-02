package 이코테.Ch3_탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 실전1_특정거리의도시찾기 {

    public static int n, m, k, x;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int[] d = new int[300001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();   // 거리
        x = sc.nextInt();   // 출발

        // 그래프, dp_table 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        // 그래프 노선 초기화
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
        }

        // 출발지점으로의 최단거리는 0
        d[x] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < graph.get(now).size(); i++) {
                int nextNode = graph.get(now).get(i);

                /*
                 * 탐색 알고리즘 공부시, visited 불린으로된 배열을 이용해서 방문 여부를 확인했다.
                 *  그러나 이 문제에서는 최단거리를 기록하는 테이블이 있기때문에
                 * 방문여부를 확인하기 위해 처음에 -1로 초기화를 해준것이다.
                 * */
                if (d[nextNode] == -1) {
                    d[nextNode] = d[now] + 1;
                    q.offer(nextNode);
                }
            }
        }

        boolean check = false;
        /*
         * 0번 노드가 없으므로 1부터 시작
         * 거리가 k인 도시들을 오름차순으로 출력
         * 배열 인덱스를 사용해서 자연스럽게 오름차순 출력이된다.
         * */
        for (int i = 1; i <= n; i++) {
            if (d[i] == k) {
                System.out.println(i);  // 최단거리가 k인것이 몇번 노드인지
                check = true;
            }
        }
        if (!check) System.out.println(-1);
    }
}
