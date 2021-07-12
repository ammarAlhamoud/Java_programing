package asynchron.seriell;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		InputStream		Rein;
		OutputStream	Raus;
		byte[]			Puffer;
		int				laenge;
		String			Text = new String("");
		/* Dieses Objekt wird von (diesem) Empfangen-Thread und dem
		 * Senden-Thread geteilt; dadurch kann dem Senden-Thread das
		 * Ende der Kommunikation mitgeteilt werden */
		Steuerung		Fertig = new Steuerung();
		try {
			Rein = Verbindung.getInputStream();
			Raus = Verbindung.getOutputStream();
		} catch (IOException e) {
			Rein = null;
			Raus = null;
		}
		if ((Rein != null) && (Raus != null)) {
			/* "Mitteilung" an den Senden-Thread, dass Kommunikation
			 * (noch) läuft */
			synchronized(Fertig) {
				Fertig.setFertig(false);
			}
			/* Neuer Thread für das asynchrone Senden */
			(new Thread(new AnbieterSenden(Raus, Fertig))).start();
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
			/* Mitteilung an den Senden-Thread, dass die Kommunikation
			 * jetzt beendet wird */
			synchronized(Fertig) {
				Fertig.setFertig(true);
			}
			try {
				Rein.close();
			} catch (IOException e) { }
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
