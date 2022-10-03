package BOJ.Ch4_정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 단어정렬_1181번 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 길이가 같을때 오름차순 정렬
                if (o1.length() == o2.length()) return o1.compareTo(o2);
                    // 길이가 다를때 양의정수: 위치바꿈, 음의정수: 그대로
                else return o1.length() - o2.length();
            }
        });

        // 중복출력 방지
        System.out.println(arr[0]);
        for (int i = 1; i < n; i++) {
            // 문자열 비교는 equals
            if (!arr[i].equals(arr[i - 1])) {
                System.out.println(arr[i]);
            }
        }

    }
}
