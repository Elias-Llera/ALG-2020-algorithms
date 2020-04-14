package session7.pyramid;

import java.util.ArrayList;
import java.util.UUID;

import session7.utils.BranchAndBound;
import session7.utils.Node;

/**
 * To solve the Pyramid Puzzle Instructions at
 * http://www2.stetson.edu/~efriedma/puzzle/pyramid/
 */
public class PyramidPuzzle extends BranchAndBound {
	/**
	 * Constructor for Pyramid Puzzle objects
	 * 
	 * @param board Representation of the board for playing the puzzle
	 */
	public PyramidPuzzle(PyramidBoard board) {
		rootNode = board; // we create the puzzle to start playing
	}
}

/***************************************************/
/***************************************************/

@SuppressWarnings("unused")
class PyramidBoard extends Node {
	private int[][] board; // board for playing
	private int row; // current row of this board
	private int column; // current column of this board
	private static int[][] correspondenceBoard; // board to save the correspondences between cells that should be equal
												// (different colors)
	private static boolean[][] fixedBoard; // to know which elements are fixed and cannot change
	private static int n; // size of the side of the board to save the pyramid

	/**
	 * Constructor for Pyramid puzzle objects (root node)
	 * 
	 * @param n Size of the board
	 */
	public PyramidBoard(int n) { // Generates an empty board
		PyramidBoard.n = n;
		correspondenceBoard = new int[n][n];
		fixedBoard = new boolean[n][n];
		board = new int[n][n];
		row = n - 1;
		column = n - 1;
	}

	/**
	 * SAME AS BACKTRACKING Inserts the values of a line from the pyramid It is call
	 * once per every row of the pyramid to initialize all the values
	 * 
	 * @param values Values of a row of the pyramid
	 * @param row    Number of the current row
	 */
	public void insertValues(String[] values, int row) {
		for (int i = 0; i < row + 1; i++) { // in row 0, 1 value; in row 1, 2 values...
			if (values[i].equals("*"))
				board[row][i] = 0;
			else if (values[i].equals("R")) { // red
				board[row][i] = -1;
				correspondenceBoard[row][i] = -1;
			} else if (values[i].equals("B")) { // blue
				board[row][i] = -2;
				correspondenceBoard[row][i] = -2;
			} else if (values[i].equals("Y")) { // yellow
				board[row][i] = -3;
				correspondenceBoard[row][i] = -3;
			} else { // it is a number
				board[row][i] = Integer.parseInt(values[i]);
				fixedBoard[row][i] = true;
			}
		}
	}

