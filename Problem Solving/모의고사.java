import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        
        int[] a1 = {1, 2, 3, 4, 5}; // 5
        int[] a2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] a3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        for(int i=0; i<answers.length; i++) {
            int i1 = i%5;
            int i2 = i%8;
            int i3 = i%10;
            
            if(answers[i] == a1[i1])
                score[0]++;
            if(answers[i] == a2[i2])
                score[1]++;
            if(answers[i] == a3[i3])
                score[2]++;
        }
        
        int max = 0;
        for(int i=0; i<score.length; i++) {
            if(max < score[i])
                max = score[i];
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i=0; i<score.length; i++) {
            if(max == score[i]) {
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}