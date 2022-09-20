package 구현;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 실전2_문자열재정렬 {
    public static void main(String[] args) {
        // 문자열을 분류하고 배열에서 정렬한다.
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        ArrayList arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) - '0' >= 17) {
                arr.add(s.charAt(i));
            } else {
                sum += s.charAt(i) - '0';
            }

        }

        Collections.sort(arr);

        for (Object o : arr) {
            System.out.print(o);
        }

        System.out.print("" + sum);
        System.out.println();

    }
}
