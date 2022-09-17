package 이진탐색;

import java.util.Scanner;

// 계수정렬로 풀기
public class 문제1_부품찾기2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        /*
         * 나는 arr(도구종류 배열)만들고 table(계수정렬을 위한)도 만들었지만
         * 모범답안은 계수정렬 테이블만 만들었다.(간단)
         * 계수정렬 테이블의 배열을 new int[n]이라고 했다가 에러가 났다.
         * 계수정렬 테이블에는 인덱스에 +1이 되기때문에 반드시 !!! [10000001]로 초기화 시켜야한다.
         * */
        int n = sc.nextInt();
        int[] arr = new int[1000001];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr[x] = 1;
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
            if (arr[targets[i]] == 1) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
