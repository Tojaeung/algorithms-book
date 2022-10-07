package BOJ.브루트포스;

import java.util.Scanner;

public class 스타트와링크_14889번 {
    public static int n;
    public static int[][] map;
    public static boolean[] visit;

    public static int min = Integer.MAX_VALUE;  // 21억 정도....

    // 주어진 n에서 팀을 뽑는 조합
    public static void dfs(int start, int depth) {
        if (depth == n / 2) {
            diff();
            return;
        }

        // visit을 사용해서 따로 배열을 만들지않고 조합으로 묶인것과 아닌것을 구분할 수 있다.
        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                dfs(i + 1, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static void diff() {
        int teamStart = 0;
        int teamLink = 0;

        // for문을 이용해서 조합을 추출하고 같은팀인지 비교한다.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // 같은팀이면 능력치를 계산한다.
                if (visit[i] && visit[j]) teamStart += (map[i][j] + map[j][i]);
                if (!visit[i] && !visit[j]) teamLink += (map[i][j] + map[j][i]);
            }
        }

        int val = Math.abs(teamStart - teamLink);
        // val이 0이면 더이상 최소값은 없으므로 그대로 출력하고 종료한다.
        if (val == 0) {
            System.out.println(val);
            System.exit(0); // 자바 프로그램 강제종료
        }

        min = Math.min(min, val);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }
}
