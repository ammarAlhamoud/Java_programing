package serialisierung_verbindungslos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ArtikelClient {

	private static final int	Standardport = 2000;

	private DatagramSocket	Verbindung;
	private	InetAddress		Adresse;
	private int				Port;

	public ArtikelClient() {
		this.verbinden();
		this.Port = ArtikelClient.Standardport;
		this.Adresse = InetAddress.getLoopbackAddress();
	}

	public ArtikelClient(int p) {
		this.verbinden();
		this.Port = p;
		this.Adresse = InetAddress.getLoopbackAddress();		
	}

	public ArtikelClient(String host) {
		this.verbinden();
		try {
			this.Verbindung = new DatagramSocket();
		} catch (SocketException e) {
			this.Verbindung = null;
		}
		this.Port = ArtikelClient.Standardport;
		try {
			this.Adresse = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			this.Adresse = null;
		}		
	}

	public ArtikelClient(String host, int p) {
		this.verbinden();
		this.Port = p;
		try {
			this.Adresse = InetAddress.getByName(host);
		} catch (UnknownHostException e) {
			this.Adresse = null;
		}		
	}

	private void verbinden() {
		try {
			this.Verbindung = new DatagramSocket();
		} catch (SocketException e) {
			this.Verbindung = null;
		}		
	}

	public void starten() {
		DatagramPacket			Paket;
		byte[]					Puffer = null;
		ByteArrayOutputStream	BytesRaus;
		ObjectOutputStream		Raus = null;
		Artikel					Art;
		System.out.println("ArtikelClient gestartet");
		if (this.Verbindung != null) {
			if (this.Adresse != null) {
				Art = new Artikel(42, "Handtuch", 1.11, new Datum(21,1,2021));
				BytesRaus = new ByteArrayOutputStream();
				try {
					Raus = new ObjectOutputStream(BytesRaus);
				} catch (IOException e) {
					System.out.println("Ausgabedatenstrom kann nicht initialisiert werden");
				}
				if (Raus != null) {
					try {
						Raus.writeObject(Art);
						Puffer = BytesRaus.toByteArray();
					} catch (IOException e) {
						System.out.println("Serialisierung fehlgeschlagen");
					}
					if (Puffer != null) {
						Paket = new DatagramPacket(Puffer, Puffer.length, this.Adresse, this.Port);
							try {
								this.Verbindung.send(Paket);
								System.out.println("Artikel gesendet");
							} catch (IOException e) {
								System.out.println("Senden fehlgeschlagen");
							}
					}
					try {
						Raus.close();
					} catch (IOException e) {
						System.out.println("Ausgabedatenstrom kann nicht geschlossen werden");
					}
				}
			} else
				System.out.println("Zieladresse unbekannt");
		} else
			System.out.println("Fehler beim Öffnen des Sockets");
		System.out.println("Artikelclient beendet");
	}
}
