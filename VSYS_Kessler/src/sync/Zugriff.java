package sync;

public class Zugriff implements Runnable {

	private Objekt	Obj;
	private String	Text;

	public Zugriff(Objekt O, String T) {
		this.Obj = O;
		this.Text = T;
	}

	public void run() {
		this.Obj.bearbeiten(this.Text);
	}
}
