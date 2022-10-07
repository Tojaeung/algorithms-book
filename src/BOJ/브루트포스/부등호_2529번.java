package BOJ.브루트포스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 부등호_2529번 {
    public static int k;
    public static boolean[] visit = new boolean[10];

    public static char[] arr;

    public static List<String> result = new ArrayList<>();

    // 모든 순열을 
    public static void dfs(String num, int depth) {
        // k + 1 부등호보다 숫자가 1이 더 많다.
        if (depth == k + 1) {
            result.add(num);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            // 부등호 비교를 위해 처음에는 그냥 넘겨준다.
            if (depth == 0 || !visit[i] && compare(num.charAt(num.length() - 1) - '0', i, arr[depth - 1])) {
                visit[i] = true;
                // num은 문자열, i는 int형이다. 두개의 형을 더하면 하나의 문자열로 된다.
                dfs(num + i, depth + 1);
                visit[i] = false;
            }
        }
    }

    public static boolean compare(int a, int b, char c) {
        if (c == '<') return a < b;
        else return a > b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        arr = new char[k];

        for (int i = 0; i < k; i++) {
            arr[i] = sc.next().charAt(0);
        }

        dfs("", 0);

        Collections.sort(result);
        System.out.println(result.get(result.size() - 1));  // 최대값
        System.out.println(result.get(0));  // 최소값
    }
}
