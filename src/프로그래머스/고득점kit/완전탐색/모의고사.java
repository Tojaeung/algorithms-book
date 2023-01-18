package 프로그래머스.고득점kit.완전탐색;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class 모의고사 {
	public int[] solution(int[] answers) {

		int[] 수포자1 = { 1, 2, 3, 4, 5 }; // 5개씩 반복
		int[] 수포자2 = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8개씩 반복
		int[] 수포자3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10개씩 반복

		int[] score = { 0, 0, 0 };

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == 수포자1[i % 5])
				score[0]++;
			if (answers[i] == 수포자2[i % 8])
				score[1]++;
			if (answers[i] == 수포자3[i % 10])
				score[2]++;
		}

		int max = Math.max(Math.max(score[0], score[1]), score[2]);

		// 리턴값이 배열인데 아직 배열의 크기를 알 수 없음
		// 그래서, ArrayList사용
		List<Integer> list = new ArrayList<>();
		if (max == score[0])
			list.add(1);
		if (max == score[1])
			list.add(2);
		if (max == score[2])
			list.add(3);

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}

		return result;
	}
}
