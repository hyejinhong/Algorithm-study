package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class WordChain_Fail {

	static int n;
	static String[] words = new String[101];
	
	static int[][] adj;
	static int[] indegree;
	static int[] outdegree;
	static String[][][] graph;
	static int[][] pointer;
//	= {
//			{{"aaa", "aba", "aca"}, {"aab", "abb", "acb"} },
//			{}
//	};
//	static ArrayList<ArrayList<ArrayList<String>>> graph;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		for(int test=1; test<=c; test++) {
			n = Integer.parseInt(br.readLine());
			
			for(int i=0; i<n; i++) {
				words[i] = br.readLine();
			}
			System.out.println(solve());
		}
	}
	
	public static String solve() {
		makeGraph();
		
		// 차수가 맞지 않으면 실패
		if(!checkEuler()) {
			return "IMPOSSIBLE";
		}
		
		// 오일러 서킷이나 경로를 찾아낸다
		ArrayList<Integer> circuit = getEulerTrailOrCircuit();
		
		// 모든 간선을 방문하지 못했으면 실패
		if(circuit.size() != n) {
			return "IMPOSSIBLE";
		}
		
		// 아닌 경우 방문 순서를 뒤집은 간선들을 모아 문자열로 만들어 반환한다
		Collections.reverse(circuit.subList(0, circuit.size()));
		String ret = "";
		
		for(int i=1; i<circuit.size(); i++) {
			int a = circuit.get(i-1);
			int b = circuit.get(i);
			
			if(ret.length() != 0) {
				ret += " ";
			}
			ret += graph[a][b][--pointer[a][b]];
			pointer[a][b]--;
		}
		
		return ret;
	}
	
	public static void makeGraph() {
		adj = new int[26][26];
		indegree = new int[26];
		outdegree = new int[26];
		graph = new String[26][26][100];
		pointer = new int[26][26];
//		graph = {
//				{"ada"}
//		};
//		graph = new ArrayList<>();
		
		// 각 단어를 그래프에 추가한다.
		for(int i=0; i<n; i++) {
			// 첫 글자, 마지막 글자
			int a = words[i].charAt(0) - 'a';
			int b = words[i].charAt(words[i].length()-1) -'a';
//			graph.get(a).add(words[i]);
			graph[a][b][pointer[a][b]++] = words[i];
			adj[a][b]++;
			outdegree[a]++;
			indegree[b]++;
			
		}
	}
	
	// 오일러 서킷 혹은 트레일을 계산한다.
	public static void getEulerCircuit(int here, ArrayList<Integer> circuit) {
		for(int there=0; there<adj.length; there++) {
			while(adj[here][there] > 0) {
				adj[here][there]--;
				getEulerCircuit(there, circuit);
			}
		}
		circuit.add(here);
	}

	// 현재 그래프의 오일러 트레일이나 서킷을 반환한다
	public static ArrayList<Integer> getEulerTrailOrCircuit() {
		ArrayList<Integer> circuit=  new ArrayList<>();
		
		// 우선 트레일을 찾아본다: 시작점이 존재하는 경우
		for(int i=0; i<26; i++) {
			if(outdegree[i] == indegree[i]+1) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		
		// 아니면 서킷이니, 간선에 인접한 아무 정점에서나 시작한다.
		for(int i=0; i<26; i++) {
			if(outdegree[i] != 0) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		
		// 모두 실패한 경우 빈ㅂ ㅐ열을 반환한다
		return circuit;
	}
	
	// 현재 그래프의 오일러 서킷/트레일 존재 여부를 확인한다
	public static boolean checkEuler() {
		// 예비 시작점과 끝점의 수
		int plus1 = 0;
		int minus1 = 0;
		
		for(int i=0; i<26; i++) {
			int delta = outdegree[i] - indegree[i];
			
			// 모든 정점의 차수는 -1, 1, 또는 0이어야 한다.
			if(delta < -1 || delta > 1) {
				return false;
			}
			if(delta == 1) {
				plus1++;
			}
			if(delta == -1) {
				minus1++;
			}
		}
		
		// 시작점과 끝점은 각 하나씩 있거나 하나도 없어야 한다
		return (plus1 == 1 && minus1 == 1) || (plus1 == 0 && minus1 == 0);
	}
}
