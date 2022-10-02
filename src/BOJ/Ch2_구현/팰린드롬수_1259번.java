package BOJ.Ch2_구현;

import java.util.Scanner;

public class 팰린드롬수_1259번 {
    public static int x;

    public static String check(int x) {
        String str = Integer.toString(x);

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return "no";
        }
        return "yes";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            x = sc.nextInt();
            if (x == 0) break;
            System.out.println(check(x));
        }
    }
}
