package BOJ.DP;

import java.util.ArrayList;
import java.util.Scanner;

public class 퇴사_14501번 {
    public static class Plan {
        private int time;
        private int price;

        public Plan(int time, int price) {
            this.time = time;
            this.price = price;
        }

        public int getTime() {
            return time;
        }

        public int getPrice() {
            return price;
        }
    }

    public static int n;
    public static ArrayList<Plan> plans = new ArrayList<>();
    public static int[] dp = new int[16];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int price = sc.nextInt();
            plans.add(new Plan(time, price));
        }

        for (int i = 0; i < n; i++) {
            int time = plans.get(i).getTime();
            int price = plans.get(i).getPrice();

            if (i + time <= n) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + price);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[n]);

        // for (int i = 0; i < n; i++) {
        //
        //     int totalTime = 0;
        //     int totalPrice = 0;
        //
        //     int startTime = plans.get(i).getTime();
        //     if (i + 1 + startTime > n || startTime > n) continue;
        //
        //     totalTime += startTime;
        //     totalPrice += plans.get(i).getPrice();
        //
        //     for (int j = i + startTime; j < n; j++) {
        //         int nextTime = plans.get(j).getTime();
        //         if (j + nextTime > n || totalTime + nextTime > n) continue;
        //
        //         totalTime += nextTime;
        //         totalPrice += plans.get(j).getPrice();
        //     }
        //     result = Math.max(result, totalPrice);
        // }
    }
}
