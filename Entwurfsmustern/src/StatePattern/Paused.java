package StatePattern;

public class Paused implements Zustand{

	private Song akt_song;
	
	public Paused(Song s) {
		this.akt_song = s;
	}
	
	@Override
	public void play() {
		this.akt_song.changeZustand(new Played(this.akt_song));
		System.out.println("Song was paused and now it is played");		
	}

	@Override
	public void stop() {
		this.akt_song.changeZustand(new Stoped(this.akt_song));
		System.out.println("Song was paused and now it is stoped");
	}

	@Override
	public void pause() {
		System.out.println("Song is already paused ..");	
	}

}
