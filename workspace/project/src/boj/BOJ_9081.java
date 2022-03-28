package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9081 {

    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String input = br.readLine();
            char[] arr = input.toCharArray();

            // 모든 경우의 수를 다 만들고 찾으면 시간초과
            // 뒤에서부터 체크
            for(int j=arr.length-1; j>=0; j--) {
//                // 나랑 바꿀 글자 없음
//                if(j==0) {
//                    System.out.println(arr);
//                    break;
//                }
                // 내 앞에 있는 글자들 검사
                for(int k=j-1; k>=0; k--) {
                    // 내 앞 글자가 나보다 작으면 걔랑 자리 바꿔야됨
                    if(arr[j] > arr[k]) {
                        char temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                        // 자리 바꿨으면 뒤를 정렬
                        Arrays.sort(arr, k+1, arr.length);
                        j = -1;
                        break;
                    }
                }

            }
            System.out.println(arr);
        }
    }
}
