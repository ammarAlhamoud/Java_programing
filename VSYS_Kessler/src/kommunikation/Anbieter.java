package kommunikation;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Anbieter {

	public static void main(String[] args) {
		DatagramSocket	Verbindung;
		DatagramPacket	Paket;
		byte[]			Daten;
		String			Text;
		try {
			/* Server verwendet in Abstimmung mit dem Client
			 * den Port 2000 */
			Verbindung = new DatagramSocket(2000);
		} catch (SocketException e) {
			Verbindung = null;
		}
		if (Verbindung != null) {
			/* Bytepuffer in der Größe der vom Client gesendeten Daten */
			Daten = new byte[6];
			/* Neues leeres DatagramPacket mit diesem Bytepuffer für die Daten */
			Paket = new DatagramPacket(Daten, Daten.length);
			try {
				/* Daten werden empfangen in im Bytepuffer im Paket bereitgestellt */
				Verbindung.receive(Paket);
				/* Aus dem jetzt mit den Daten gefüllten Bytepuffer wird ein String erzeugt */
				Text = new String(Daten);
				System.out.println("Kunde hat gesendet: " + Text);
			} catch (IOException e) { }
		}
	}

}
