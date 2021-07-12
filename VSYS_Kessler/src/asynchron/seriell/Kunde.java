package asynchron.seriell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Kunde {

	private static final InetAddress	Standardziel = InetAddress.getLoopbackAddress();
	private static final int			standardport = 2000;

	private Socket	Verbindung;

	public Kunde(String Host, int port) {
		try {
			this.Verbindung = new Socket(Host, port);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}
	public Kunde(String Host) {
		this(Host, Kunde.standardport);
	}
	public Kunde(InetAddress Ziel, int port) {
		try {
			this.Verbindung = new Socket(Ziel, port);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}
	public Kunde(int port) {
		this(Kunde.Standardziel, port);
	}
	public Kunde(InetAddress Ziel) {
		this(Ziel, Kunde.standardport);
	}
	public Kunde() {
		this(Kunde.Standardziel, Kunde.standardport);
	}

	public void starten() {
		OutputStream	Raus;
		InputStream		Rein;
		BufferedReader	Eingabe = new BufferedReader(new InputStreamReader(System.in));
		String			Text = new String("");
		Steuerung		Fertig = new Steuerung();
		if (this.Verbindung != null) {
			try {
				Raus = this.Verbindung.getOutputStream();
				Rein = this.Verbindung.getInputStream();
			} catch (IOException e) {
				Raus = null;
				Rein = null;
			}
			if ((Raus != null) && Rein != null) {
				synchronized(Fertig) {
					Fertig.setFertig(false);
				}
				(new KundeEmpfangen(Rein, Fertig)).start();
				while (!Text.equals("Ende")) {
					System.out.print("Zu sendender Text (\"Ende\" zum Beenden): ");
					try {
						Text = Eingabe.readLine();
					} catch (IOException e) {
						Text = new String("");
					}
					if (Text.length() > 0) {
						try {
							Raus.write(Text.getBytes());
						} catch (IOException e) {
							
						}
					}
				}
				synchronized(Fertig) {
					Fertig.setFertig(true);
				}
			}
		}
	}
}
