package verbindungsorientiert;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Kunde {

	private Socket	Verbindung;

	public Kunde() {
		try {
			this.Verbindung = new Socket("localhost", 2000);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public void starten() {
		OutputStream	Raus;
		if (this.Verbindung != null) {
			try {
				Raus = this.Verbindung.getOutputStream();
			} catch (IOException e) {
				Raus = null;
			}
			if (Raus != null) {
				try {
					Raus.write((new String("Wie gehts denn so?")).getBytes());
				} catch (IOException e) { }
			}
			try {
				this.Verbindung.close();
			} catch (IOException e) { }
		}
	}

	public static void main(String[] args) {
		Kunde	K = new Kunde();
		K.starten();
	}

}
