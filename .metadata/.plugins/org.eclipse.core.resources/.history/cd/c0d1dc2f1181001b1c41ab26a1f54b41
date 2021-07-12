package verbindungsorientiert;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dienstleister {

	private ServerSocket	Dienst;

	public Dienstleister() {
		try {
			this.Dienst = new ServerSocket(2000);
		} catch (IOException e) {
			this.Dienst = null;
		}
	}

	public void starten() {
		Socket		Verbindung;
		InputStream	Rein;
		byte[]		Puffer = new byte[65536];
		String		Text;
		int			laenge;
		if (this.Dienst != null) {
			try {
				Verbindung = this.Dienst.accept();
			} catch (IOException e) {
				Verbindung = null;
			}
			if (Verbindung != null) {
				try {
					Rein = Verbindung.getInputStream();
				} catch (IOException e) {
					Rein = null;
				}
				if (Rein != null) {
					try {
						laenge = Rein.read(Puffer);
						Text = new String(Puffer);
						System.out.println("Mit trim(): " + Text.trim());
						Text = new String(Puffer, 0, laenge);
						System.out.println("Mit Länge: " + Text);
					} catch (IOException e) { }
				}
			}
		}
	}
	public static void main(String[] args) {
		Dienstleister	D = new Dienstleister();
		D.starten();
	}

}
