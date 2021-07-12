package asynchron.parallel;

import java.io.IOException;
import java.io.InputStream;

public class KundeEmpfangen extends Thread {

	private static final int	MTU = 65536;

	private InputStream	Rein;
	private Steuerung	Fertig;

	public KundeEmpfangen(InputStream R, Steuerung F) {
		this.Rein = R;
		this.Fertig = F;
	}

	public void run() {
		String	Text;
		byte[]	Puffer;
		int		laenge;
		boolean	ok = true;
		while (ok == true) {
			Puffer = new byte[KundeEmpfangen.MTU];
			try {
				laenge = this.Rein.read(Puffer);
			} catch (IOException e) {
				laenge = 0;
			}
			if (laenge > 0) {
				Text = new String(Puffer, 0, laenge);
				System.out.println("Antwort des Servers: \"" + Text + "\"");
			}
			synchronized(this.Fertig) {
				if (this.Fertig.isFertig() == true)
					ok = false;
			}
		}
		try {
			this.Rein.close();
		} catch (IOException e) { }
	}
}
