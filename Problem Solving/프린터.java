import java.util.ArrayList;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        ArrayList<Integer> queue = new ArrayList<>();
        ArrayList<Boolean> myDocument = new ArrayList<>();
        
        for(int i=0; i<priorities.length; i++) {
            queue.add(priorities[i]);
            myDocument.add(false);
        }
        myDocument.set(location, true);
        
        while(queue.size() != 0) {
            int index = 0;
            for(int i=1; i<queue.size(); i++) {
                if(queue.get(0) < queue.get(i)) {
                    int value = queue.get(0);
                    queue.remove(0);
                    queue.add(value);
                    
                    boolean bValue = myDocument.get(0);
                    myDocument.remove(0);
                    myDocument.add(bValue);
                    break;
                }
                index = i;
            }
            if(index == queue.size() - 1) {
                answer++;
                
                if(myDocument.get(0)) {
                    // 내가 요청한 문서
                    return answer;
                }
                queue.remove(0);
                myDocument.remove(0);
            }
        }
        
        
        return answer;
    }
}