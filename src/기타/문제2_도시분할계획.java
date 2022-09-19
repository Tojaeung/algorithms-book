package 기타;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Node2 implements Comparable<Node2> {

    private int nodeA;
    private int cost;
    private int nodeB;

    public Node2(int nodeA, int cost, int nodeB) {
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
    public int compareTo(Node2 o) {
        if (this.cost < o.cost) return -1;
        else return 1;
    }
}

public class 문제2_도시분할계획 {

    // n 노드개수 (2~ 100000) , m 간선개수 (1 ~ 1000000)
    public static int n, m;
    // 부모테이블
    public static int[] parent = new int[100001];
    // 간선정보를 담을 이중배열
    public static ArrayList<Node2> edges = new ArrayList<>();
    // 최종비용
    public static int result = 0;

    public static int findRoot(int x) {
        if (x == parent[x]) return x;

        // 경로 단축법
        return parent[x] = findRoot(parent[x]);
    }

    public static void unionNode(int a, int b) {
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

        // 부모테이블 자기자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 간선정보 정리
        for (int i = 0; i < m; i++) {
            int nodeA = sc.nextInt();   // A노드
            int cost = sc.nextInt();   // 비용
            int nodeB = sc.nextInt();   // B노드

            edges.add(new Node2(nodeA, cost, nodeB));
        }

        edges.sort(Comparator.naturalOrder());

        // edges가 오름차순 정렬이므로 for를 돌아 자연스럽게 최대 비용이 할당된다. 
        int maxCost = 0;

        /*
         * 신장트리에서 가장 큰 비용을 제거하면...
         * 최소한의 비용으로 도시를 둘로 나눌수 있다.
         * */
        for (int i = 0; i < edges.size(); i++) {
            int rootA = findRoot(edges.get(i).getNodeA());
            int cost = edges.get(i).getCost();
            int rootB = findRoot(edges.get(i).getNodeB());

            if (rootA != rootB) {
                unionNode(rootA, rootB);
                result += cost;
                maxCost = cost;
            }
        }

        System.out.println(result - maxCost);

    }
}
