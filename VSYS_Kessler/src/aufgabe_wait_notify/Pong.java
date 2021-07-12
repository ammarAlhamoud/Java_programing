package aufgabe_wait_notify;

public class Pong implements Runnable {

	private PPRessource	Objekt;

	public Pong(PPRessource Obj) {
		this.Objekt = Obj;
	}

	public void run() {
		int		i;
		String	Text;
		/* Für zehnmaliges Schreiben/Lesen */
		for (i = 0; i < 10; i++) {
			synchronized(this.Objekt) {
				/* Pong wartet auf Daten von Ping */
				while (this.Objekt.isPing_fertig() != true) {
					try { this.Objekt.wait(); } catch (InterruptedException e) { }
				}
			}
			synchronized(this.Objekt) {
				/* Pong liest */
				try { Thread.sleep(1000); } catch (InterruptedException e) { }
				System.out.println("\tPong liest: " + this.Objekt.getInhalt());
				/* Nach dem Lesen muss der Benachrichtigungsanzeiger
				 * wieder zurückgesetzt werden, damit ihn Ping neu
				 * setzen kann */
				this.Objekt.setPing_fertig(false);
			}
			/* Pong gibt "this.Objekt" wieder frei, damit Ping
			 * darauf zugreifen kann, und belegt es mit
			 * "synchronized" dann wieder neu */
			synchronized(this.Objekt) {
				/* Pong schreibt */
				Text = "Pong (" + (new Integer(i)).toString() + ")";
				try { Thread.sleep(1000); } catch (InterruptedException e) { }
				this.Objekt.setInhalt(Text);
				System.out.println("\tPong schreibt: " + Text);
				/* Pong setzt den Benachrichtigungsanzeiger für Ping */
				this.Objekt.setPong_fertig(true);
				/* Pong benachrichtigt Ping */
				this.Objekt.notify();
			}
		}
	}
}
