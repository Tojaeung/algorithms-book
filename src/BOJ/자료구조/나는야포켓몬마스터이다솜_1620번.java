package BOJ.자료구조;

import java.util.*;

public class 나는야포켓몬마스터이다솜_1620번 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 포켓몬 수
		int m = sc.nextInt(); // 풀어야할 문제 수

		Map<String, Integer> hashMap = new HashMap<>();
		String[] arr = new String[n + 1];


		for (int i = 1; i < n + 1; i++) {
			String pocketmon = sc.next();

			// 문자열은 해쉬맵을 이용해서 찾는다.
			// 빅오표기법: 1 (바로 찾을 수 있음)
			hashMap.put(pocketmon, i);
			// 숫자는 배열을 이용해서 찾는다.
			// 빅오표기법: 1 (바로 찾을 수 있음)
			arr[i] = pocketmon;
		}

		for (int i = 0; i < m; i++) {
			String input = sc.next();

			if (isInteger(input)) {
				System.out.println(arr[Integer.parseInt(input)]);
			} else {
				System.out.println(hashMap.get(input));
			}
		}
	}

	// 문자열이 숫자인지 아닌지 판별해주는 메서드
	public static boolean isInteger(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}
