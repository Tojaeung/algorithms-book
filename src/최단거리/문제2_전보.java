
package 최단거리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node4 implements Comparable<Node4> {

    private int index;
    private int distance;

    public Node4(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int compareTo(Node4 o) {
        if (this.distance < o.distance) {
            return -1;
        }
        return 1;
    }
}

public class 문제2_전보 {

    public static int INF = (int) 1e9;
    public static ArrayList<ArrayList<Node4>> graph = new ArrayList<>();

    // n 도시개수 , m 간선개수, start 시작도시
    public static int n, m, start;
    public static int[] d = new int[30001];

    public static void 다익스트라(int start) {
        PriorityQueue<Node4> pq = new PriorityQueue<>();

        pq.offer(new Node4(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node4 node = pq.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist) continue;
            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node4(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 주의!!!!!!! 인덱스 0포함 n까지 이다.(인덱스0은 노드 번호 맞추기 용)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new Node4(y, z));
        }

        Arrays.fill(d, INF);

        다익스트라(start);

        int count = 0;
        int maxDistance = 0;
        for (int i = 0; i <= n; i++) {
            if (d[i] != INF) {
                count++;
                maxDistance = Math.max(maxDistance, d[i]);
            }
        }

        // 처음 시작노드 count1을 뺴준다.
        System.out.println(count - 1 + " " + maxDistance);


    }
}
