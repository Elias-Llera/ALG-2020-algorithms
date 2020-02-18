package session2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the SELECTION */
public class Selection extends Vector {
	public Selection(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		for (int i = 0; i < elements.length; i++) {
			int min = i;
			for (int j = i + 1; j < elements.length - 1; j++) {
				if (elements[j] < elements[min]) {
					min = j;
				}
			}
			interchange(i, min);
		}
	}

	@Override
	public String getName() {
		return "Selection";
	}
}
