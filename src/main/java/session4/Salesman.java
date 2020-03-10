package session4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Salesman {
	private int nNodes; // number of nodes of the graph
	private int[][] matrix; // graph adjacency matrix
	private int[] sol; // solution path from the source node to the source node again

	public static void main(String[] args) {
	}

	/**
	 * Constructor that loads the graph from a file
	 * 
	 * @param fileName File name in which the data is contained
	 */
	public Salesman(String fileName) {
		matrix = createMatrixFromFile(fileName);
		sol = new int[nNodes + 1]; // the last movement to the source
	}

	/**
	 * Constructor that creates a random graph
	 * 
	 * @param nNodes Number of nodes of the graph
	 * @param max    Maximum value for the random values (weights)
	 */
	public Salesman(int nNodes, int max) {
		this.nNodes = nNodes;
		matrix = createMatrix(nNodes, max);
		sol = new int[nNodes + 1]; // the last movement to the source
	}

	/**
	 * It generates a symmetrical triangular matrix with respect to the main
	 * diagonal.
	 * 
	 * @param size Size of the matrix
	 * @param max  Maximum value for the random values (weights)
	 **/
	private int[][] createMatrix(int size, int max) {
		int[][] elements = new int[size][size];
		Random r = new Random();

		// we create a symmetric array for an adjacency matrix of an undirected graph
		for (int i = 0; i < size; i++)
			for (int j = i; j < size; j++)
				if (i == j)
					elements[i][j] = Integer.MAX_VALUE; // there is no path
				else {
					elements[i][j] = r.nextInt(max) + 1; // values between 1 and max
					elements[j][i] = elements[i][j];
				}
		return elements;
	}

	/**
	 * Load the integer array values from a file
	 * 
	 * @param fileName File name in which the data is contained
	 **/
	private int[][] createMatrixFromFile(String fileName) {
		BufferedReader file = null;
		String line;
		int[][] elements = null;

		try {
			// we open the text file
			file = new BufferedReader(new FileReader(fileName));
			line = file.readLine();
			// the first line contains the number of elements
			nNodes = Integer.parseInt(line);
			// we create a matrix of the corresponding size
			elements = new int[nNodes][nNodes];
			for (int i = 0; i < nNodes; i++) {
				line = file.readLine();
				String values[] = line.split("\t");
				for (int j = 0; j < nNodes; j++) {
					elements[i][j] = Integer.parseInt(values[j]);
					if (elements[i][j] == 0)
						elements[i][j] = Integer.MAX_VALUE; // there is no path
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + fileName);
		} catch (IOException e) {
			System.out.println("File reading error: " + fileName);
		}
		return elements;
	}

	/**
	 * Prints the matrix with the costs from the graph
	 */
	public void printMatrix() {
		for (int i = 0; i < nNodes; i++) {
			for (int j = 0; j < nNodes; j++) {
				if (matrix[i][j] == Integer.MAX_VALUE)
					System.out.print("INF\t");
				else
					System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Prints the solution path
	 */
	public void printSolution() {
		for (int i = 0; i < sol.length; i++) {
			System.out.print(sol[i]);
			if (i < sol.length - 1)
				System.out.print(" -> ");
		}
		System.out.println("\n");
	}

	/**
	 * Calculate the Hamilton cycle. The heuristic is to get the lowest cost edge
	 * from current node to one of the no connected nodes
	 * 
	 * @param sourceNode The starting node
	 * @return The cost of the cycle from the source to itself iterating through all
	 *         the other nodes once
	 */
	public int greedy1(int sourceNode) {
		int result = 0, currentNode, minEdge;

		ArrayList<Integer> visited = new ArrayList<Integer>();
		visited.add(sourceNode);

		while (visited.size() < nNodes) {
			currentNode = visited.get(visited.size() - 1);
			minEdge = 0;	//this cannot be initialized at 0 pedazo de subnormal
			for (int j = 0; j < nNodes; j++) {
				if (matrix[currentNode][j] < matrix[currentNode][minEdge] && !visited.contains(j))
					minEdge = j;
			}
			visited.add(minEdge);
			result+=matrix[currentNode][minEdge];
		}
		
		result+= matrix[visited.get(visited.size()-1)][sourceNode];
		visited.add(sourceNode);
		
		for (int i = 0; i < visited.size(); i++) {
			sol[i] = visited.get(i);
		}
		
		return result;
	}

	/**
	 * Calculate the Hamilton cycle. The heuristic is to get the lowest cost edge of
	 * the whole graph, checking that no node has more than two edges, and that no
	 * cycles are created until the end
	 * 
	 * @return The cost of the cycle from the source to itself iterating through all
	 *         the other nodes once
	 */
	public int greedy2() {
		// TODO
		return 0;
	}

	/**
	 * Returns the array with the solution calculated with greedy1 or greedy2
	 * 
	 * @return Array with the solution path
	 */
	public int[] getSol() {
		return sol;
	}

}
