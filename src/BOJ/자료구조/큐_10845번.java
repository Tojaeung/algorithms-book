package BOJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 큐_10845번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        // 큐일떄는 맨뒤의 값을 참조하는 메서드가 없기 떄문에 LinkedList를 사용하였다.
        LinkedList<Integer> q = new LinkedList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();
            int num;

            switch (operation) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    q.offer(num);
                    break;

                case "pop":
                    sb.append(q.isEmpty() ? "-1\n" : q.poll() + "\n");
                    break;

                case "size":
                    sb.append(q.size() + "\n");
                    break;

                case "empty":
                    sb.append(q.isEmpty() ? "1\n" : "0\n");
                    break;

                case "front":
                    sb.append(q.isEmpty() ? "-1\n" : q.peekFirst() + "\n");
                    break;

                case "back":
                    // 큐는 맨뒤에 값을 참조하는 메서드가 존재하지 않는다.
                    sb.append(q.isEmpty() ? "-1\n" : q.peekLast() + "\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
