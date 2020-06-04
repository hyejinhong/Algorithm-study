package programmers;

import java.util.Arrays;

public class LongJump {

    static final int MOD = 1234567;
    static long[] cache = new long[2001];
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = { 4, 3 };
		for(int i=0; i<n.length; i++) {
			System.out.println(solution(n[i]));
		}
	}

    public static long solution(int n) {
        Arrays.fill(cache, -1);
        
        long answer = jump(n);
        return answer;
    }
    
    // n칸을 뛸 수 있는 방법의 수 반환
    public static long jump(int n) {
        // 기저
        if(n == 1 || n == 2) {
            return n;
        }
        
        // 캐시 있으면
        if(cache[n] != -1) {
            return cache[n];
        }
        
        // 캐시 없으면 계산
        // 점화식: jump(n) = jump(n-1) + jump(n-2)
        long ret = jump(n-1) + jump(n-2);
        ret %= MOD;
        cache[n] = ret;
        return ret;
    }
}
