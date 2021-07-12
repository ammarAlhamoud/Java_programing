package sync;

public class Objekt {

	private static String	Inhalt;

	private void zeit() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Durch "synchronized" wird sichergestellt, dass nur
	 * EIN Thread gleichzeitig diese Methode mit DEMSELBEN
	 * Objekt aufruft (weitere Threads müssen warten, bis
	 * die Methode durchgelaufen ist);
	 * ein anderer Thread kann diese Methode aber mit einem
	 * ANDEREN Objekt aufrufen */
	public synchronized void bearbeiten(String T) {
		this.zeit();
		System.out.println(T + " wird geschrieben");
		Objekt.Inhalt = T;
		this.zeit();
		System.out.println("In Inhalt für " + T + " steht jetzt " + Objekt.Inhalt);
	}
}
