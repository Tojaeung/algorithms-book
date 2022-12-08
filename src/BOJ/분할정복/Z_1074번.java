package BOJ.분할정복;

import java.util.*;

public class Z_1074번 {
	public static int n, R, C; // n: 사이즈, r: 행, c: 열
	public static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();

		int size = (int) Math.pow(2, n);
		partition(0, 0, size);
		System.out.println(result);

	}

	public static void partition(int r, int c, int size) {
		if (size == 1)
			return;

		int newSize = size / 2;

		if (R < r + newSize && C < c + newSize) { // 1사분면
			partition(r, c, newSize);
		}

		if (R < r && c + newSize <= C) { // 2사분면
			// 2사분면 시작값
			result += (size * size) / 4;
			partition(r, c + newSize, newSize);
		}

		if (r + newSize <= R && C < c + newSize) { // 3사분면
			// 3사분면 시작값
			result += ((size * size) / 4) * 2;
			partition(r + newSize, c, newSize);
		}

		if (r + newSize <= R && c + newSize <= C) { // 4사분면
			// 4사분면 시작값
			result += ((size * size) / 4) * 3;
			partition(r + newSize, c + newSize, newSize);
		}

	}
}
