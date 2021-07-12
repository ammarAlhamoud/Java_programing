package CommandPattern;

public class NormalTischBefehl implements Service_Befehl{
	
	private NormalTisch Tisch;
	
	public NormalTischBefehl(NormalTisch tisch) {
		this.Tisch = tisch;
	}
	
	@Override
	public void servieren() {
		Tisch.servieren();
		Tisch.verabschieden();
	}
	

}
