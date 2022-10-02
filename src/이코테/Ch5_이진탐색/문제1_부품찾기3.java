package 이코테.Ch5_이진탐색;

import java.util.HashSet;
import java.util.Scanner;

// set자료구조로 풀이
public class 문제1_부품찾기3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // N(가게의 부품 개수)
        int n = sc.nextInt();

        /*
         * 해쉬set은 중복x, 순서x
         * 해쉬를 사용하기 때문에 값을 찾을때 엄청 빠르다. 시간복잡도 = O(1)
         * 그래서, 단순히 어떠한 값이 존재하는지 유무를 파악하고자 할때 유용하게 사용될수 있다.
         * 배열에서 순차탐색 또는 이진탐색을 할 필요없이 빠르게 간편하게 찾을수 있기 대문이다.
         * */
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            s.add(x);
        }

        // M(손님이 확인 요청한 부품 개수)
        int m = sc.nextInt();
        int[] targets = new int[n];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i = 0; i < m; i++) {
            // 해당 부품이 존재하는지 확인
            if (s.contains(targets[i])) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }
}
