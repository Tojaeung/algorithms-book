package BOJ.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합_11723번 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        // int형 4바이트 하나로 (총 32비트를 사용할 수 있다.)
        // 00000000 00000000 00000000 00000000
        int bitset = 0;

        while (n-- > 0) {
            // 입력횟수가 최대 3백만이기 때문에 스캐너 사용시 시간초과가 발생한다.
            // br과 st를 사용하였다.
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num;

            switch (operation) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    // 문제에서 주어진 1 <= x <= 20
                    // 그러나 비트는 0 ~ 19이기 떄문에 num에서 1을 빼준다. 
                    bitset |= 1 << (num - 1);
                    break;

                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~(1 << (num - 1));
                    break;

                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= 1 << (num - 1);
                    break;

                case "all":
                    bitset |= ~0;
                    break;

                case "empty":
                    bitset &= 0;
                    break;

                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append(((bitset & (1 << (num - 1))) != 0 ? "1\n" : "0\n"));
                    break;
            }
        }
        // sb에 모아둔 것을 한번에 방출한다.
        System.out.println(sb);
    }
}
