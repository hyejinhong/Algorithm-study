package programmers;

public class 피로도 {
	
    boolean[] visited;
    int max = Integer.MIN_VALUE;
	
    public static void main(String[] args) {
    	피로도 instance = new 피로도();
    	int k = 80;
    	int[][] dungeons = {{80,20},{50,40},{30,10}};
    	System.out.println(instance.solution(k, dungeons));
	}

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];  
        
        for (int i=0; i<dungeons.length; i++) {
                dfs(k, i, 0, dungeons);
        }
        
        return max;
    }
    
    // p: 남은 피로도, index: 몇 번째 던전인지, count: 지금까지 탐험한 던전 수
    private void dfs(int p, int index, int count, int[][] dungeons) {
        max = Math.max(max, count);
        
        // 방문하지 않았던 던전 방문
        for (int i=0; i<dungeons.length; i++) {
            if (!visitable(p, index, dungeons))
                continue;
            
            // Go
            visited[index] = true;
            dfs(p-dungeons[index][1], i, count+1, dungeons);
                
            // Back
            visited[index] = false;
        }
    }
    
    private boolean visitable(int p, int index, int[][] dungeons) {
        // 방문한적 있음
        if (visited[index])
            return false;
        
        // 최소 필요 피로도가 모자람
        if (dungeons[index][0] > p)
            return false;
        
        // 소모 피로도가 모자람
        if (dungeons[index][1] > p)
            return false;
        
        return true;
    }
}
