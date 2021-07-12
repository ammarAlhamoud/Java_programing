package join_lsg;

public class Verbraucher implements Runnable {
	private Objekt	Obj;
	private Thread	TErz;
	/* Verbraucher erhält Referenz auf Erzeuger(-Thread) */
	public Verbraucher(Objekt O, Thread T) {
		this.Obj = O;
		this.TErz = T;
	}
	public void run() {
		System.out.println("Verbraucher ist gestartet");
		/* Vor dem Lesen wartet der Verbraucher auf das Ende des Erzeugers */
		try { this.TErz.join(); } catch (InterruptedException e) { }
		System.out.println("Verbraucher liest: " + this.Obj.getInhalt());
		System.out.println("Verbraucher beendet sich");
	}
}
