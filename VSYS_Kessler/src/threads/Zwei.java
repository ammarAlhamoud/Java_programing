package threads;

public class Zwei extends Thread {

	/* Objektvariable f�r die Daten, die im Thread bzw. in
	 * "run" verarbeitet werden sollen */
	private String	Name;

	/* Initialisierung der Daten �ber den Konstruktor */
	public Zwei(String N) {
		this.Name = N;
	}

	/* Diese Methode verz�gert die Ausf�hrung um 1 Sekunde (1000 ms) */
	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Diese Methode �berschreibt die "run"-Methode von "Thread" und
	 * enth�lt den Code, der im neuen Thread ausgef�hrt werden soll;
	 * die Methode erh�lt die Daten aus dem Member "Name" (s.o.) */
	public void run() {
		System.out.println(Name + " Thread gestartet");
		arbeiten();
		System.out.println(Name + " Thread arbeitet");
		arbeiten();
		System.out.println(Name + " Thread beendet");
	}
}
