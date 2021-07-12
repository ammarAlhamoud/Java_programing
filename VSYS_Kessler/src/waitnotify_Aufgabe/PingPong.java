package waitnotify_Aufgabe;

public class PingPong {

	public static void main(String[] args) {
		PPRessource	Res = new PPRessource();
		Ping	ping = new Ping(Res);
		Pong	pong = new Pong(Res);
		Thread		Tping = new Thread(ping);
		Thread		Tpong = new Thread(pong);
		Tping.start();
		Tpong.start();
	

	}

}
