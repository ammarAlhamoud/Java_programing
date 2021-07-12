package serial1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class FlexiblerKunde {

	public static void main(String[] args) {
		DatagramSocket	Verbindung;
		byte[]			Daten;
		String			Text;
		DatagramPacket	Paket;
		try {
			/* Client öffnet DatagramSocket an einem Port,
			 * der vom System zugewiesen wird */
			Verbindung = new DatagramSocket();
		} catch (SocketException e) {
			Verbindung = null;
		}
		if (Verbindung != null) {
			/* Client erzeugt die Daten zum Senden */
			Text = new String("Hi, wie gehts?");
			/* Daten werden für das Senden in ein Bytearray konvertiert */
			Daten = Text.getBytes();
			try {
				/* Datenpaket zum Senden wird erstellt mit diesem Bytearray in
				 * seiner vollen Länge, adressiert an den Zielrechner an Port 2000;
				 * der Zielrechner ist hier für das Beispiel der eigene Rechner
				 * ("localhost") */
				Paket = new DatagramPacket(Daten, Daten.length,
						InetAddress.getLocalHost(), 2000);
				/* Das gefüllte und adressierte Datenpaket wird gesendet */
				Verbindung.send(Paket);
			} catch (UnknownHostException e) { } catch (IOException e) { }
		}
	}

}
