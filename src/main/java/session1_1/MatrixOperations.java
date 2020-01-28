package session1_1;

public class MatrixOperations {

	private int[][] matrix;

	public MatrixOperations(int n) {
		matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
	}

	public MatrixOperations(String filename) {

	}

	public int getSize() {
		return matrix.length;
	}

	public void write() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("     ");
			}
			System.out.println();
		}
	} 

	public int sumDiagonal1() {
		int addition = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) {
					addition += matrix[i][j];
				}
			}
		}
		return addition;
	}

	public int sumDiagonal2() {
		int addition = 0;
		for (int i = 0; i < matrix.length; i++) {
			addition += matrix[i][i];
		}
		return addition;
	}

	public void travelPath(int i, int j) {
		int numOfMoves = 0;
		while (i >= 0 && j >= 0 && i < getSize() && j < getSize()) {
			switch (matrix[i][j]) {
			case 1:
				i--;
			case 2:
				j++;
			case 3:
				i++;
			case 4:
				j--;
			default:
				break;
			}
			numOfMoves++;
		}
		write();
		System.out.println();
		System.out.println("Number of movements = " + numOfMoves);
	}

}
