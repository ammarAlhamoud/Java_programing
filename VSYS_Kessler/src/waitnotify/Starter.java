package waitnotify;

public class Starter {

	public static void main(String[] args) {
		/* Gemeinsames Objekt f�r die Daten/Verarbeitung;
		 * �ber dieses Objekt stimmen sich die Threads auch ab */
		Objekt		Obj = new Objekt();
		Erzeuger	E = new Erzeuger(Obj);
		Verbraucher	V = new Verbraucher(Obj);
		Thread		TE = new Thread(E);
		Thread		TV = new Thread(V);
		TV.start();
		TE.start();
	}

}
