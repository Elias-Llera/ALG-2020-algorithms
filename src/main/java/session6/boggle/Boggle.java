package session6.boggle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Boggle {

	final static int FOUND = 0;
	final static int NOT_FOUND = 1;
	final static int IMPOSSIBLE_WORD = 2;
	final static int[] POINTS = new int[] { 0, 0, 1, 2, 5, 7, 9, 12, 15, 19, 24 };

	char[][] table;
	boolean[][] visited;
	int[] movementI = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };
	int[] movementJ = new int[] { 1, 1, 0, -1, -1, -1, 0, 1 };
	HashSet<String> solutions = new HashSet<String>();
	HashSet<String> impossibleCombinations = new HashSet<String>();
	ArrayList<String> dictionary;
	Hashtable<Character, Integer> indexes = new Hashtable<Character, Integer>();
	long points;
	String word;

	public Boggle(String dictionaryFileName, String tableFileName) {
		readDictionaryFromFile(dictionaryFileName);
		readTableFromFile(tableFileName);
		visited = new boolean[table.length][table[0].length];
	}

	public Boggle(String dictionaryFileName, int tableSize) {
		readDictionaryFromFile(dictionaryFileName);
		createRandomTable(tableSize);
		visited = new boolean[table.length][table[0].length];
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
		for (char[] row : table) {
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

	public void findSolutions() {
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				visited[i][j] = true;
				word = "" + table[i][j];
				backtracking(0, i, j);
				visited[i][j] = false;
			}
		}
	}

	private void backtracking(int level, int i, int j) {
		int search = search();
		if (search == FOUND && !solutions.contains(word)) {
			solutions.add(word);
			points += POINTS[word.length()];
		} else if (search == IMPOSSIBLE_WORD) {
			return;
		}
		for (int k = 0; k <= 7; k++) {
			int u = i + movementI[k];
			int v = j + movementJ[k];
			if (u >= 0 && u < table.length && v >= 0 && v < table.length && !visited[u][v]) {
				visited[u][v] = true;
				word += table[u][v];
				backtracking(level + 1, u, v);
				visited[u][v] = false;
				word = word.substring(0, word.length() - 1);
			}
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
			table = new char[size][size];
			for (int i = 0; i < table.length; i++) {
				line = reader.readLine();
				chars = line.split(" ");
				for (int j = 0; j < chars.length; j++) {
					table[i][j] = Character.toLowerCase(chars[j].charAt(0));
				}
			}
			reader.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
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

	private void createRandomTable(int size) {
		table = new char[size][size];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table.length; j++) {
				table[i][j] = (char) (new Random().nextInt(26) + 'a');
			}
		}
	}

	private int search() {
		char startingLetter = word.charAt(0);

		if (!indexes.containsKey(startingLetter) || impossibleCombinations.contains(word)) { // There is no word
																								// starting with that
																								// letter
			return IMPOSSIBLE_WORD;
		}

		int startPosition = indexes.get(startingLetter); // index of the starting letter of the word

		for (int i = startPosition; i < dictionary.size(); i++) {
			if (dictionary.get(i).charAt(0) != word.charAt(0)) {
				break;
			}
			if (dictionary.get(i).compareTo(word) == 0) { // word found
				return FOUND;
			} else if (dictionary.get(i).startsWith(word)) { // We did not find a word, but it may exist
				return NOT_FOUND;
			}
		}
		impossibleCombinations.add(word);
		return IMPOSSIBLE_WORD;
	}

}
