package server.parallel;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Austausch implements Runnable {

	private static final int	MTU = 65536;

	private Socket	Verbindung;

	public Austausch(Socket V) {
		this.Verbindung = V;
	}

	@Override
	public void run() {
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
				Puffer = new byte[Austausch.MTU];
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

}
