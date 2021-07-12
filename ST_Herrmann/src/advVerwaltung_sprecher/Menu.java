package advVerwaltung_sprecher;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */

// generierte Codierung wurde vereinfacht!

public class Menu extends javax.swing.JFrame
{
	// unidirektionale Assoziationen zu den anderen GUI-Klassen
	ADVDatenGUI advDaten;
	AnzahlGUI advAnzahl;
	AlleSchuelerGUI advAlleSchueler;
	NeueKlasseGUI neueKlasse;
	SchuelerGUI einSchueler;
	SchuelerLoeschGUI loeschenSchueler;
	
	private JMenuBar menueLeiste;
	private JMenu advInf;
	private JMenu klassse;
	private JMenu schueler;
	// Menüpunkte zu ADV-Informationen
	private JMenuItem daten;
	private JMenuItem anzahl;
	// Menüpunkte zu Klasse
	private JMenuItem alleSchueler;
	private JMenuItem neu;
	// Menüpunkte zu Klasse
	private JMenuItem anzeigen;
	private JMenuItem neuAufnahme;
	private JMenuItem loeschen;
	
	public Menu()
	{
		// Bei Auswahl eines Menüpunktes werden jeweils Objekte der entsprechenden
		// GUI-Klassen erzeugt
		super("Akademie für Datenverarbeitung, Böblingen");
		// Schliessen des Menü-Fensters soll auch gleichzeitig das Programm beenden
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		JMenuBar menueLeiste = new JMenuBar();
		setJMenuBar(menueLeiste);
		advInf = new JMenu("ADV-Informationen");
		menueLeiste.add(advInf);
		daten = new JMenuItem("Daten anzeigen");
		advInf.add(daten);
		
		// wg. wenig umfangreicher Implementierung bei dieser Aufgabe: INLINE-methods für event-handling
		daten.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				advDaten = new ADVDatenGUI();
				
			}
		});
		anzahl = new JMenuItem("Anzahl Klassen/Schüler");
		advInf.add(anzahl);
		anzahl.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				advAnzahl = new AnzahlGUI();
			}
		});
		klassse = new JMenu("Klasse");
		menueLeiste.add(klassse);
		alleSchueler = new JMenuItem("alle Schüler");
		klassse.add(alleSchueler);
		alleSchueler.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				advAlleSchueler = new AlleSchuelerGUI();
			}
		});
		neu = new JMenuItem("neue Klasse");
		klassse.add(neu);
		neu.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				neueKlasse = new NeueKlasseGUI();
			}
		});
		schueler = new JMenu("Schüler");
		menueLeiste.add(schueler);
		anzeigen = new JMenuItem("Schülerdaten anzeigen");
		schueler.add(anzeigen);
		anzeigen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				einSchueler = new SchuelerGUI();
			}
		});
		neuAufnahme = new JMenuItem("neu aufnehmen");
		schueler.add(neuAufnahme);
		neuAufnahme.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				einSchueler = new SchuelerGUI();
			}
		});
		loeschen = new JMenuItem("löschen");
		schueler.add(loeschen);
		loeschen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				loeschenSchueler = new SchuelerLoeschGUI();
			}
		});
	}
	
	public static void main(String[] args)
	{
		Menu menu = new Menu();
		menu.setSize(400, 300);
		menu.setVisible(true);
	}
}
