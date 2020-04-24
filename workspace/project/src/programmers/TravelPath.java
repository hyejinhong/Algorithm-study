package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TravelPath {

	static boolean[] visited;
	static String path = "";
	static ArrayList<String> results = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[][] tickets = {
//				{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}
//		};

		String[][] tickets = {
				{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},
				{"ATL", "ICN"}, {"ATL", "SFO"}
		};

		System.out.println(Arrays.toString(solution(tickets)));
	}
	
	public static String[] solution(String[][] tickets) {
		// init
		visited = new boolean[tickets.length];
		for(int i=0; i<tickets.length; i++) {
			Arrays.fill(visited, false);
			String to = tickets[i][0];
			String from = tickets[i][1];
			
			// 출발이 ICN인 경우
			if(to.equals("ICN")) {
				path = to + ",";
				visited[i] = true;
				dfs(tickets, from, 1);
			}
		}
		
		Collections.sort(results);
		String[] answer = results.get(0).split(",");
		return answer;
	}
	
	public static void dfs(String[][] tickets, String from, int count) {
		path += from + ",";
		
		// 기저: 모든 티켓을 사용함
		if(count == tickets.length) {
			results.add(path);
			return;
		}
		
		for(int i=0; i<tickets.length; i++) {
			String t = tickets[i][0];
			String f = tickets[i][1];
			
			// 이 티켓의 출발지가 지금 있는 곳이고, 도착지는 아직 안 간 곳이라면
			if(t.equals(from) && !visited[i]) {
				// 백트래킹
				visited[i] = true;
				
				dfs(tickets, f, count+1);
				
				visited[i] = false;
				path = path.substring(0, path.length()-4);
			}
		}
		
	}
}
