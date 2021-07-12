package serialisierung_verbindungslos;

import java.io.Serializable;

public class Datum implements Serializable {

	private static final long serialVersionUID = 1L;

	private int		Tag;
	private int		Monat;
	private int		Jahr;

	public Datum() {
		this.setTag(0);
		this.setMonat(0);
		this.setJahr(0);
	}

	public Datum(int t, int m, int j) {
		this.setJahr(j);
		this.setMonat(m);
		this.setTag(t);
	}

	public int getTag() {
		return Tag;
	}

	public void setTag(int tag) {
		Tag = tag;
	}

	public int getMonat() {
		return Monat;
	}

	public void setMonat(int monat) {
		Monat = monat;
	}

	public int getJahr() {
		return Jahr;
	}

	public void setJahr(int jahr) {
		Jahr = jahr;
	}

	public void ausgeben() {
		System.out.printf("%02d.%02d.%4d%n", this.Tag, this.Monat, this.Jahr);
	}
}
