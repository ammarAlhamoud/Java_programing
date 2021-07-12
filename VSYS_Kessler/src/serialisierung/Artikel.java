package serialisierung;

import java.io.Serializable;

public class Artikel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int		id;
	private String	name;
	private double	preis;

	public Artikel() {
		this.id = 0;
		this.name = null;
		this.preis = 0.0;
	}

	public Artikel(int i, String s, double d) {
		this.id = i;
		this.name = s;
		this.preis = d;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
}
