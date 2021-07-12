package asynchron.parallel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class AnbieterSenden implements Runnable {

	private OutputStream	Raus;
	/* Durch dieses Objekt bekommt dieser Senden-Thread mit, wann
	 * die Kommunikation beendet wird */
	private Steuerung		Fertig;

	public AnbieterSenden(OutputStream R, Steuerung F) {
		this.Raus = R;
		this.Fertig = F;
	}

	public void run() {
		String			Text;
		boolean			ok = true;
		BufferedReader	Eingabe = new BufferedReader(new InputStreamReader(System.in));
		while (ok == true) {
			try {
				System.out.print("Ihre Antwort: ");
				Text = Eingabe.readLine();
				this.Raus.write(Text.getBytes());
			} catch (IOException e) { }
			synchronized(this.Fertig) {
				if (this.Fertig.isFertig() == true)
					ok = false;
			}
		}
		try {
			this.Raus.close();
		} catch (IOException e) { }
	}
}
