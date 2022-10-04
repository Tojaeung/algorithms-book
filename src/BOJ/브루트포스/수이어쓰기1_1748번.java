package BOJ.브루트포스;

import java.util.Scanner;

public class 수이어쓰기1_1748번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int result = 0; // total 자릿수 
        int plus = 1;   // 더해야할 자릿수
        int num = 10;   // 자릿수가 변경되는 시점

        // 입력된 수까지 자릿수를 더한다.
        for (int i = 1; i <= n; i++) {

            // 10의 배수마다 자릿수가 변경된다.
            if (i % num == 0) {
                plus++;
                num *= 10;
            }

            result += plus;
        }
        System.out.println(result);
    }
}
