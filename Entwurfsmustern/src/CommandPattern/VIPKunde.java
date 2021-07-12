package CommandPattern;

public class VIPKunde {
	
	private Service_Befehl Serive_b;
	
	public void setServiceBefehl(Service_Befehl s) {
		this.Serive_b = s;
	}
	
	public void Service_durchführen() {
		Serive_b.servieren();
	}

}
