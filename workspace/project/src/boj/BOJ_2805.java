package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805 {

    static int numberOfTrees, requiredLength;
    static int[] lengthOfTrees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        numberOfTrees = Integer.parseInt(stk.nextToken());
        requiredLength = Integer.parseInt(stk.nextToken());

        lengthOfTrees = new int[numberOfTrees];

        stk = new StringTokenizer(br.readLine());
        int index = 0;
        int max = 0;
        while (stk.hasMoreTokens()) {
            lengthOfTrees[index] = Integer.parseInt(stk.nextToken());
            max = Math.max(max, lengthOfTrees[index]);
            index++;
        }

        System.out.println(binarySearch(max));
    }

    public static int binarySearch(int max) {
        int low = 1;
        int high = max;

        while (low <= high) {
            int mid = (low+high) / 2;
            long sum = calculateResult(mid);

            if(sum < requiredLength) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }

        return high;
    }

    public static long calculateResult(int height) {
        long sum = 0;
        for(int i=0; i<lengthOfTrees.length; i++) {
            if(lengthOfTrees[i] > height) {
                long piece = lengthOfTrees[i] - height;
                sum += piece;
            }
        }
        return sum;
    }
}
