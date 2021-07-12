package waitnotify;

public class Erzeuger implements Runnable {

	private Objekt	Obj;

	public Erzeuger(Objekt O) { this.Obj = O; }

	public void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	public void run() {
		System.out.println("Erzeuger ist gestartet");
		this.arbeiten();
		System.out.println("Erzeuger schreibt Daten");
		/* Zur Vermeidung von race conditions und ihren Effekten */
		synchronized(this.Obj) {
			this.Obj.setInhalt("Hallo");
			/* Flag setzen, um anzuzeigen, dass Daten da sind */
			this.Obj.setFertig(true);
			/* Verbraucher benachrichtigen, dass Daten da sind */
			this.Obj.notify();
		}
		this.arbeiten();
		System.out.println("Erzeuger beendet sich");
	}
}
