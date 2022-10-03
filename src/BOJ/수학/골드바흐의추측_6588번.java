package BOJ.수학;

import java.util.Scanner;

public class 골드바흐의추측_6588번 {
    public static int max = 1000001;    // 배열 0부터 시작해서 +1
    public static boolean[] prime = new boolean[max];

    // 에라토스테네스의 체
    public static boolean[] es() {
        // 0,1은 소수 아님
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (prime[i]) continue;

            for (int j = i * i; j < max; j += i) {
                prime[j] = true;
            }
        }
        return prime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // while문 안에 선언이 되면 입력을 받을때마다 소수를 찾는 메서드가 실행되기 때문에
        // 미리 최대범위의 소수를 찾아 놓고 돌려쓰기한다. (최적화)
        boolean[] primes = es();

        // 아래의 코드와 비교하면 정말 깔끔한 코드다...
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;  // 0을 입력하면 테스트 종료

            boolean ok = false; // 소수 조합을 찾았는지 여부

            for (int i = 2; i <= n / 2; i++) {
                // 1은 소수가 아니므로 i를 2부터 시작한다.
                // 그런데 소수 2가 포함되는 골드바흐의 추측은 존재하지않는다. 안심하고 2부터 해도된다... 
                if (!primes[i] && !primes[n - i]) {
                    System.out.println(n + " = " + i + " + " + (n - i));
                    // 소수조합을 찾았다
                    ok = true;
                    break;
                }
            }

            // 소수 조합을 못찾았다.
            if (!ok) System.out.println("Goldbach's conjecture is wrong.");


            // ArrayList<Integer> arr = new ArrayList<>();
            // for (int i = 0; i < primes.length; i++) {
            //     if (!primes[i]) arr.add(i);
            // }
            //
            // int lastPrime = arr.get(arr.size() - 1);
            // int lastSecondaryPrime = arr.get(arr.size() - 2);
            //
            //
            // if (lastPrime == n - 1) {
            //     System.out.println(n + " = " + (n - lastSecondaryPrime) + " + " + lastSecondaryPrime);
            // } else {
            //     System.out.println(n + " = " + (n - lastPrime) + " + " + lastPrime);
            // }
        }

    }
}
