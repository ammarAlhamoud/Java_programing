package threads;

public class Zwei extends Thread {

	/* Objektvariable für die Daten, die im Thread bzw. in
	 * "run" verarbeitet werden sollen */
	private String	Name;

	/* Initialisierung der Daten über den Konstruktor */
	public Zwei(String N) {
		this.Name = N;
	}

	/* Diese Methode verzögert die Ausführung um 1 Sekunde (1000 ms) */
	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Diese Methode überschreibt die "run"-Methode von "Thread" und
	 * enthält den Code, der im neuen Thread ausgeführt werden soll;
	 * die Methode erhält die Daten aus dem Member "Name" (s.o.) */
	public void run() {
		System.out.println(Name + " Thread gestartet");
		arbeiten();
		System.out.println(Name + " Thread arbeitet");
		arbeiten();
		System.out.println(Name + " Thread beendet");
	}
}
