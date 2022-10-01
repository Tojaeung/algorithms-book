package 그래프이론;

import java.util.Scanner;

public class 문제1_팀결성 {

    // n 노드개수 (최대 십만개), m 간선개수
    public static int n, m;
    // 부모 테이블 초기화
    public static int[] parent = new int[100001];

    public static int findRoot(int x) {
        if (x == parent[x]) return x;
        return parent[x] = findRoot(parent[x]);
    }

    public static void unionRoot(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a > b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 부모테이블 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // 연산
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();   // 1 = 같은 팀 소속인지 확인, 0 = 같은팀으로 묶기
            int y = sc.nextInt();   // a 학생
            int z = sc.nextInt();   // b 학생

            if (x == 0) {   // 같은 팀으로 묶기
                unionRoot(y, z);
            }

            if (x == 1) {   // 같은팀 소속인지 확인
                String result = parent[y] == parent[z] ? "YES" : "NO";
                System.out.print(result + " ");
            }
        }

    }

}
