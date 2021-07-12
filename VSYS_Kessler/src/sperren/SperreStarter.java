package sperren;

public class SperreStarter {

	public static void main(String[] args) {
		Sperre	D1 = new Sperre("Erster");
		Sperre	D2 = new Sperre("Zweiter");
		Thread	Z1 = new Thread(D1);
		Thread	Z2 = new Thread(D2);
		Z1.start();
		Z2.start();
	}
}
