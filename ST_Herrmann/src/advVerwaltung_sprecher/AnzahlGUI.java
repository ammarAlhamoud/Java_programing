package advVerwaltung_sprecher;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

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

public class AnzahlGUI extends javax.swing.JFrame
{
	private JTextField tfKlassen;
	private JTextField tfAnzSchueler;
	// Bem. bzgl. JLabels s. Klasse ADVDatenGUI
	
	public AnzahlGUI()
	{
		super("Klassen / Schüler");
		setLayout(new GridLayout(2, 2));
		add(new JLabel("Anzahl Klassen:"));
		// für die Inhalte der Textfelder wird auf die Klassenmethoden der Klasse ADV zugegriffen,
		// um die Informationen zu beschaffen
		add(tfKlassen = new JTextField("" + ADV.getAnzahlKlassen()));
		add(new JLabel("Anzahl Schüler:"));
		add(tfAnzSchueler = new JTextField("" + ADV.getAnzahlSchüler()));
		setSize(400, 150);
		setLocation(500, 0);
		setVisible(true);
	}
}
