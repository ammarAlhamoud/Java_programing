package CommandPattern;

public class Pr�sedintTischeBefehl implements Service_Befehl{
	
	private Pr�sedintTische Tisch;
	
	public Pr�sedintTischeBefehl(Pr�sedintTische tisch) {
		this.Tisch = tisch;
	}
	
	@Override
	public void servieren() {
		Tisch.Gr��en();
		Tisch.servieren();
		Tisch.verabschieden();
	}
	

}
