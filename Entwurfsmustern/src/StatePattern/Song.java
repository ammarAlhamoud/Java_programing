package StatePattern;

public class Song {
	private Zustand akt_zustand;
	
	public void changeZustand(Zustand z) {
		this.akt_zustand = z;
	}
	
	public Song(String name) {
		this.changeZustand(new Played(this));
		System.out.println("Song with the name " + name + " is created!");
	}
	
	public void play() {
		this.akt_zustand.play();
	}

	public void stop() {
		this.akt_zustand.stop();
	}

	public void pause() {
		this.akt_zustand.pause();
	}
}
