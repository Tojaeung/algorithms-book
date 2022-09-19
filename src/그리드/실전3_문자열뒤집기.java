package 그리드;

import java.util.Scanner;

public class 실전3_문자열뒤집기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 0 또는 1로 된 연속된 뭉치의 개수를 각각구하고 더 작은 뭉치를 뒤집는다.
        String s = sc.nextLine();
        int[] arr = new int[1000000];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        // 덩어리 개수
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] != arr[i + 1]) {
                if (arr[i] == 0) {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
        }
        System.out.println(Math.min(cnt0, cnt1));
    }
}
