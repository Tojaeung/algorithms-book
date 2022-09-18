package 다이나믹프로그래밍;

import java.util.Scanner;

public class 문제1_1로만들기 {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화 
    public static int[] d = new int[30001];

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        /*
         * 반복문을 사용한 보텀업 방식 (재귀함수 x)
         * 살펴보면 굉장히 간결하고 아름다운 코드이다 ㄷㄷ;;;; (미쳣다)
         * */
        for (int i = 2; i <= x; i++) {

            d[0] = 0;   // 0
            d[1] = 0;   // 1은 이미 완성되었으므로 나눌필요 없음

            // d[i - 1]은 d[i / 2 ,3 ,5]보다 큰 수 이기때문에 먼저 할당해서 MIN메서드를 활용하였다.  
            d[i] = d[i - 1] + 1;

            // dp를 활용하지 않으면 매 값마다 d[i/2]등을 또 구해줘야한다. (연산 횟수가 커지기 떄문에 비효율적)
            // 별다른 코드없이 자연스럽게 최소값이 나오도록 2 -> 3 -> 5로 코딩하였다.
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);

            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);

            // 마지막에 5을 두어서 중복으로 나누어질수 있어도 자연스럽게 최소값이 나올수 있도록 코딩하였다.
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }
        System.out.println("정답: " + d[x]);
    }
}
