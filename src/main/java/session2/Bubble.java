package session2;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the BUBBLE or DIRECT EXCHANGE */
public class Bubble extends Vector {
	public Bubble(int nElements) {
		super(nElements);
	}

	@Override
	public void sort() {
		boolean change ;
		for (int i = 0; i < elements.length - 1; i++) {
			change = false;
			for (int j = elements.length - 1; j > i; j--) {
				if (elements[j - 1] > elements[j]) {
					interchange(j - 1, j);
					change = true;
				}
			}
			if(!change) return;
		}
	}

	@Override
	public String getName() {
		return "Bubble";
	}

}
