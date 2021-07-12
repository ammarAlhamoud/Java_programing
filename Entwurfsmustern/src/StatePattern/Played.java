package StatePattern;

public class Played implements Zustand{
	private Song akt_song;
	
	public Played(Song s) {
		this.akt_song = s;
	}

	@Override
	public void play() {
		System.out.println("Song is already played ..");
		
	}

	@Override
	public void stop() {
		this.akt_song.changeZustand(new Stoped(this.akt_song));
		System.out.println("Song was played and now it is stoped");
		
	}

	@Override
	public void pause() {
		this.akt_song.changeZustand(new Paused(this.akt_song));
		System.out.println("Song was played and now it is paused");
		
	}

}
