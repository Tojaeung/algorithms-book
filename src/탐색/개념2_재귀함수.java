package 탐색;

public class 개념2_재귀함수 {
    public static int factorial(int num) {
        if (num == 0) return 1;

        // 점화식으로 표현해서 간결하다 (재귀함수 장점)
        return num * factorial(num - 1);

    }

    // public static int fibonachi(int num) {
    //     if (num <= 1) return 1;
    //
    //     // 점화식으로 표현해서 간결하다 (재귀함수 장점)
    //     return fibonachi(num - 1) + fibonachi(num - 2);
    //
    // }

    public static void main(String[] args) {
        System.out.println(factorial(5));
        // System.out.println(fibonachi(40));
    }
}
