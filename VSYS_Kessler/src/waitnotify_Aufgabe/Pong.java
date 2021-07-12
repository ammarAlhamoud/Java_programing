package waitnotify_Aufgabe;

public class Pong implements Runnable{
	private PPRessource	Res;

	public Pong(PPRessource res) { this.Res = res; }
	
	/*
	public void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}
	*/

	public void run() {
		System.out.println("PONG ist gestartet");
		for(int i=1; i<11; i++) {
			synchronized(this.Res) {
				while (!this.Res.isFertig()) {
					try { this.Res.wait(); } catch (InterruptedException e) { }
				}
			}
			System.out.println("PONG liest: " + i + ". " + this.Res.getInhalt());
			//this.arbeiten();
			
			System.out.println("PONG schreibt " + i + ". Pong");
			System.out.println("----------------------------");
			synchronized(this.Res) {
				this.Res.setInhalt("Pong");
				this.Res.setFertig(false);
				this.Res.notify();
			}
			//this.arbeiten();
			
		}
		
		System.out.println("PONG beendet sich");
	}
	

	

}
