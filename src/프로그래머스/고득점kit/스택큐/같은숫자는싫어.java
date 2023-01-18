package 프로그래머스.고득점kit.스택큐;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class 같은숫자는싫어 {
	public int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();

		int num = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != num) {
				list.add(arr[i]);
				num = arr[i];
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		System.out.println(answer);
		return answer;
	}
}
