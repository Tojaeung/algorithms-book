package 그래프이론;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Node implements Comparable<Node> {

    private int nodeA;
    private int cost;
    private int nodeB;

    public Node(int nodeA, int cost, int nodeB) {
        this.nodeA = nodeA;
        this.cost = cost;
        this.nodeB = nodeB;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getCost() {
        return cost;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Node o) {
        if (this.cost > o.cost) {
            return 1;
        }
        return -1;
    }
}

public class 개념3_크루스칼 {
    // n 노드개수(최대100개), m 간선개수
    public static int n, m;
    // 부모테이블  
    public static int[] parent = new int[101];
    // 간선정보를 담은 리스트
    public static ArrayList<Node> edges = new ArrayList<>();
    // 최종비용
    public static int result = 0;

    // 루트 노드를 찾는 함수
    public static int findRoot(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findRoot(parent[x]);
    }

    public static void unionRoot(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모 테이블 자기자신을 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 간선정보 리스트에 삽입
        for (int i = 0; i < m; i++) {
            int nodeA = sc.nextInt();
            int cost = sc.nextInt();
            int nodeB = sc.nextInt();

            edges.add(new Node(nodeA, cost, nodeB));
        }

        // 간선정보 오름차순 정렬
        edges.sort(Comparator.naturalOrder());
        /*
         * Collections.sort(edges, Comparator.naturalOrder());
         * 위의 정렬과 같은 결과를 도출한다.
         * */

        for (int i = 0; i < edges.size(); i++) {
            int rootA = findRoot(edges.get(i).getNodeA());
            int cost = edges.get(i).getCost();
            int rootB = findRoot(edges.get(i).getNodeB());

            if (rootA != rootB) {
                unionRoot(rootA, rootB);
                result += cost;
            }
        }

        System.out.println(result);
    }
}
