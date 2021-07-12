package sperren;

/* "implements Runnable" bildet eine Alternative zu "extends Thread"
 * - damit ist hier die Erweiterung einer anderen Klasse möglich */
public class Sperre implements Runnable {

	/* GEMEINSAME Variable, d.h. alle Objekte teilen sich diese Variable */
	private static String	Inhalt = "leer";

	/* Objektvariable für die Daten, die im Thread bzw. in
	 * "run" verarbeitet werden sollen */
	private String	Name;

	/* Initialisierung der Daten über den Konstruktor */
	public Sperre(String N) {
		this.Name = N;
	}

	/* Diese Methode verzögert die Ausführung um 1 Sekunde (1000 ms) */
	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Diese Methode implementiert die "run"-Methode von "Runnable" und
	 * enthält den Code, der im neuen Thread ausgeführt werden soll;
	 * die Methode erhält die Daten aus dem Member "Name" (s.o.) */
	public void run() {
		System.out.println(this.Name + " gestartet");
		arbeiten();
		/* Hier sperren */
		System.out.println(this.Name + " schreibt: " + this.Name);
		Sperre.Inhalt = this.Name;
		arbeiten();
		System.out.println(this.Name + " liest: " + Sperre.Inhalt);
		/* Hier entsperren */
	}
}
