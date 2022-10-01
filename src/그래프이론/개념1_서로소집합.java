package 그래프이론;

import java.util.Scanner;

public class 개념1_서로소집합 {

    // n은 노드 개수 , m은 간선개수
    public static int n, m;
    // 부모 테이블 초기화, 최대 노드수 100개로 가정
    public static int[] parent = new int[101];

    // 부모노드를 찾기위해 재귀적으로 호출한다.
    public static int findParant(int x) {
        if (x == parent[x]) return x;

        // 경로 단축으로 루트 노드를 탐색하지 않기 때문에 성능이 개선된다.
        return parent[x] = findParant(parent[x]);

        // 경로 단축을 하지 않고 재귀함수를 사용하여 루트노드를 찾는다.
        // return  findParant(parent[x]);
    }

    public static void unionParent(int a, int b) {
        a = findParant(a);
        b = findParant(b);

        int parentNode = Math.min(a, b);
        int childNode = Math.max(a, b);
        parent[childNode] = parentNode;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모테이블 자기자신으로 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // union으로 집합으로 묶어줌
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(a, b);
        }

        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(findParant(i) + " ");
        }
        System.out.println();

        System.out.print("부모 테이블: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }

}
