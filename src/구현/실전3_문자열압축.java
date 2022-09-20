package 구현;

import java.util.Scanner;

public class 실전3_문자열압축 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int result = s.length();

        // 문자열이 짝수든 홀수든 상관없다.
        for (int step = 1; step < (s.length() / 2) + 1; step++) {
            String compressed = ""; // 압축된 문자열
            String prev = s.substring(0, step); // step의 문자열
            int cnt = 1;    // 해당 step 문자열이 몇번 반복되었는지

            // step만큼 증가 시키면서 확인
            for (int i = step; i < s.length(); i += step) {

                String sub = "";

                // "abc abc" 다음 압출될 문자열을 sub변수에 추출힌다.
                for (int j = i; j < i + step; j++) {
                    if (j < s.length()) sub += s.charAt(j);
                }

                // step마다 진행되는 문자열비교가 같다면 카운트 증가
                if (prev.equals(sub)) cnt += 1;
                else {  // step마다 진행되는 문자열비교가 다르다면
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";

                    // 연속되는 문자열이 끊어졌기 때문에 확인해야할 그 다음 문자열을 다시할당 
                    for (int k = i; k < i + step; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub;
                    cnt = 1;
                }
            }

            compressed += (cnt >= 2) ? cnt + prev : prev;
            result = Math.min(result, compressed.length());
        }

        System.out.println(result);
    }
}
