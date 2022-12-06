package BOJ.자료구조;

import java.util.*;

public class 최소힙_1927번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val == 0) {
                if (pq.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(pq.poll());
            } else {
                pq.add(val);
            }
        }
    }
}
