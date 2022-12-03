package BOJ.자료구조;

import java.util.*;

public class 듣보잡_1764번 {
    private static int n, m; // 듣도 못한 사람 수, 보도 못한 사람 수

    private static Map<String, Integer> hashMap = new HashMap<>();
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            hashMap.put(sc.next(), 1);
        }

        for (int i = 0; i < m; i++) {
            String name = sc.next();
            hashMap.put(name, hashMap.getOrDefault(name, 0) + 1);

            if (hashMap.get(name) == 2)
                list.add(name);
        }

        Collections.sort(list);
        System.out.println(list.size());

        for (String name : list)
            System.out.println(name);

        // hashMap.forEach((key, value) -> {
        // System.out.println(key + ": " + value);
        // });

        // ohhenrie: 2
        // obama: 1
        // clinton: 1
        // baesangwook: 2
        // charlie: 1

    }
}
