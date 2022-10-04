package BOJ.브루트포스;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_2309번 {
    // n: 9명의 난쟁이 수
    // k: 7명의 난쟁이 수를 모두 더하면 100
    public static int n = 9, k = 100;
    public static int[] arr = new int[n];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[i] = x;
            sum += x;
        }

        // 9명에서 7명을 뽑아서(조합) 100이 되는 로직보다 9명에서 2명을 뺴서 100이 되는 로직이 간단하다.
        for (int i = 0; i < n - 1; i++) {
            // 조합문제이므로 한번 계산된 경우는 또 계산하지 않는다.(순서 없음)
            for (int j = i + 1; j < n; j++) {
                // 9명에서 2명을 뽑을떄 100이되는 모든 조합을 찾는다.
                if ((sum - arr[i] - arr[j]) == k) {
                    // 조합을 찾았을때 출력시, 필터링하기 위해 0으로 만들어주고
                    arr[i] = arr[j] = 0;

                    // 오름차순정렬(조합을 0으로 설정했기 때문에 맨앞으로 올것이다.)
                    Arrays.sort(arr);

                    // 조합 필터링을 위해 start를 2부터 시작한다.
                    for (int l = 2; l < arr.length; l++) {
                        System.out.println(arr[l]);
                    }

                    // 답을 찾았다면... return으로 전체 main메서드를 종료한다.
                    return;
                }
            }

        }
    }
}
