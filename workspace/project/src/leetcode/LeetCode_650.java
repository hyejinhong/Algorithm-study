package leetcode;

import java.util.Arrays;

public class LeetCode_650 {

    static boolean[] prime = new boolean[1001]; // true: 소수, false: 합성수
    static int[] cache = new int[1001];

    public static void main(String[] args) {
        Arrays.fill(prime, true);
        prime[1] = false;
        setPrime();

        System.out.println(copyAndPaste(27));
    }

    public static int copyAndPaste(int n) {
        if(n == 1)
            return 0;

        // 소수인 경우
        if(prime[n]) {
            // 1번 복사, n-1번 붙여넣기
            // (1+n-1)
            return n;
        }
        // 짝수인 경우
        else if(n%2 == 0) {
            // n/2를 복사 후 붙여넣기
            if(cache[n/2] != 0) {
                return cache[n/2] + 2;
            }

            cache[n] = copyAndPaste(n/2) + 2;
            return cache[n];
        }
        // 소수의 배수인 홀수
        else {
            // 이 수의 가장 큰 약수를 찾아야 함
            int factor = getMaxFactor(n);

            // 복사 -> 몫-1만큼 붙여넣기
            if(cache[factor] != 0)
                return cache[factor] + (n/factor-1) + 1;


            cache[n] = copyAndPaste(factor) + (n/factor-1) + 1;
            return cache[n];
        }
    }

    public static int getMaxFactor(int number) {
        for(int i=number-1; i>2 ;i--) {
            if(number%i == 0) {
                return i;
            }
        }
        return number;
    }

    public static void setPrime() {
        for(int i=2; i<Math.sqrt(1001); i++) {
            // 소수이면 배수 걸러줌
            if(prime[i]) {
                for(int j=i*2; j<Math.sqrt(1001); j+=i) {
                    prime[j] = false;
                }
            }
        }
    }
}
