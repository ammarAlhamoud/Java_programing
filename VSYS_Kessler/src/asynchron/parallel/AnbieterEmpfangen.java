package asynchron.parallel;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class AnbieterEmpfangen extends Thread {

	private static final int	MTU = 65536;

	private Socket	Verbindung;

	public AnbieterEmpfangen(Socket S) {
		this.Verbindung = S;
	}

	public void run() {
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
			Rein = this.Verbindung.getInputStream();
			Raus = this.Verbindung.getOutputStream();
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
				Puffer = new byte[AnbieterEmpfangen.MTU];
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


}
