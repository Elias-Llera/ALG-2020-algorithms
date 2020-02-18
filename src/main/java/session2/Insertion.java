package session2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the DIRECT INSERTION */
public class Insertion extends Vector {

	public Insertion(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		boolean change;
		for (int i = 1; i < elements.length; i++) {
			int pivot = elements[i];
			for (int j = i - 1; j >= 0; j--) {
				change = false;
				if (pivot < elements[j]) {
					interchange(j + 1, j);
					change = true;
				}
				if (!change)
					break;
			}
		}
	}

	@Override
	public String getName() {
		return "Insertion";
	}
}
