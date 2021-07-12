package serialisierung_verbindungslos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ArtikelServer {

	private static final int	MAX = 65536;
	private static final int	Standardport = 2000;

	private DatagramSocket		Verbindung;

	public ArtikelServer() {
		try {
			this.Verbindung = new DatagramSocket(ArtikelServer.Standardport);
		} catch (SocketException e) {
			this.Verbindung = null;
		}
	}

	public ArtikelServer(int p) {
		try {
			this.Verbindung = new DatagramSocket(p);
		} catch (SocketException e) {
			this.Verbindung = null;
		}		
	}

	public void starten() {
		DatagramPacket			Paket;
		byte[]					Puffer;
		ByteArrayInputStream	BytesRein;
		ObjectInputStream		Rein = null;
		Artikel					Art = null;
		System.out.println("ArtikelServer gestartet");
		if (this.Verbindung != null) {
			Puffer = new byte[ArtikelServer.MAX];
			Paket = new DatagramPacket(Puffer, Puffer.length);
			try {
				this.Verbindung.receive(Paket);
			} catch (IOException e) {
				System.out.println("Datenempfang fehlgeschlagen");
				Paket = null;
			}
			if (Paket != null) {
				BytesRein = new ByteArrayInputStream(Paket.getData(), 0, Paket.getLength());
				try {
					Rein = new ObjectInputStream(BytesRein);
				} catch (IOException e) {
					System.out.println("Eingabedatenstrom kann nicht initialisiert werden");
				}
				if (Rein != null) {
					try {
						Art = (Artikel) Rein.readObject();
					} catch (ClassNotFoundException e) {
						System.out.println("Entserialisierung fehlgeschlagen - Artikelklasse nicht gefunden");
					} catch (IOException e) {
						System.out.println("Entserialisierung fehlgeschlagen - Eingabefehler");
					}
					if (Art != null)
						Art.ausgeben();
					try {
						Rein.close();
					} catch (IOException e) {
						System.out.println("Eingabedatenstrom kann nicht geschlossen werden");
					}
				}
			}
		} else
			System.out.println("Fehler beim Öffnen des Sockets");
		System.out.println("ArtikelServer beendet");
	}

}
