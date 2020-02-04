package session1_1;

public class MatrixOperations {

	private int[][] matrix;

	public MatrixOperations(int n) {
		matrix = new int[n][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 3) + 1;
			}
		}
	}

	public MatrixOperations(String filename) {
		matrix = FileUtil.loadMatrix(filename);
	}

	public int getSize() {
		return matrix.length;
	}

	public void write() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
				System.out.print("\t");
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
		boolean traversed = false;
		while (i >= 0 && j >= 0 && i < getSize() && j < getSize() && !traversed) {
			switch (matrix[i][j]) {
			case 1:
				matrix[i][j]=-1;
				i--;
				break;
			case 2:
				matrix[i][j]=-1;
				j++;
				break;
			case 3:
				matrix[i][j]=-1;
				i++;
				break;
			case 4:
				matrix[i][j]=-1;
				j--;
				break;
			default:
				traversed = true;
				break;
			}
			numOfMoves++;
		}
		write();
		System.out.println();
		System.out.println("Number of movements = " + numOfMoves);
	}

}
