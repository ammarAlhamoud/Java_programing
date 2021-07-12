package serialisierung;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/* Verarbeitet mehrere Clients in der Schleife nacheinander */
public class SeriellerDienstleister {

	private static final int	Standardport = 2000;

	private ServerSocket	Dienst;

	public SeriellerDienstleister() {
		try {
			this.Dienst = new ServerSocket(SeriellerDienstleister.Standardport);
		} catch (IOException e) {
			this.Dienst = null;
		}
	}

	public SeriellerDienstleister(int port) {
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
		Socket		Verbindung = null;
		InputStream	Rein = null;
		while (true) {
			try {
				Verbindung = this.Dienst.accept();
				Rein = Verbindung.getInputStream();
			} catch (IOException e) {
				Rein = null;
			}
			if (Rein != null) {
				this.empfangen(Rein);
				try {
					Verbindung.close();
				} catch (IOException e) { }
			}
		}
	}

	public static void main(String[] args) {
		SeriellerDienstleister	D = new SeriellerDienstleister();
		D.starten();
	}

}
