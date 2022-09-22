package 정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 실전2_안테나 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arrList.add(sc.nextInt());
        }

        // 중간값 계산을 위해 정렬
        Collections.sort(arrList);

        // 중간값일떄 항상 최솟값이 된다는것을 직접 종이에 해봐서 알게되었다.
        System.out.println(arrList.get(n - 1) / 2);
    }
}
