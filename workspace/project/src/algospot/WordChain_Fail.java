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
		
		// ������ ���� ������ ����
		if(!checkEuler()) {
			return "IMPOSSIBLE";
		}
		
		// ���Ϸ� ��Ŷ�̳� ��θ� ã�Ƴ���
		ArrayList<Integer> circuit = getEulerTrailOrCircuit();
		
		// ��� ������ �湮���� �������� ����
		if(circuit.size() != n) {
			return "IMPOSSIBLE";
		}
		
		// �ƴ� ��� �湮 ������ ������ �������� ��� ���ڿ��� ����� ��ȯ�Ѵ�
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
		
		// �� �ܾ �׷����� �߰��Ѵ�.
		for(int i=0; i<n; i++) {
			// ù ����, ������ ����
			int a = words[i].charAt(0) - 'a';
			int b = words[i].charAt(words[i].length()-1) -'a';
//			graph.get(a).add(words[i]);
			graph[a][b][pointer[a][b]++] = words[i];
			adj[a][b]++;
			outdegree[a]++;
			indegree[b]++;
			
		}
	}
	
	// ���Ϸ� ��Ŷ Ȥ�� Ʈ������ ����Ѵ�.
	public static void getEulerCircuit(int here, ArrayList<Integer> circuit) {
		for(int there=0; there<adj.length; there++) {
			while(adj[here][there] > 0) {
				adj[here][there]--;
				getEulerCircuit(there, circuit);
			}
		}
		circuit.add(here);
	}

	// ���� �׷����� ���Ϸ� Ʈ�����̳� ��Ŷ�� ��ȯ�Ѵ�
	public static ArrayList<Integer> getEulerTrailOrCircuit() {
		ArrayList<Integer> circuit=  new ArrayList<>();
		
		// �켱 Ʈ������ ã�ƺ���: �������� �����ϴ� ���
		for(int i=0; i<26; i++) {
			if(outdegree[i] == indegree[i]+1) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		
		// �ƴϸ� ��Ŷ�̴�, ������ ������ �ƹ� ���������� �����Ѵ�.
		for(int i=0; i<26; i++) {
			if(outdegree[i] != 0) {
				getEulerCircuit(i, circuit);
				return circuit;
			}
		}
		
		// ��� ������ ��� �� ������ ��ȯ�Ѵ�
		return circuit;
	}
	
	// ���� �׷����� ���Ϸ� ��Ŷ/Ʈ���� ���� ���θ� Ȯ���Ѵ�
	public static boolean checkEuler() {
		// ���� �������� ������ ��
		int plus1 = 0;
		int minus1 = 0;
		
		for(int i=0; i<26; i++) {
			int delta = outdegree[i] - indegree[i];
			
			// ��� ������ ������ -1, 1, �Ǵ� 0�̾�� �Ѵ�.
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
		
		// �������� ������ �� �ϳ��� �ְų� �ϳ��� ����� �Ѵ�
		return (plus1 == 1 && minus1 == 1) || (plus1 == 0 && minus1 == 0);
	}
}