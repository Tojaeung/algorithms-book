package 구현;

import java.util.Scanner;

public class 문제1_상하좌우 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // nextInt의 엔터가 nextLine으로 넘어가기 떄문에 버퍼 초기화
        sc.nextLine();
        String[] plans = sc.nextLine().split(" ");

        // 현재 기본 위치
        int x = 1, y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        char[] moveType = {'L', 'R', 'U', 'D'};

        for (int i = 0; i < plans.length; i++) {
            char plan = plans[i].charAt(0);

            // 이동할 좌표
            int nx = -1, ny = -1;
            for (int j = 0; j < 4; j++) {
                if (plan == moveType[j]) {
                    nx = x + dx[j]; // x좌표 이동
                    ny = y + dy[j]; // y좌표 이동
                }
            }

            if (nx < 1 || ny < 1 || nx > n || ny > n) continue;

            // 좌표 이동
            x = nx;
            y = ny;

        }
       
        System.out.println(x + " " + y);

    }
}
