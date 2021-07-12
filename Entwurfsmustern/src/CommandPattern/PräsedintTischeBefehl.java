package CommandPattern;

public class PräsedintTischeBefehl implements Service_Befehl{
	
	private PräsedintTische Tisch;
	
	public PräsedintTischeBefehl(PräsedintTische tisch) {
		this.Tisch = tisch;
	}
	
	@Override
	public void servieren() {
		Tisch.Grüßen();
		Tisch.servieren();
		Tisch.verabschieden();
	}
	

}
