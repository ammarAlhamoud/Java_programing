package CommandPattern;

public class VIP_TischBefehl implements Service_Befehl{

	private VIP_Tisch Tisch;
	
	public VIP_TischBefehl(VIP_Tisch tisch) {
		this.Tisch = tisch;
	}
	
	@Override
	public void servieren() {
		Tisch.Gr��en();
		Tisch.servieren();
		Tisch.verabschieden();
	}
	
	

}
