package BOJ.브루트포스;

import java.util.Scanner;

public class 날짜계산_1476번 {
    // e: 지구, s: 태양, m: 달
    public static int e = 1, s = 1, m = 1;
    // 주어지는 지구,태양,달
    public static int E, S, M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        E = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        for (int year = 1; ; year++) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            e++;
            s++;
            m++;

            if (e == 16) e = 1;
            if (s == 29) s = 1;
            if (m == 20) m = 1;


        }
    }
}
