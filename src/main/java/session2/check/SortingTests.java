package session2.check;

import session2.Bubble;
import session2.Insertion;
import session2.QuicksortCentralElement;
import session2.QuicksortFateful;
import session2.QuicksortMedianOfThree;
import session2.Selection;
import session2.Vector;

public class SortingTests {

	/** This program is used to check that sorting algorithms are working
	 * */
	public static void main(String arg []) {
		int n = 8;  //problem size
		
//		testSortingAlgorithm(new Insertion(n));
//		
//		testSortingAlgorithm(new Selection(n));
		
//		testSortingAlgorithm(new Bubble(n));
		
//		testSortingAlgorithm(new QuicksortFateful(n));
//		
		testSortingAlgorithm(new QuicksortCentralElement(n));
//		
//		testSortingAlgorithm(new QuicksortMedianOfThree(n));
	}
	
	public static void testSortingAlgorithm(Vector v) {
		System.out.println("\n\nSorting test: "+ v.getName());
		
		System.out.println("Sorting an already-sorted vector");
		v.directlySorted();
		System.out.println("Vector to be sorted:");
		v.write(System.out);	
		v.sort();
		System.out.println("Sorted vector");
		v.write(System.out);

		System.out.println("Sorting an inverse vector");
		v.inverselySorted();
		System.out.println("Vector to be sorted:");
		v.write(System.out);	
		v.sort();
		System.out.println("Sorted vector");
		v.write(System.out);

		System.out.println("Sorting a random vector");
		v.randomlySorted();
		System.out.println("Vector to be sorted:");
		v.write(System.out);	
		v.sort();
		System.out.println("Sorted vector");
		v.write(System.out);
	}
	
}
