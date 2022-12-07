package BOJ.자료구조;

import java.util.*;

public class 최대힙_11279번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if (x == 0) {
                if (pq.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(pq.poll());
            } else {
                pq.add(x);
            }
        }

    }
}
