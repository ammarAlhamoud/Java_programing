package join;

public class Starter {

	public static void main(String[] args) {
		Objekt		Obj = new Objekt();
		Erzeuger	E = new Erzeuger(Obj);
		Verbraucher	V = new Verbraucher(Obj);
		Thread		TE = new Thread(E);
		Thread		TV = new Thread(V);
		TV.start();
		TE.start();
	}

}
