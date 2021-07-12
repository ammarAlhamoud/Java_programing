package aufgabe_wait_notify;

public class Ping implements Runnable {

	private PPRessource	Objekt;

	public Ping(PPRessource Obj) {
		this.Objekt = Obj;
	}

	public void run() {
		int		i;
		String	Text;
		/* Für zehnmaliges Schreiben/Lesen */
		for (i = 0; i < 10; i++) {
			synchronized(this.Objekt) {
				/* Ping schreibt */
				Text = "Ping (" + (new Integer(i)).toString() + ")";
				try { Thread.sleep(1000); } catch (InterruptedException e) { }
				System.out.println("Ping schreibt: " + Text);
				this.Objekt.setInhalt(Text);
				/* Ping setzt den Benachrichtigungsanzeiger für Pong */
				this.Objekt.setPing_fertig(true);
				/* Ping benachrichtigt Pong */
				this.Objekt.notify();
			}
			/* Ping gibt "this.Objekt" wieder frei, damit Pong
			 * darauf zugreifen kann, und belegt es mit
			 * "synchronized" dann wieder neu */
			synchronized(this.Objekt) {
				/* Ping wartet auf Antwort von Pong */
				while (this.Objekt.isPong_fertig() != true) {
					try { this.Objekt.wait(); } catch (InterruptedException e) { }
				}
			}
			synchronized(this.Objekt) {
				try { Thread.sleep(1000); } catch (InterruptedException e) { }
				/* Ping liest */
				System.out.println("Ping liest: " + this.Objekt.getInhalt());
				/* Nach dem Lesen muss der Benachrichtigungsanzeiger
				 * wieder zurückgesetzt werden, damit ihn Pong neu
				 * setzen kann */
				this.Objekt.setPong_fertig(false);
			}
		}
	}
}
