package session7.boggle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import session7.utils.BranchAndBound;
import session7.utils.Node;

public class Boggle extends BranchAndBound{
	public Boggle(BoggleBoard board) {
		rootNode = board;
	}
}

class BoggleBoard extends Node {
	
	final static int FOUND = 0;
	final static int NOT_FOUND = 1;
	final static int IMPOSSIBLE_WORD = 2;
	final static int[] POINTS = new int[] { 0, 0, 1, 2, 5, 7, 9, 12, 15, 19, 24 };
	
	private char[][] board;
	private int[][] visited;
	private static int[] movementI = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	private static int[] movementJ = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };
	private static int maxWordRepetitions;
	private static int maxTimesVisited;
	private static ArrayList<String> dictionary;
	private static Hashtable<Character, Integer> indexes = new Hashtable<Character, Integer>();
	private static HashSet<String> impossibleCombinations = new HashSet<String>();
	
	private HashSet<String> solutions = new HashSet<String>();
	private String word;
	private int i, j;
	private int searchResult;
	private long points;
	
	public BoggleBoard(String dictionaryFile, String boardFile, int allowedWordRepetitions, int allowedVisits) { // Generates an empty board
		readDictionaryFromFile(dictionaryFile);
		readTableFromFile(boardFile);
		visited = new int[board.length][board[0].length];
		maxWordRepetitions = allowedWordRepetitions;
		maxTimesVisited = allowedVisits;
	}
	
	public BoggleBoard(char[][] board, int[][] visited, String word, int depth, UUID parentID) {
		this.board = board;
		this.visited = visited;
		this.word = word;
		this.depth = depth;
		this.parentID = parentID;
		calculateHeuristicValue();
	}
	
	public List<String> getSolutions() {
		ArrayList<String> list = new ArrayList<String>(solutions);
		Collections.sort(list);
		return list;
	}

	public long getTotalPoints() {
		return points;
	}

	public void printTable() {
		for (char[] row : board) {
			for (Character c : row) {
				System.out.print(c + "\t");
			}
			System.out.println();
		}
	}

	public void printSolutions() {
		for (String s : solutions) {
			System.out.println(s);
		}
	}	

	private void search() {
		char startingLetter = word.charAt(0);

		if (!indexes.containsKey(startingLetter) || impossibleCombinations.contains(word)) { // There is no word
																								// starting with that
																								// letter
			searchResult = IMPOSSIBLE_WORD;
			return;
		}

		int startPosition = indexes.get(startingLetter); // index of the starting letter of the word

		for (int i = startPosition; i < dictionary.size(); i++) {
			if (dictionary.get(i).charAt(0) != word.charAt(0)) {
				break;
			}
			if (dictionary.get(i).compareTo(word) == 0) { // word found
				searchResult = FOUND;
				return;
			} else if (dictionary.get(i).startsWith(word)) { // We did not find a word, but it may exist
				searchResult = NOT_FOUND;
				return;
			}
		}
		impossibleCombinations.add(word);
		searchResult = IMPOSSIBLE_WORD;
		return;
	}

	@Override
	public void calculateHeuristicValue() {
		if (prune()) {
			heuristicValue = Integer.MAX_VALUE;
		} else {
			throw new UnsupportedOperationException("Not herusistic value asigned yet");
		}
	}
	
	boolean prune() {
		return searchResult == IMPOSSIBLE_WORD;
	}

	@Override
	public ArrayList<Node> expand() {
		ArrayList<Node> result = new ArrayList<Node>();
		BoggleBoard temp;
		
		for (int k = 0; k <= 7; k++) {
			int u = i + movementI[k];
			int v = j + movementJ[k];
			if (u >= 0 && u < board.length && v >= 0 && v < board.length && visited[u][v]<maxTimesVisited) {
				visited[u][v]++;
				temp = new BoggleBoard(board, visited, word, ++depth, parentID);
				result.add(temp);
			}
		}
		
		return result;
	}

	@Override
	public boolean isSolution() {
		return i == board.length-1 && j == board[0].length-1 && word == "";
	}

	private void readDictionaryFromFile(String fileName) {
		dictionary = new ArrayList<String>();
		BufferedReader reader = null;
		String line;
		char letter = 0;
		int position = 0;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			while (reader.ready()) {
				line = reader.readLine().toLowerCase();
				if (line.charAt(0) != letter) { // first letter is different
					letter = line.charAt(0); // update the current letter
					indexes.put(letter, position); // add the index of the new letter
				}
				dictionary.add(line); // add word to dictionary
				position++;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void readTableFromFile(String fileName) {
		String line;
		String[] chars;
		int size;
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			size = Integer.parseInt(reader.readLine());
			board = new char[size][size];
			for (int i = 0; i < board.length; i++) {
				line = reader.readLine();
				chars = line.split(" ");
				for (int j = 0; j < chars.length; j++) {
					board[i][j] = Character.toLowerCase(chars[j].charAt(0));
				}
			}
			reader.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
//	private void createRandomTable(int size) {
//		board = new char[size][size];
//		for (int i = 0; i < board.length; i++) {
//			for (int j = 0; j < board.length; j++) {
//				board[i][j] = (char) (new Random().nextInt(26) + 'a');
//			}
//		}
//	}
	
}