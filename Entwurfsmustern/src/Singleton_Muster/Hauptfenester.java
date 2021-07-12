package Singleton_Muster;

import java.awt.Frame;
import java.awt.Point;

public class Hauptfenester {
	private static int x;
	private static int y;
	private static Hauptfenester instanz = new Hauptfenester(200, 300);

	private  Hauptfenester (int x, int y) {
		Frame wnd = new Frame("Einfaches Fenster"); 
		wnd.setSize(400,300);
		Point location = new Point();
		location.x = x;
		location.y = y;
		wnd.setLocation(location);
		wnd.setVisible(true);
		Point p = wnd.getLocation();
		this.x = p.x;
		this.y = p.y;
	}
	   
	public static Hauptfenester gibInstanz() {
		System.out.println("Ein Fenester mit dem Koordinaten (x, y) = ("
				+ x + ", " + y +") wurde erstellt");
		return instanz;
	}


}
