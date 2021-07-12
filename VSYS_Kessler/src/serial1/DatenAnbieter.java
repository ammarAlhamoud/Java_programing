package serial1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DatenAnbieter {

	public static void main(String[] args) {
		DatagramSocket	Verbindung;
		DatagramPacket	Paket;
		byte[]			Puffer;
		Daten			Artikel;
		try {
			/* Server verwendet in Abstimmung mit dem Client
			 * den Port 2000 */
			Verbindung = new DatagramSocket(2000);
		} catch (SocketException e) {
			Verbindung = null;
		}
		if (Verbindung != null) {
			try {
				Verbindung.setSoTimeout(5000);
			} catch (SocketException e1) { }
			System.out.println("Server ist gestartet");
			/* Bytepuffer in der Größe der vom Client gesendeten Daten */
			Puffer = new byte[1500];
			/* Neues leeres DatagramPacket mit diesem Bytepuffer für die Daten */
			Paket = new DatagramPacket(Puffer, Puffer.length);
			try {
				/* Daten werden empfangen in im Bytepuffer im Paket bereitgestellt */
				Verbindung.receive(Paket);
				/* Aus dem jetzt mit den Daten gefüllten Bytepuffer wird ein String erzeugt */
				Artikel = new Daten(Paket.getData(), Paket.getLength());
				System.out.println("Kunde hat gesendet: ");
				Artikel.ausgeben();
			} catch (IOException e) {
				System.out.println("Zu lange gewartet, Empfang wird abgebrochen");
			}
		}
		System.out.println("Server ist beendet");
	}

}
