package 이코테.Ch2_구현;

public class 실전4_자물쇠와열쇠 {

    // 2차배열 90도 회전
    public static int[][] rotate90Degree(int[][] a) {
        // 이중배열 가로, 세로 구하기
        int n = a.length;
        int m = a[0].length;

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 2차원배열 회전식
                result[i][j] = a[j][n - i - 1];
            }
        }

        return result;
    }

    // 자물쇠가 모두 1인지 확인
    public static boolean check(int[][] newLock) {
        int lockLength = newLock.length / 3;
        for (int i = lockLength; i < lockLength * 2; i++) {
            for (int j = lockLength; j < lockLength * 2; j++) {
                if (newLock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;

        // 기존 자물쇠에서 3배를 늘린다.
        int[][] newLock = new int[n * 3][n * 3];

        // 자물쇠를 새로운자물쇠(3배늘린 자물쇠)의 중앙에 놓는다.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newLock[i + n][j + n] = lock[i][j];
            }
        }

        for (int rotation = 0; rotation < 4; rotation++) {
            key = rotate90Degree(key);  // 90도로 4회전

            // 키가 3이므로 3배로 늘린자물쇠에 6까지 와야 맞아떨어진다. (6을 넘으면 자물쇠를 넘어가버린다.)
            for (int x = 0; x < n * 2; x++) {
                for (int y = 0; y < n * 2; y++) {

                    // 자물쇠에 키가 맞나 확인하기
                    for (int i = 0; i < m; i++) {
                        for (int j = 0; j < m; j++) {
                            newLock[x + i][y + j] += key[i][j];
                        }
                    }

                    // 자물쇠가 모두 1이 되면 키가 맞는것이다.
                    if (check(newLock)) return true;
                    else {  // 자물쇠 안 맞으면 키 도로 뺴기
                        for (int i = 0; i < m; i++) {
                            for (int j = 0; j < m; j++) {
                                newLock[x + i][y + j] -= key[i][j];
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
