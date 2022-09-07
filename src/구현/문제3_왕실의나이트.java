package 구현;

import java.util.Scanner;

public class 문제3_왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
         * 나의 답안
         * */
        String defaultLocation = sc.nextLine();

        char charX = defaultLocation.charAt(0);
        int y = defaultLocation.charAt(1) - '0';
        int x = 0;

        // 문자열 x축을 int로 변경
        switch (charX) {
            case 'a':
                x = 1;
                break;
            case 'b':
                x = 2;
                break;

            case 'c':
                x = 3;
                break;
            case 'd':
                x = 4;
                break;
            case 'e':
                x = 5;
                break;
            case 'f':
                x = 6;
                break;
            case 'g':
                x = 7;
                break;
            case 'h':
                x = 8;
                break;
        }

        int cnt = 0;

        int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dy = {-1, 1, -2, -2, -1, 1, 2, 2};

        for (int i = 0; i < 8; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || ny < 1 || nx > 8 || ny > 9) continue;

            cnt++;

        }

        System.out.println(cnt);



        /*
         * 문제집 답안
         *
         * */
        String inputData = sc.nextLine();

        // 문제집 답안해서는 아스키코드를 이용해서 int로 형변환 하였다.
        int row = inputData.charAt(1) - '0';
        int column = inputData.charAt(0) - 'a' + 1;

        // 나이트가 이동할 수 있는 8가지 방향 정의
        int[] dx2 = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy2 = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int result = 0;
        for (int i = 0; i < 8; i++) {
            // 이동하고자 하는 위치 확인
            int nextRow = row + dx2[i];
            int nextColumn = column + dy2[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (nextRow >= 1 && nextRow <= 8 && nextColumn >= 1 && nextColumn <= 8) {
                result += 1;
            }
        }

        System.out.println(result);

    }


}
