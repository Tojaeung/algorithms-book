package 프로그래머스.고득점kit.해쉬;

import java.util.HashMap;

// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class 완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hashMap = new HashMap<>();

		// getOrDefault
		for (String runner : participant) {
			hashMap.put(runner, hashMap.getOrDefault(runner, 0) + 1);
		}

		for (String completedRunner : completion) {
			hashMap.put(completedRunner, hashMap.get(completedRunner) - 1);
		}

		for (String key : hashMap.keySet()) { // entrySet, keySet 메서드 차이
			if (hashMap.get(key) != 0) {
				answer = key;
				System.out.println(answer);
				break; // break활용으로 조기 종료 가능(효율)
			}
		}

		return answer;
	}
}
