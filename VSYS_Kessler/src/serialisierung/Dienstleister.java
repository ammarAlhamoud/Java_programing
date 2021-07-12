package serialisierung;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Dienstleister {

	private static final int	Standardport = 2000;

	private ServerSocket	Dienst;

	public Dienstleister() {
		try {
			this.Dienst = new ServerSocket(Dienstleister.Standardport);
		} catch (IOException e) {
			this.Dienst = null;
		}
	}

	public Dienstleister(int port) {
		try {
			this.Dienst = new ServerSocket(port);
		} catch (IOException e) {
			this.Dienst = null;
		}
	}

	public void umstaendlich_empfangen(InputStream Rein) {
		ObjectInputStream		ObjektRein;
		ByteArrayInputStream	BytesRein;
		byte[]					Puffer;
		int						laenge;
		Artikel					Neu;
		Puffer = new byte[65536];
		try {
			laenge = Rein.read(Puffer);
			BytesRein = new ByteArrayInputStream(Puffer, 0, laenge);
			ObjektRein = new ObjectInputStream(BytesRein);
			Neu = (Artikel) ObjektRein.readObject();
		} catch (IOException | ClassNotFoundException e) {
			Neu = null;
		}
		if (Neu != null) {
			System.out.println("Id: " + Neu.getId());
			System.out.println("Name: " + Neu.getName());
			System.out.println("Preis: " + Neu.getPreis());
		}
	}

	public void empfangen(InputStream Rein) {
		ObjectInputStream	ObjektRein;
		Artikel				Neu;
		try {
			ObjektRein = new ObjectInputStream(Rein);
			Neu = (Artikel) ObjektRein.readObject();
		} catch (IOException | ClassNotFoundException e) {
			Neu = null;
		}
		if (Neu != null) {
			System.out.println("Id: " + Neu.getId());
			System.out.println("Name: " + Neu.getName());
			System.out.println("Preis: " + Neu.getPreis());
		}
	}

	public void starten() {
		Socket		Verbindung;
		InputStream	Rein = null;
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
		}
		if (Rein != null) {
			this.empfangen(Rein);
			try {
				Verbindung.close();
			} catch (IOException e) { }
		}
	}

	public static void main(String[] args) {
		Dienstleister	D = new Dienstleister();
		D.starten();
	}

}
