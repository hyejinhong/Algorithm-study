import java.util.ArrayList;

public class AdjacencyList {
	
	class Edge {
		int node;
		int value;
		
		public Edge(int node, int value) {
			this.node = node;
			this.value = value;
		}
	}
	
	ArrayList<ArrayList<Edge>> list;
	
	public AdjacencyList(int size) {
		this.list = new ArrayList<ArrayList<Edge>>();
		
		for(int i=0; i<size; i++) {
			this.list.add(new ArrayList<Edge>());
		}
	}
	
	public void put(int x, int y, int value) {
		list.get(x).add(new Edge(y, value));
		list.get(y).add(new Edge(x, value));
	}
	
	public void print() {
		for(int i=0; i<list.size(); i++) {
			System.out.print("["+ i +"]");
			for(int j=0; j<list.get(i).size(); j++) {
				Edge edge = list.get(i).get(j);
				System.out.print(" -> [" + edge.node + "|" + edge.value +"]");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyList list = new AdjacencyList(4);
		list.put(0, 1, 5);
		list.put(1, 2, 2);
		list.put(2, 3, 4);
		list.put(3, 0, 8);
		
		list.print();
	}

}
