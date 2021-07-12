package join_lsg;

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
		this.Obj.setInhalt("Hallo");
		this.arbeiten();
		System.out.println("Erzeuger beendet sich");
	}
}
