package 그리드;

import java.util.Arrays;
import java.util.Scanner;

public class 문제3_큰수의법칙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 배열의 길이
        int m = sc.nextInt();   // 몇번 더하나
        int k = sc.nextInt();   // 더할때 숫자를 몇번 반복할 수 있는가

        // 입력값을 n의 크기 배열로 만든다.
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int first = arr[n - 1];     // 가장 큰수
        int second = arr[n - 2];    // 두번째로 큰수

        /*
         *  (m / k + 1)은 수열이 반복되는 횟수이다.
         *  여기에 k를 곱하면 배열의 가장 큰수가 반복되는 숫자이다.
         *  그러나, 수열의 갯수가 m까지 정확히 안떨어질때 남은 배열의 가장 큰수를 처리해줘야한다.
         * */
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1); // m까지 안떨어지기 때문에 나머지를 더해준다.

        // cnt = 첫재로 큰 수의 갯수가 된다.

        int result = 0;
        result += cnt * first;
        result += (m - cnt) * second;

        System.out.println(result);


        // 나의 풀이
        // int secondCnt = m / (k + 1);    // 두번째 큰수의 갯
        // int firstCnt = m - secondCnt;   // 첫번째 큰수의 갯수
        //
        // System.out.println((first * firstCnt) + (second * secondCnt));
    }
}
