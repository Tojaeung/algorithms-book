package 프로그래머스.고득점kit.해쉬;

import java.util.HashSet;
import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=java
public class 폰켓몬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(solution(arr));
	}

	public static int solution(int[] arr) {
		int pickNum = arr.length / 2;

		HashSet<Integer> hashSet = new HashSet<>();
		for (int ponketmon : arr) {
			hashSet.add(ponketmon);
		}

		if (pickNum >= hashSet.size()) {
			return hashSet.size();
		} else {
			return pickNum;
		}
	}
}
