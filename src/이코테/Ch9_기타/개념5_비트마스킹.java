package 이코테.Ch9_기타;

public class 개념5_비트마스킹 {

    private static void printSubsets(char[] arr, int n) {
        // 1 << n 부분집합의 총 개수
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            for (int j = 0; j < n; j++) {
                // 부분집합을 구하는 조건
                if ((i & 1 << j) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D'};
        printSubsets(data, 4);
    }


}
