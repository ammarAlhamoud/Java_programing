package serialisierung;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Kunde {

	private static final int	Standardport = 2000;
	private static final String	Standardhost = "localhost";

	private Socket	Verbindung;

	public Kunde() {
		try {
			this.Verbindung = new Socket(Kunde.Standardhost, Kunde.Standardport);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public Kunde(String host) {
		try {
			this.Verbindung = new Socket(host, Kunde.Standardport);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public Kunde(String host, int port) {
		try {
			this.Verbindung = new Socket(host, port);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public Kunde(int port) {
		try {
			this.Verbindung = new Socket(Kunde.Standardhost, port);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public Kunde(InetAddress host) {
		try {
			this.Verbindung = new Socket(host, Kunde.Standardport);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public Kunde(InetAddress host, int port) {
		try {
			this.Verbindung = new Socket(host, port);
		} catch (IOException e) {
			this.Verbindung = null;
		}
	}

	public void umstaendlich_senden(OutputStream Raus, Artikel A) {
		byte[]					Puffer;
		ObjectOutputStream		ObjektRaus;
		ByteArrayOutputStream	BytesRaus;
		if (Raus != null) {
			try {
				/* Artikel an Server senden */
				/* Artikel vorher serialisieren */
				/* Neuer ByteArrayOutputStream */
				BytesRaus = new ByteArrayOutputStream();
				/* ByteArrayOutputStream mit ObjectOutputStream verknüpfen */
				ObjektRaus = new ObjectOutputStream(BytesRaus);
				/* Objekt in ObjectOutputStream schreiben; das Objekt wird
				 * serialisiert und landet im "darunterliegenden"
				 * ByteArrayOutputStream */
				ObjektRaus.writeObject(A);
				/* Bytearray des Objekts aus dem ByteArrayOutputStream ziehen */
				Puffer = BytesRaus.toByteArray();
				/* Bytearray in den OutputStream (des Sockets) schreiben */
				Raus.write(Puffer);
			} catch (IOException e) { }
		}		
	}

	public void senden(OutputStream Raus, Artikel A) {
		ObjectOutputStream		ObjektRaus;
		if (Raus != null) {
			try {
				/* Artikel an Server senden */
				/* OutputStream des Sockets mit ObjectOutputStream verknüpfen */
				ObjektRaus = new ObjectOutputStream(Raus);
				/* Objekt in ObjectOutputStream schreiben; das Objekt wird
				 * serialisiert und wird in den "darunterliegenden"
				 * OutputStream des Sockets geschrieben */
				ObjektRaus.writeObject(A);
			} catch (IOException e) { }
		}		
	}

	public void starten() {
		this.starten(42, "Handtuch", 1.11);
	}
	public void starten(int i, String s, double d) {
		OutputStream			Raus;
		Artikel					A = new Artikel(i, s, d);
		if (this.Verbindung != null) {
			try {
				Raus = this.Verbindung.getOutputStream();
			} catch (IOException e) {
				Raus = null;
			}
			this.senden(Raus, A);
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
