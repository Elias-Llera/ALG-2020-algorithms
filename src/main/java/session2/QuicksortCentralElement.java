package session2;

/* This program can be used to sort n elements with 
 * the best algorithm. It is the QUICKSORT */
public class QuicksortCentralElement extends Vector {

	public QuicksortCentralElement(int nElements) {
		super(nElements);
	}

	private void quickSort(int left, int right) {
		int pivot = elements.length / 2;
		interchange(pivot, elements.length - 1);
		while (left < right && left < elements.length && right > 0) {
			if (elements[left] > elements[right]) {
				interchange(left, right);
			}
			left++;
			right--;
		}
		interchange(pivot, elements.length - 1);
		quickSort(0, pivot);
		quickSort(pivot, elements.length-1);
	}

	@Override
	public void sort() {
		quickSort(0, elements.length - 1);
	}

	@Override
	public String getName() {
		return "Quicksort - Central element";
	}
}
