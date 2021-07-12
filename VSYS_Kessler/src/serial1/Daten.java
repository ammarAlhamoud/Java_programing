package serial1;

public class Daten {

	private static final String	Trenner = "_";

	private int		Id;
	private String	Name;
	private double	Preis;

	public Daten(int i, String s, double d) {
		this.Id = i;
		this.Name = s;
		this.Preis = d;
	}

	public Daten(byte[] b, int l) {
		String		Gesamt = new String(b, 0, l);
		String[]	Komponenten = Gesamt.split(Daten.Trenner);
		this.Id = Integer.parseInt(Komponenten[0]);
		this.Preis = Double.parseDouble(Komponenten[1]);
		this.Name = Komponenten[2];
	}

	public void ausgeben() {
		System.out.println("\tId: " + this.Id);
		System.out.println("\tName: " + this.Name);
		System.out.println("\tPreis: " + this.Preis);
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPreis() {
		return Preis;
	}
	public void setPreis(double preis) {
		Preis = preis;
	}

	public byte[] getBytes() {
		Integer	i = this.Id;
		Double	d = this.Preis;
		String	Gesamt = i.toString() + Daten.Trenner + d.toString() + Daten.Trenner + this.Name;
		return Gesamt.getBytes();
	}

}
