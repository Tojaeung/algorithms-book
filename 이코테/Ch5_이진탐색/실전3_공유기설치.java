package 이코테.Ch5_이진탐색;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// https://wooono.tistory.com/404 문제 이해가 안되서 참고
public class 실전3_공유기설치 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();   // 집의 수
        int c = sc.nextInt();   // 공유기 설치 개수 (적당한 거리에 모두 설치되어야한다.)

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        // 이진탐색을 위해 정렬
        Collections.sort(arr);

        int start = 1;  // 가능한 최소거리
        int end = arr.get(n - 1) - arr.get(0);  // 가능한 최대거리
        int result = 0;

        while (start <= end) {
            // 가장 인접한 두 공유기 사이의 거리를 의미
            int mid = (start + end) / 2;

            // 첫번째 집에는 무조건 공유기를 설치한다고 생각 
            int value = arr.get(0);
            int cnt = 1;
            for (int i = 1; i < n; i++) {
                // value 집 위치이고 mid는 집까지의 간격이다.
                if (arr.get(i) >= value + mid) {
                    value = arr.get(i);
                    cnt++;
                }
            }

            // c개 이상의 공유를 설치할 수 있을때 거리를 증가
            if (cnt >= c) {
                start = mid + 1;
                // 거리를 증가시키면 result도 증가하기때문에 Math.max메서드를 사용하지 않았다.
                result = mid;

            }
            // c개 이상의 공유를 설치할 수 없을때 거리를 감소
            else end = mid - 1;

        }
        System.out.println(result);
    }
}
