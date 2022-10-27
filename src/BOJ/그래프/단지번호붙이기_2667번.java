package BOJ.그래프;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 단지번호붙이기_2667번 {
    public static int n;
    public static int[][] map = new int[25][25];

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int cnt;
    public static ArrayList<Integer> result = new ArrayList();

    public static void dfs(int x, int y) {
        map[x][y] = 0;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] != 0) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    cnt = 0;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
