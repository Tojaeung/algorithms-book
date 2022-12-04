package BOJ.탐색;

import java.util.Scanner;

public class 숨박꼭질_1697번 {
    public static int n; // 수빈 위치
    public static int k; // 동생 위치
    public static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        if (n > k) { // 수빈이 위치가 더 클때
            System.out.println(n - k); // -1밖에 없다.
        } else {

        }


    }
}
