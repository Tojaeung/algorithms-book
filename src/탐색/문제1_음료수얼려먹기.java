package 탐색;

import java.util.Scanner;

public class 문제1_음료수얼려먹기 {

    // dfs 변수로 안들어가고 전역으로 설정해줬다.
    public static int n, m;
    // 그래프 초기화
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y) {

        if (x < 0 || x >= n || y < 0 || y >= m) return false;

        if (graph[x][y] == 0) {

            graph[x][y] = 1;
            dfs(x - 1, y);  // 상
            dfs(x, y + 1);  // 우
            dfs(x + 1, y);  // 하
            dfs(x, y - 1);  // 좌

            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 입력값 받기
        n = sc.nextInt();
        m = sc.nextInt();

        sc.nextLine();  // 버퍼 초기화

        // 얼음틀(맵) 만들기
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();

            for (int j = 0; j < m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        // 얼음틀 하나하나 돈다.
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (dfs(i, j)) result += 1;

            }
        }

        System.out.println(result);

    }
}
