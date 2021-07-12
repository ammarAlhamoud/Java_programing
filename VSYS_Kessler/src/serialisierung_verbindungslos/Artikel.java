package serialisierung_verbindungslos;

import java.io.Serializable;

public class Artikel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int		ID;
	private String	Name;
	private double	Preis;
	private Datum	Haltbar;

	public Artikel() {
		this.setID(0);
		this.setName(null);
		this.setPreis(0);
		this.setHaltbar(null);
	}

	public Artikel(int i, String s, double d, Datum h) {
		this.setID(i);
		this.setName(s);
		this.setPreis(d);
		this.setHaltbar(h);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public Datum getHaltbar() {
		return Haltbar;
	}

	public void setHaltbar(Datum haltbar) {
		Haltbar = haltbar;
	}

	public void ausgeben() {
		System.out.println("\tId: " + this.ID);
		System.out.println("\tName: " + this.Name);
		System.out.println("\tPreis: " + this.Preis);
		System.out.print("\tHaltbar bis: ");
		this.Haltbar.ausgeben();
	}
}
