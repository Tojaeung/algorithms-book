package 프로그래머스.고득점kit.완전탐색;

// https://school.programmers.co.kr/learn/courses/30/lessons/86491
public class 최소직사각형 {
	public int solution(int[][] sizes) {

		int widthMax = 0;
		int heightMax = 0;

		for (int[] size : sizes) {

			int tmpWidth = Math.max(size[0], size[1]);
			int tmpHeight = Math.min(size[0], size[1]);

			if (tmpWidth > widthMax)
				widthMax = tmpWidth;
			if (tmpHeight > heightMax)
				heightMax = tmpHeight;

			// System.out.println(widthMax);
			// System.out.println(heightMax);
		}

		return widthMax * heightMax;
	}
}
