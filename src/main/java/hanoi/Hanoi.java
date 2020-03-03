package hanoi;

import java.util.Stack;

public class Hanoi {

	/**
	 * si el numero de fichas es par -> empezamos con la segunda si el numero de
	 * fichas es impar -> empezamos con la tercera
	 * 
	 * construir la mas grande en la correspondiente construir la mas grande en la
	 * siguiente
	 * 
	 * para construir la mas grande: llamar recursivamente comprobando de nuevo el
	 * numero de fichas??
	 * 
	 * 
	 * caso base para construir la mas grande: mover uno directamente
	 */

	final static int BASE = Integer.MAX_VALUE;

	private Stack<Integer> ringsFirstPole;
	private Stack<Integer> ringsSecondPole;
	private Stack<Integer> ringsThirdPole;

	public static void main(String args[]) {
		int n = 5;
		Hanoi game = new Hanoi(n);
		game.solve();
	}
	
	public Hanoi(int size) {
		ringsFirstPole = new Stack<Integer>();
		ringsFirstPole.push(BASE);
		ringsSecondPole = new Stack<Integer>();
		ringsSecondPole.push(BASE);
		ringsThirdPole = new Stack<Integer>();
		ringsThirdPole.push(BASE);
		for (int i = size; i > 0; i--) {
			ringsFirstPole.push(i);
		}
	}
	
	private void moveRing(Stack<Integer> poleFrom, Stack<Integer> poleTo) {
		//Wait for user confirmation
		if (poleFrom.peek() > poleTo.peek() || poleFrom.peek() == BASE) {
			throw new RuntimeException();
		}
		poleTo.push(poleFrom.pop());
	}
	
	private void solve() {
		
	}
}
