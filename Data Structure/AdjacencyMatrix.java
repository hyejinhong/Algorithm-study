
public class AdjacencyMatrix {

	int[][] matrix;
	
	public AdjacencyMatrix(int size) {
		this.matrix = new int[size][size];
	}
	
	public void put(int x, int y, int value) {
		matrix[x][y] = value;
		matrix[y][x] = value;
	}
	
	public void print() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjacencyMatrix matrix = new AdjacencyMatrix(4);
		matrix.put(0, 1, 5);
		matrix.put(1, 2, 2);
		matrix.put(2, 3, 4);
		matrix.put(3, 0, 8);
		
		matrix.print();
	}

}
