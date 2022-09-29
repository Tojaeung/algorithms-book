package 기타;

import java.util.Scanner;

public class 실전2_탑승구 {
    public static int g, p;
    public static int[] parent = new int[100001];

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

        g = sc.nextInt();
        p = sc.nextInt();

        for (int i = 0; i <= g; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < p; i++) {
            int root = findParent(sc.nextInt());
            // 루트 탑승구가 0이면 더 이상 비행기가 탑승구가 들어갈곳이 없다.
            if (root == 0) break;

            /*
             * 비행기가 도킹할수 있는 최대 탑승구를 선택해야 최대값이 나온다.
             * 도킹되는 탑승구보다 1아래에 있는 탑승구를 묶어준다.
             * 묶어주다보면 0이 나오는데 그러면 더이상 비행기는 탑승구에 도킹할수없는 상태가 된다.
             * */
            unionParent(root, root - 1);
            result++;
        }

        System.out.println(result);

    }
}
