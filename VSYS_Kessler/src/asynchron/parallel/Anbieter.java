package asynchron.parallel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Anbieter {

	private static final int	standardport = 2000;

	private ServerSocket	Dienst;

	public Anbieter(int port) {
		try {
			Dienst = new ServerSocket(port);
		} catch (IOException e) {
			Dienst = null;
		}		
	}
	public Anbieter() {
		this(Anbieter.standardport);
	}

	public void starten() {
		Socket	Verbindung;
		if (this.Dienst != null) {
			while (true) {
				try {
					Verbindung = this.Dienst.accept();
				} catch (IOException e) {
					Verbindung = null;
				}
				if (Verbindung != null) {
					(new AnbieterEmpfangen(Verbindung)).start();;
				}
			}
		}
	}
}
