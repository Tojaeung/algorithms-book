package 기타;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private int nodeA;
    private int nodeB;
    private int distance;

    public Edge(int nodeA, int nodeB, int distance) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.distance = distance;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getDistance() {
        return distance;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance > o.distance ? 1 : -1;
    }
}

public class 실전3_어두운길 {
    // n: 집의 갯수, m: 도로의 갯수
    public static int n, m;
    public static int[] parent = new int[200001];
    public static ArrayList<Edge> edges = new ArrayList();

    public static int findParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            edges.add(new Edge(x, y, z));
        }

        Collections.sort(edges, Comparator.naturalOrder());

        int total = 0;  // 최대 도로비용
        int result = 0; // 최소 도로비용

        for (int i = 0; i < m; i++) {
            int nodeA = edges.get(i).getNodeA();
            int nodeB = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            total += cost;

            if (findParent(nodeA) != findParent(nodeB)) {
                unionParent(nodeA, nodeB);
                result += cost;
            }
        }

        System.out.println(total - result);
        
    }
}
