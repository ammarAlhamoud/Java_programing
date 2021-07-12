package waitnotify;

public class Verbraucher implements Runnable {

	private Objekt	Obj;

	public Verbraucher(Objekt O) { this.Obj = O; }

	public void run() {
		System.out.println("Verbraucher ist gestartet");
		/* Zur Vermeidung von race conditions und ihren Effekten */
		synchronized(this.Obj) {
			/* Solange keine Daten da sind, wird gewartet;
			 * "wait" könnte nämlich auch durch andere Interrupts
			 * ausser "notify" beendet werden(!) */
			while (!this.Obj.isFertig()) {
				/* Auf den Erzeuger warten; "notify" löst einen
				 * Interrupt aus; damit der Verbraucher deswegen
				 * nicht terminert, wird die entsprechende Exception
				 * abgefangen */
				try { this.Obj.wait(); } catch (InterruptedException e) { }
			}
		}
		System.out.println("Verbraucher liest: " + this.Obj.getInhalt());
		System.out.println("Verbraucher beendet sich");
	}
}
