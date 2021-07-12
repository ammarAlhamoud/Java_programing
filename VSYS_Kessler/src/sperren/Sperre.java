package sperren;

/* "implements Runnable" bildet eine Alternative zu "extends Thread"
 * - damit ist hier die Erweiterung einer anderen Klasse m�glich */
public class Sperre implements Runnable {

	/* GEMEINSAME Variable, d.h. alle Objekte teilen sich diese Variable */
	private static String	Inhalt = "leer";

	/* Objektvariable f�r die Daten, die im Thread bzw. in
	 * "run" verarbeitet werden sollen */
	private String	Name;

	/* Initialisierung der Daten �ber den Konstruktor */
	public Sperre(String N) {
		this.Name = N;
	}

	/* Diese Methode verz�gert die Ausf�hrung um 1 Sekunde (1000 ms) */
	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Diese Methode implementiert die "run"-Methode von "Runnable" und
	 * enth�lt den Code, der im neuen Thread ausgef�hrt werden soll;
	 * die Methode erh�lt die Daten aus dem Member "Name" (s.o.) */
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
