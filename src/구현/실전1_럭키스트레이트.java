package 구현;

import java.util.Scanner;

public class 실전1_럭키스트레이트 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int leftSUm = 0;
        int rightSUm = 0;
        for (int i = 0; i < (s.length() / 2); i++) {
            leftSUm += s.charAt(i) - '0';
        }

        for (int i = (s.length() / 2); i < s.length(); i++) {
            rightSUm += s.charAt(i) - '0';
        }

        System.out.println(leftSUm == rightSUm ? "LUCKY" : "READY");
    }
}
