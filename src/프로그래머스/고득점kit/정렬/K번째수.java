package 프로그래머스.고득점kit.정렬;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/42748
public class K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] command = commands[i];
			System.out.println(command);

			int[] filteredArr = Arrays.copyOfRange(array, command[0] - 1, command[1] - 1);

			Arrays.sort(filteredArr);
			answer[i] = filteredArr[command[2] - 1];
		}

		return answer;
	}
}
