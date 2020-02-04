package session1_1;

public class MainMatrix {

	public static void main(String[] args) {
		MatrixOperations mo = new MatrixOperations(4);
		mo.write();
		System.out.println(mo.sumDiagonal1());
		System.out.println(mo.sumDiagonal2());
		mo.travelPath(0, 0);
	}

}
