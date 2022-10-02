package BOJ.Ch9_기타;

import java.util.Scanner;

public class 최대공약수배수_2609번 {
    public static int uclid(int bigNum, int smallNum) {
        int r = bigNum % smallNum;  // 나머지

        // 몇번의 반복을 통해 나머지가 0이 되는지 알수없기 떄문에 재귀함수를 사용한다.
        // while문도 가능하다
        if (r == 0) return smallNum;
        else return uclid(smallNum, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bigNum = sc.nextInt();
        int smallNum = sc.nextInt();


        int gcd = uclid(bigNum, smallNum);  // 최대공약수

        System.out.println(gcd);

        System.out.println((bigNum * smallNum) / gcd);

    }
}
