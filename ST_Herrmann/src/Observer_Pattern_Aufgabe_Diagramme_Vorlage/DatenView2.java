package Observer_Pattern_Aufgabe_Diagramme_Vorlage;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JFrame;

public class DatenView2 extends JFrame implements Observer
{
	Daten modell; 	// konkreter Beobachter muss konkretes Subjekt 'kennen',
					// um sich die aktuellen Daten von dort zu beschaffen
					// unidirektionale Bez.: konkreter Beobachter --> konkretes Subjekt
					// Variablen für prozentuale Anteile von Arbeitern, ...
	private int gradArb, gradAng, gradB, gradSelbst;

	public DatenView2(String titel)
	{
		setTitle(titel);
	}

	public void update(Observable obj, Object arg)
	{
		// type-casting: Typ Observable (wird übergeben) --> Typ Daten
		modell = (Daten) obj;
		// Beschaffen der aktuellen Daten des Modells und
		// errechnen Gradmass für die prozentualen Anteile als Voraussetzung
		// zum Zeichnen der Kreis-Segmente
		gradArb = (int) ((modell.getAnteilArb() / 100.) * 360);
		gradAng = (int) ((modell.getAnteilAng() / 100.) * 360);
		gradB = (int) ((modell.getAnteilB() / 100.) * 360);
		gradSelbst = (int) ((modell.getAnteilSelbst() / 100.) * 360);
		repaint(); // ruft automatisch paint auf
	}

	public void paint(Graphics g)
	{
		super.paint(g); // bei Kreis-Diagramm auch nötig, obwohl das neue Diagramm
		// Diagramm genau darüber gezeichnet wird. 
		// Der Hintergrund ist sonst durchsichtig!
		g.drawString("prozentuale Anteile", 5, 50);
		g.drawString("Arbeiter - rot", 250, 60);
		g.drawString("Angestellte - grün", 250, 70);
		g.drawString("Beamte - gelb", 250, 80);
		g.drawString("Selbständige - schwarz", 250, 90);
		
		// zeichnen der Kreis-Segmente
		g.setColor(Color.red);
		g.fillArc(100, 100, 100, 100, 0, gradArb);
		g.setColor(Color.green);
		g.fillArc(100, 100, 100, 100, gradArb, gradAng);
		g.setColor(Color.yellow);
		g.fillArc(100, 100, 100, 100, gradArb + gradAng, gradB);
		g.setColor(Color.black);
		g.fillArc(100, 100, 100, 100, gradArb + gradAng + gradB, gradSelbst);
	}
}
