package waitnotify_Aufgabe;

public class Ping implements Runnable {
	
	private PPRessource	Res;

	public Ping(PPRessource res) { this.Res = res; }

	/*
	public void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}
	*/

	public void run() {
		System.out.println("PING ist gestartet");
		//this.arbeiten();
		
		for(int i=1;i<11;i++) {
			System.out.println("PING schreibt " + i + ". Ping");
			System.out.println("----------------------------");
			synchronized(this.Res) {
				this.Res.setInhalt("Ping");
				this.Res.setFertig(true);
				this.Res.notify();
			}
			//this.arbeiten();
			
			synchronized(this.Res) {
				while(this.Res.isFertig()) {
					try {this.Res.wait();} catch (InterruptedException e) {}
				}
				
				System.out.println("PING liest: " + i + ". " + this.Res.getInhalt());
				//this.arbeiten();
			}
			
		}
		
		System.out.println("PING beendet sich");
	}
	

}
