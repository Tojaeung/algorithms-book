package BOJ.분할정복;

import java.util.*;

public class 색종이만들기_2630번 {
	public static int n;
	public static int[][] map;

	public static int white = 0;
	public static int blue = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		partition(0, 0, n);

		System.out.println(white);
		System.out.println(blue);
	}

	public static void partition(int row, int col, int size) {
		if (checkColor(row, col, size) == true) {
			return;
		} else {
			size /= 2;
			partition(row, col, size);
			partition(row + size, col, size);
			partition(row, col + size, size);
			partition(row + size, col + size, size);
		}
	}

	// 정사각형 색상 체크 메서드
	public static boolean checkColor(int row, int col, int size) {
		// 정사각형의 처음부분 색깔을 기준으로 색상체크
		int color = map[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != color) {
					return false;
				}
			}
		}

		if (color == 0) { // 하얀색이라면...
			white++;
		} else { // 파란색이라면..
			blue++;
		}

		return true;
	}

}
