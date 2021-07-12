package FactoryMethod;

public abstract class Dokument {
	
	private int belegnummer;
	private Rechnungstype type = null;
	
	public Dokument(int nr, Rechnungstype t) {
		this.belegnummer = nr;
		this.type = t;
	}
	
	public int getBelegnummer(){
		return belegnummer;
		}
	
	public void setBelegnummer(int belegnummer){
		if(belegnummer> 0)
			this.belegnummer= belegnummer;
		}

}
