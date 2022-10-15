package BOJ.DP;

import java.util.Scanner;
import java.util.Stack;

public class 가장긴증가하는부분수열4_14002번 {
    public static int n;
    public static int[] arr = new int[1001];
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);


        // 스택 자료구조를 사용해서 역추적 해준다.
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == max) {
                stack.push(arr[i]);
                max--;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

        // dp[i]가 이전 max2보다 증가할떄 .......의 i의 값이...
        // arr.get(i)와 싱크가 맞다는것을 발견해서(저의 생각...;;;;)
        // 질문 https://www.acmicpc.net/board/view/102002
        // 왜 아래의 생각이 틀리다는 반례
        // int max2 = 0;
        // for (int i = 0; i < n; i++) {
        //     if (max2 < dp[i]) {
        //         max2 = dp[i];
        //         System.out.print(arr.get(i) + " ");
        //     }
        // }
        // System.out.println();
    }
}
