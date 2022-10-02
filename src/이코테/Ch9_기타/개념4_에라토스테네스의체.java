package 이코테.Ch9_기타;

public class 개념4_에라토스테네스의체 {
    public static boolean isPrime(int num) {
        if (num == 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime2(int num) {
        if (num == 1) return false;

        // 소수가 아니라면 제곱근이하에 반드시 약수가 존재한다.
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static boolean[] es(int max) {
        // 배열은 0부터 시작한다.
        boolean[] Prime = new boolean[max + 1];

        // 0, 1은 소수가 아니므로 true처리
        Prime[0] = Prime[1] = true;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            // 소수가 아니라면 true
            if (!Prime[i]) continue;

            // i * i 로 시작해도 괜찮다. (이전의 소수가 소수판정을 다 해놨다.)
            for (int j = i * i; j < max + 1; j += i) {
                Prime[i] = true;
            }
        }

        return Prime;
    }

    public static void main(String[] args) {
        // 기본 판별: 하나씩 확인해서 나누어지는지 확인한다.
        System.out.println("기본판별법: " + isPrime(7));
        System.out.println("제곱근판별법: " + isPrime2(7));

        // 에라토스테네스의 체
        boolean[] primes = es(120);
        for (boolean prime : primes) {
            System.out.println(prime);
        }
    }
}
