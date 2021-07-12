package StatePattern;

public class Stoped implements Zustand{

	private Song akt_song;
	
	public Stoped(Song s) {
		this.akt_song = s;
	}
	
	@Override
	public void play() {
		this.akt_song.changeZustand(new Played(this.akt_song));
		System.out.println("Song was Stoped and now it is played");		
	}

	@Override
	public void stop() {
		System.out.println("Song is already stoped ..");
	}

	@Override
	public void pause() {
		this.akt_song.changeZustand(new Paused(this.akt_song));
		System.out.println("Song was stoped and now it is paused");	
	}

}
