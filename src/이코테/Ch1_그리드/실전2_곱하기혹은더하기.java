package 이코테.Ch1_그리드;

import java.util.Scanner;

public class 실전2_곱하기혹은더하기 {
    public static String n;
    public static int[] arr = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 20자리
        n = sc.nextLine();

        int result = n.charAt(0) - '0';

        for (int i = 1; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            if (num <= 1 || result <= 1) {
                result += num;
            } else {
                result *= num;
            }
        }

        System.out.println(result);


        // 또는 마지막에 0이 나오는 경우 앞 숫자랑 더하기

    }
}
