package 구현;

import java.util.Scanner;

public class 문제2_시각 {

    /*
     * 3 % 10 == 0 인줄 알았는데 알고보니 3이다... 그냥 외우자 ㄷㄷ;;
     * 이거 때문에 헷갈림 ;;;;
     * 끝까지 계산해보면 0이지만 프로그래밍 언어의 계산은 다른가보다...
     * 아마도 몫이 0이어서 나머지가 3으로 떨어지나보다...
     * */
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // H를 입력받기 
        int h = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
