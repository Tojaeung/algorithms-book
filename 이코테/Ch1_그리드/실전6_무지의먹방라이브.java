package 이코테.Ch1_그리드;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Food implements Comparable<Food> {
    private int time;
    private int index;

    public Food(int time, int index) {
        this.time = time;
        this.index = index;
    }

    public int getTime() {
        return time;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(Food o) {
        // 앞의 인자가 더크면 1를 반환하기 떄문에 오름차순정렬이다.
        return Integer.compare(this.time, o.time);
    }
}

public class 실전6_무지의먹방라이브 {

    public static int solution(int[] food_times, int k) {
        // 전체 음식을 먹는 시간보다 k가 크거나 같다면 -1
        int summary = 0;
        for (int i = 0; i < food_times.length; i++) {
            summary += food_times[i];
        }
        if (summary <= k) return -1;

        // 시간이 짧은 음식부터 처리하기 위해 우선순위 큐 사용
        PriorityQueue<Food> pq = new PriorityQueue<>();
        for (int i = 0; i < food_times.length; i++) {
            // 음식 번호는 1번부터
            pq.offer(new Food(food_times[i], i + 1));
        }

        summary = 0;    // 총 걸린시간
        int prev = 0;   // 이전에 최소시간
        int length = food_times.length; // 음식 갯수

        // 총걸린시간이 k시간을 초과하기전에 스탑시켜준다.
        while (summary + ((pq.peek().getTime() - prev) * length) <= k) {

            int now = pq.poll().getTime();

            // 이전의 최소시간을 빼준다.
            // 왜냐하면 이전에 사용했던 시간이니까....
            summary += (now - prev) * length;

            length -= 1; // 같은 시간이 걸리는 음식이 있으면 어떡해?????

            prev = now;  // 최소시간을 교체해준다.   
        }

        ArrayList<Food> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // 음식의 번호 순서대로 정렬 ( 이제 찾아내기 위해서 )
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return Integer.compare(o1.getIndex(), o2.getIndex());
            }
        });

        return result.get((k - summary) % length).getIndex();
    }

    public static void main(String[] args) {
        int[] food_times = new int[]{8, 6, 4};
        int k = 15;
        System.out.println(solution(food_times, k));

    }
}
