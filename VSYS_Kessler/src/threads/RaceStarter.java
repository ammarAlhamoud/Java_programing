package threads;

public class RaceStarter {

	public static void main(String[] args) {
		Race	D1 = new Race("Erster");
		Race	D2 = new Race("Zweiter");
		Thread	Z1 = new Thread(D1);
		Thread	Z2 = new Thread(D2);
		Z1.start();
		Z2.start();
	}
}
