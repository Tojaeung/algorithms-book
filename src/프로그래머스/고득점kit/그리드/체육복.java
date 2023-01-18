package 프로그래머스.고득점kit.그리드;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42862
public class 체육복 {
	public int solution(int n, int[] lost, int[] reserve) {

		int answer = n;
		int[] students = new int[n];

		Arrays.fill(students, 1);
		for (int i : lost)
			students[i - 1]--;
		for (int i : reserve)
			students[i - 1]++;

		// 0 인데 주변에 2가 없으면 answer -1
		for (int i = 0; i < students.length; i++) {
			if (students[i] == 0) { // 체육복 없는 학생
				if (i > 0 && students[i - 1] == 2) { // 체육복 없는 학생의 왼쪽학생이 여분의 옷을 가지고 있을때
					students[i - 1]--;
				} else if (i < (students.length - 1) && students[i + 1] == 2) { // 체육복 없는 학생의 오른쪽학생이 여분의 옷을 가지고 있을때
					students[i + 1]--;
				} else {
					answer--;
				}
			}
		}
		return answer;
	}
}
