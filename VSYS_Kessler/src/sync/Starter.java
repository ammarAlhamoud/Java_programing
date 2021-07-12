package sync;

public class Starter {

	public static void main(String[] args) {
		Objekt	Obj1 = new Objekt();
		Objekt	Obj2 = new Objekt();
		/* Dadurch, dass es zwei verschiedene Objekte sind,
		 * wird in den Threads die "bearbeiten"-Methode des
		 * Objekts parallel aufgerufen; wenn es das gleiche
		 * Objekt ist, wird die Methode nacheinander aufgerufen */
		Zugriff	Z1 = new Zugriff(Obj1, "Eins");
		Zugriff	Z2 = new Zugriff(Obj1, "Zwei");
		Thread	T1 = new Thread(Z1);
		Thread	T2 = new Thread(Z2);
		T1.start();
		T2.start();
	}

}
