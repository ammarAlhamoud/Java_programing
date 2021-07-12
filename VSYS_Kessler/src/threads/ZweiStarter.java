package threads;

public class ZweiStarter {

	public static void main(String[] args) {
		Zwei	Z1 = new Zwei("Erster");
		Zwei	Z2 = new Zwei("Zweiter");
		Z1.start();
		Z2.start();
	}
}
