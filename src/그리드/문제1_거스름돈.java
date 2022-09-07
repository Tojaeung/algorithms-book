package 그리드;

public class 문제1_거스름돈 {
    public static void main(String[] args) {

        // 거스름돈
        int n = 1260;

        // 동전을 사용한 획수
        int cnt = 0;

        // 사용할 수 있는 동전의 종류
        int[] coinType = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {

            // 거스름돈이 0이면 계산이 완료되었으므로 연산루프를 빠져나온다.. 
            if (n == 0) break;

            int coin = coinType[i];
            cnt += n / coin;  // 몫을 구해서 카운트에 할당한다.
            n %= coin;  // 동전으로 나눈 나머지

            System.out.println("루프: " + (i + 1) + "번째");
        }

        // 최소한의 동전을 사용해서 거스름돈을 줄수 있는가???
        System.out.println(cnt);

        /*
         * 시간 복잡도: O(K)
         *
         * */

    }
}
