package server.seriell;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Anbieter {

	private static final int	MTU = 65536;
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

	private void datenaustauschen(Socket Verbindung) {
		InputStream	Rein;
		byte[]		Puffer;
		int			laenge;
		String		Text = new String("");
		try {
			Rein = Verbindung.getInputStream();
		} catch (IOException e) {
			Rein = null;
		}
		if (Rein != null) {
			while (!Text.equals("Ende")) {
				Puffer = new byte[Anbieter.MTU];
				try {
					laenge = Rein.read(Puffer);
				} catch (IOException e) {
					laenge = 0;
				}
				if (laenge > 0) {
					Text = new String(Puffer, 0, laenge);
					System.out.print("Neue Nachricht von ");
					System.out.print(Verbindung.getInetAddress());
					System.out.print(":" + Verbindung.getPort());
					System.out.println(" = \"" + Text + "\"");
				}
			}
		}
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
					this.datenaustauschen(Verbindung);
				}
			}
		}
	}
}