	/**
	 * SAME AS PRINTBOARD() FROM BACKTRACKING
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int k = i; k < n; k++) {
				sb.append(" "); // white spaces to create the pyramid
			}
			for (int j = 0; j <= i; j++) {
				if (board[i][j] == 0) // empty
					sb.append("* ");
				else if (board[i][j] == -1)
					sb.append("R ");
				else if (board[i][j] == -2)
					sb.append("B ");
				else if (board[i][j] == -3)
					sb.append("Y ");
				else
					sb.append(board[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Counts the number of blanks and pairs that are not filled yet
	 */
	@Override
	public void calculateHeuristicValue() {
		int counter = 0;
		if (prune()) {
			heuristicValue = Integer.MAX_VALUE;
		} else {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (board[i][j] < 1) {
						counter++;
					}
				}
			}
			heuristicValue = counter;
		}
	}

	/**
	 * SAME AS PRUNE() FROM BACKTRACKING Checks if we should prune when the
	 * conditions are not longer met
	 * 
	 * @return True if we should prune. False otherwise
	 */
	private boolean prune() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j <= i; j++) {
				if (board[i][j] > 0 && board[i + 1][j] > 0 && board[i + 1][j + 1] > 0) {
					boolean valid = false;
					if (board[i][j] == board[i + 1][j] + board[i + 1][j + 1])
						valid = true;
					else if (board[i][j] == board[i + 1][j] - board[i + 1][j + 1])
						valid = true;
					else if (board[i][j] == board[i + 1][j + 1] - board[i + 1][j])
						valid = true;
					if (!valid)
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isSolution() {
		return getHeuristicValue() == 0;
	}

	/**
	 * To get the children of the current node. They point to their parent through
	 * the parentID
	 */
	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> result = new ArrayList<Node>();
		int[][] testBoard;
		PyramidBoard temp;

		int nextRow, nextColumn;
		if (column - 1 < 0) {
			nextRow = row - 1;
			nextColumn = nextRow;
		} else {
			nextRow = row;
			nextColumn = column - 1;
		}

		while (nextRow >= 0 && nextColumn >= 0 && notToChange(nextRow, nextColumn)) {
			if (nextColumn - 1 < 0) {
				nextRow--;
				nextColumn = nextRow;
			} else {
				nextColumn--;
			}
		}

		for (int k = 1; k < 10; k++) {
			testBoard = copyBoard(row, column, k);
			temp = new PyramidBoard(testBoard, depth + 1, this.getID(), nextRow, nextColumn);
			result.add(temp);
		}
		return result;
	}

	/**
	 * SAME AS BACKTRACKING Checks if the current position cannot be changed: 1-
	 * Because it is a fixed number (cell/position) 2- Because it is the first
	 * occurrence (from top to down) of a pair of the same color. In that latter
	 * case, we only changed one of the two to make it consistent. The one that is
	 * changed is the second occurrence (from top to down) that happens to be the
	 * first that is found since we start on the right-down corner of the pyramid
	 * 
	 * @param row    Current row
	 * @param column Current column
	 * @return True if we cannot change a specific position. False otherwise
	 */
	private boolean notToChange(int row, int column) {
		// we should not change the value if it is fixed
		if (fixedBoard[row][column])
			return true; // we cannot change it

		// we should not change the value if it is the first of a color pair
		int color = correspondenceBoard[row][column]; // if it is -1 (red), -2 (blue), -3 (yellow) we need to check it
		if (color < 0) {
			int[] firstPosition = firstPositionColor(color);
			if (firstPosition[0] == row && firstPosition[1] == column)
				return true;
		}

		return false;
	}

	/**
	 * SAME AS BACKTRACKING Returns the position of the first appearance of a
	 * specific color They always appear in pairs in the pyramid
	 * 
	 * @param color Color that we are looking (-1 => red, -2 => blue, -3 => yellow)
	 * @return Row and column of the first appearance of a color pair
	 */
	private int[] firstPositionColor(int color) {
		int[] result = new int[2]; // row, column

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (correspondenceBoard[i][j] == color) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	private int[][] copyBoard(int row, int column, int k) {
		int[][] newBoard = new int[n][n];

		for (int i = 0; i < n; i++)
			for (int j = 0; j <= i; j++)
				newBoard[i][j] = board[i][j];

		newBoard[row][column] = k;
		checkIfItHasACorrespondenceColor(row, column, k, newBoard); // if so, we should change also the value of the
																	// first occurrence

		return newBoard;
	}

	/**
	 * SAME AS BACKTRACKING EXCEPT BECAUSE WE PASS AS A PARAMETER THE NEWBOARD WE
	 * CREATE TO EXPAND THE CHILDREN Checks if we are dealing with the second
	 * occurrence of a color. If we change it, we also should change the first
	 * occurrence to make it consistent
	 * 
	 * @param row    Current row
	 * @param column Current column
	 * @param value  The value we want to introduce
	 */
	private void checkIfItHasACorrespondenceColor(int row, int column, int value, int[][] board) {
		int color = correspondenceBoard[row][column];
		if (color < 0) {
			int[] firstPosition = firstPositionColor(color);
			if (firstPosition[0] != row || firstPosition[1] != column) {
				// there is a first occurrence of this color, so we should also change it
				board[firstPosition[0]][firstPosition[1]] = value;
			}
		}
	}

	/**
	 * Constructor for Pyramid puzzle objects (children of the root node)
	 * 
	 * @param board
	 * @param depth
	 * @param parentID
	 */
	public PyramidBoard(int[][] board, int depth, UUID parentID, int row, int column) {
		this.board = board;
		this.depth = depth;
		this.parentID = parentID;
		this.row = row;
		this.column = column;
		calculateHeuristicValue();
	}

}
