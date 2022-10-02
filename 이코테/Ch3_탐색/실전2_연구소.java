package 이코테.Ch3_탐색;

import java.util.Scanner;

public class 실전2_연구소 {
    public static int n, m, result = 0;
    // 미리 최대의 배열의 경우로 초기화 시켜둔다. (코드 간단)
    public static int[][] arr = new int[8][8];
    public static int[][] temp = new int[8][8];

    // 상하좌우
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    // dfs 알고리즘으로 바이러스를 퍼지게 한다.
    public static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx > n || ny > m) continue;
            if (temp[nx][ny] == 0) {
                temp[nx][ny] = 2;
                virus(nx, ny);
            }
        }
    }

    // 현재 맵 안전영역 크기 계산(0인 구역)
    public static int getScore() {
        int score = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == 0) score++;
            }
        }
        return score;
    }

    // 너무 어려움 ㅠ 이해못함....
    public static void dfs(int count) {
        // 울타리가 3개 설치된 경우
        if (count == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
            // 각 바이러스의 위치에서 전파 진행
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            // 안전 영역의 최대값 계산
            result = Math.max(result, getScore());
            return;
        }
        // 빈 공간에 울타리를 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    count += 1;
                    dfs(count);
                    arr[i][j] = 0;
                    count -= 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0);
        System.out.println(result);
    }
}
