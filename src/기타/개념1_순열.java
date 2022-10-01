package 기타;

public class 개념1_순열 {
    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            for (int num : out) System.out.print(num);
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void permutation2(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            for (int num : out) System.out.print(num);
            System.out.println();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            permutation2(arr, out, depth + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int r = 2;
        // 순열
        permutation(arr, new int[r], new boolean[arr.length], 0, r);
        System.out.println("============");
        // 중복순열
        permutation2(arr, new int[r], 0, r);

    }
}
