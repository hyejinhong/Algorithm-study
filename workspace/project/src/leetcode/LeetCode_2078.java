package leetcode;

public class LeetCode_2078 {
    public static void main(String[] args) {

//        int[] colors = { 1, 1, 1, 6, 1, 1, 1 };
//        int[] colors = { 1, 8, 3, 8, 3 };
        int[] colors = { 0, 1 };

        System.out.println(solution(colors));
    }

    public static int solution(int[] colors) {
        int max = 0;

        for(int std=0; std<colors.length; std++) {
            int target = std+1;
            while(target < colors.length) {
                // 색 같으면
                if(colors[std] == colors[target]) {
                    target++;
                }

                // 색 다르면 거리 갱신
                else {
                    max = Math.max(max, Math.abs(target-std));
                    target++;
                }
            }
        }

        return max;
    }
}
