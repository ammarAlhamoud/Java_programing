package sperren;

public class SperreLoesungStarter {

	public static void main(String[] args) {
		SperreLoesung	D1 = new SperreLoesung("Erster");
		SperreLoesung	D2 = new SperreLoesung("Zweiter");
		Thread	Z1 = new Thread(D1);
		Thread	Z2 = new Thread(D2);
		Z1.start();
		Z2.start();
	}
}
