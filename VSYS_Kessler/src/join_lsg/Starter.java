package join_lsg;

public class Starter {

	public static void main(String[] args) {
		/* Gemeinsames Objekt f�r den Datenaustausch von
		 * Erzeuger und Verbraucher */
		Objekt		Obj = new Objekt();
		Erzeuger	E = new Erzeuger(Obj);
		Thread		TE = new Thread(E);
		/* Damit der Verbraucher auf das Ende des Erzeuger(-Thread)s
		 * warten kann, ben�tigt er eine Referenz auf den
		 * Erzeuger(-Thread) */
		Verbraucher	V = new Verbraucher(Obj, TE);
		Thread		TV = new Thread(V);
		TV.start();
		TE.start();
	}

}
