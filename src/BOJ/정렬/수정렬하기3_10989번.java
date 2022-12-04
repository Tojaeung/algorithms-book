package BOJ.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3_10989번 {
    public static void main(String[] args) throws IOException {
        // 스캐너가 느려서.... 시간초과 다투는 문제는 왠만하면 br를 사용한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];

        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(br.readLine())] += 1;
        }

        br.close();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10001; i++) {
            // if (arr[i] == 0) continue;
            // if (arr[i] == 1) System.out.println(i);
            // if (arr[i] > 1) {
            // int cnt = arr[i];
            // while (cnt != 0) {
            // System.out.println(i);
            // cnt--;
            // }
            // }

            // 위의 코드가 이렇게 간결하고 쉽게 바뀔수 있다,....
            while (arr[i] > 0) {
                sb.append(i).append("\n");
                arr[i]--;
            }
        }

        System.out.println(sb);

        // 오름차순 정렬
        // sort메서드로는 시간초과...
        // Arrays.sort(arr);
    }
}
