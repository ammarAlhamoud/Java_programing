package threads;

public class DreiStarter {

	public static void main(String[] args) {
		/* Da "Drei" die Klasse "Runnable" implementiert, ist ein Objekt
		 * von "Drei" auch ein "Runnable"-Objekt */
		Drei	D1 = new Drei("Erster");
		Drei	D2 = new Drei("Zweiter");
		/* Neues "Thread"-Objekt erhält ein "Runnable"-Objekt, dessen
		 * "run"-Methode die "run" von "Thread" ersetzt */
		Thread	Z1 = new Thread(D1);
		Thread	Z2 = new Thread(D2);
		/* "start" führt die hinterlegte "run"-Methode aus; hier die
		 * "run"-Methode des dem Thread übergebenen "Runnable" */
		Z1.start();
		Z2.start();
	}
}
