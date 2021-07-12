package join;

public class Verbraucher implements Runnable {
	private Objekt	Obj;
	public Verbraucher(Objekt O) { this.Obj = O; }
	public void run() {
		System.out.println("Verbraucher ist gestartet");
		/* Vor dem Lesen wartet der Verbraucher auf das Ende des Erzeugers */
		/* Hier müsste ein Aufruf von "join" stehen */
		System.out.println("Verbraucher liest: " + this.Obj.getInhalt());
		System.out.println("Verbraucher beendet sich");
	}
}
