package 이코테.Ch9_기타;

import java.util.Scanner;

public class 개념3_유클리드호제법 {

    public static int uclid(int bigNum, int smallNum) {
        int r = bigNum % smallNum;  // 나머지

        // 몇번의 반복을 통해 나머지가 0이 되는지 알수없기 떄문에 재귀함수를 사용한다.
        // while문으로도 가능하다.
        if (r == 0) return smallNum;
        else return uclid(smallNum, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigNum = sc.nextInt();
        int smallNum = sc.nextInt();


        int gcd = uclid(bigNum, smallNum);  // 최대공약수

        System.out.println("최대공약수: " + gcd);

        System.out.println("최소공배수: " + (bigNum * smallNum) / gcd);

    }
}
