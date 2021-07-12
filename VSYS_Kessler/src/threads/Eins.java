package threads;

/* Diese Klasse erweitert "Thread" - damit ist die Verwendung
 * und Ausf�hrung neuer Threads m�glich */
public class Eins extends Thread {

	/* Diese Methode verz�gert die Ausf�hrung um 1 Sekunde (1000 ms) */
	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Diese Methode �berschreibt die "run"-Methode von "Thread" und
	 * enth�lt den Code, der im neuen Thread ausgef�hrt werden soll */
	public void run() {
		System.out.println("Neuer Thread gestartet");
		arbeiten();
		System.out.println("Neuer Thread arbeitet");
		arbeiten();
		System.out.println("Neuer Thread beendet");
	}

	public static void main(String[] args) {
		Eins	E = new Eins();
		/* Neuer Thread wird erzeugt und gestartet; dieser Thread ruft
		 * dann die "run"-Methode auf */
		E.start();
		System.out.println("Alter Thread arbeitet");
		arbeiten();
		System.out.println("Alter Thread beendet");
	}
}
