package 이코테.Ch3_탐색;

import java.util.Scanner;

public class 문제1_음료수얼려먹기 {

    // dfs 변수로 안들어가고 전역으로 설정해줬다.
    public static int n, m;
    // 그래프 초기화
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y) {

        // 상하좌우 이동시, 얼음틀을 벗어나는 경우
        if (x < 1 || x > n || y < 1 || y > m) return false;

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
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                // ( j - 1 )을 입력값의 싱크를 맞춰준다. (이거때메 한참해멧음..ㄷㄷ)
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        // 얼음틀 하나하나 돈다.
        int result = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (dfs(i, j)) result += 1;

            }
        }

        System.out.println(result);

    }
}
