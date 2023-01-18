package 프로그래머스.고득점kit.스택큐;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://school.programmers.co.kr/learn/courses/30/lessons/42586
public class 기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < progresses.length; i++) {

			// 100으로 했다가 오답나옴 ...ㄷㄷ;;;
			q.offer((int) Math.ceil((100 - progresses[i]) / speeds[i])); // 작업이 몇일 소요되는지
		}

		List<Integer> anwser = new ArrayList<>();
		while (!q.isEmpty()) {
			int day = q.poll();
			int cnt = 1;

			while (!q.isEmpty() && day >= q.peek()) {
				cnt++;
				q.poll(); // 확인한거 버리기
			}
			anwser.add(cnt);
		}

		return anwser.stream().mapToInt(Integer::intValue).toArray();
	}
}
