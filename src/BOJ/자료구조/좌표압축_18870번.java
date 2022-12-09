package BOJ.자료구조;

import java.util.*;

public class 좌표압축_18870번 {
    public static Scanner sc = new Scanner(System.in);

    public static int n;
    public static int[] originalArr;
    public static int[] sortedArr;
    public static HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public static void main(String[] args) {
        n = sc.nextInt();
        originalArr = new int[n];
        sortedArr = new int[n];

        for (int i = 0; i < n; i++) {
            originalArr[i] = sortedArr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(sortedArr);

        int rank = 0;
        for (int val : sortedArr) {
            if (!hm.containsKey(val)) {
                hm.put(val, rank);
                rank++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int key : originalArr) {
            int ranking = (int) hm.get(key);
            sb.append(ranking).append(" ");
        }

        System.out.println(sb);

    }

}
