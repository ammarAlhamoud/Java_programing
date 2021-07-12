package Observer_Pattern_Aufgabe_Diagramme_Vorlage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JFrame;

public class DatenView1 extends JFrame implements Observer
{
	Daten modell;
	private int hoeheBalken1, hoeheBalken2, hoeheBalken3, hoeheBalken4;

	public DatenView1(String titel)
	{
		setTitle(titel);
	}

	public void update(Observable obj, Object arg)
	{
		modell = (Daten) obj;
		hoeheBalken1 = modell.getAnteilArb();
		hoeheBalken2 = modell.getAnteilAng();
		hoeheBalken3 = modell.getAnteilB();
		hoeheBalken4 = modell.getAnteilSelbst();
		repaint();
	}

	public void paint(Graphics g)
	{
		super.paint(g); // um vorheriges Diagramm zu löschen, da sonst die
						// Balken nicht mehr kleiner werden können, nur größer
		g.drawString("Arbeiter", 5, 50);
		g.drawString("Angestellte", 105, 50);
		g.drawString("Beamte", 205, 50);
		g.drawString("Selbständige", 305, 50);
		
		g.setColor(Color.red);
		g.fillRect(0, 200 - hoeheBalken1, 50, hoeheBalken1);
		g.setColor(Color.green);
		g.fillRect(100, 200 - hoeheBalken2, 50, hoeheBalken2);
		g.setColor(Color.yellow);
		g.fillRect(200, 200 - hoeheBalken3, 50, hoeheBalken3);
		g.setColor(Color.black);
		g.fillRect(300, 200 - hoeheBalken4, 50, hoeheBalken4);
	}
}
