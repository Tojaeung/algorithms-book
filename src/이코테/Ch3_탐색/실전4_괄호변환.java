package 이코테.Ch3_탐색;

import java.util.Scanner;

public class 실전4_괄호변환 {
    // 균형잡힌 괄호 문자열
    static int balancedIndex(String p) {
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else cnt--;
            if (cnt == 0) return i;
        }
        // 균형잡힌 괄호가 없다면 -1 반환
        return -1;
    }

    // 완전한 문자열인지 체크
    static boolean check(String p) {
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') cnt++;
            else {
                if (cnt == 0) return false;
                cnt--;
            }
        }
        return true;
    }

    static String solution(String p) {
        String answer = "";
        if (p.equals("")) return answer;

        // subString 인덱스 사용 주의
        String u = p.substring(0, balancedIndex(p) + 1);
        String v = p.substring(balancedIndex(p) + 1);

        // u가 완전한 괄호 문자열이라면 v를 재귀
        if (check(u)) {
            answer = u + solution(v);
        } else {
            answer += '(';
            answer += solution(v);
            answer += ')';
            u = u.substring(1, u.length() - 1);

            String temp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') temp += ')';
                else temp += '(';
            }
            answer += temp;
        }

        return answer;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(solution(sc.nextLine()));
    }
}
