package BOJ.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 덱_10866번 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;

            switch (command) {
                case "push_front":
                    num = Integer.parseInt(st.nextToken());
                    dq.offerFirst(num);
                    break;
                case "push_back":
                    num = Integer.parseInt(st.nextToken());
                    dq.offerLast(num);
                    break;

                case "pop_front":
                    sb.append(dq.isEmpty() ? "-1\n" : dq.pollFirst() + "\n");
                    break;
                case "pop_back":
                    sb.append(dq.isEmpty() ? "-1\n" : dq.pollLast() + "\n");
                    break;

                case "front":
                    sb.append(dq.isEmpty() ? "-1\n" : dq.peekFirst() + "\n");
                    break;
                case "back":
                    sb.append(dq.isEmpty() ? "-1\n" : dq.peekLast() + "\n");
                    break;

                case "size":
                    sb.append(dq.size() + "\n");
                    break;
                case "empty":
                    sb.append(dq.isEmpty() ? "1\n" : "0\n");
                    break;
            }

        }
        System.out.println(sb);
    }
}
