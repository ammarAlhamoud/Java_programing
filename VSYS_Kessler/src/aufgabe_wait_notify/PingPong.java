package aufgabe_wait_notify;

public class PingPong {

	public static void main(String[] args) {
		/* Gemeinsames Daten-Objekt von Ping und Pong */
		PPRessource	Objekt = new PPRessource();
		Ping		Pi = new Ping(Objekt);
		Pong		Po = new Pong(Objekt);
		Thread		TPi = new Thread(Pi);
		Thread		TPo = new Thread(Po);
		TPo.start();
		TPi.start();
	}

}
