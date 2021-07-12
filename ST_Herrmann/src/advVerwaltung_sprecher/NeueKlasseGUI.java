package advVerwaltung_sprecher;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
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

public class NeueKlasseGUI extends javax.swing.JFrame
{
	// unidirektionale Beziehung zu Klasse
	
	private Klasse neueKlasse;
	private JTextField tfKlLehrer;
	private JTextField tfKlBez;
	private JTextField tfRaum;

	public NeueKlasseGUI()
	{
		super("Anlegen einer neuen Klasse");
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2));
		add(center, BorderLayout.CENTER);
		center.add(new JLabel("Klassenbezeichnung:"));
		center.add(tfKlBez = new JTextField());
		center.add(new JLabel("Klassenlehrer(in):"));
		center.add(tfKlLehrer = new JTextField());
		center.add(new JLabel("Raum:"));
		center.add(tfRaum = new JTextField());
		tfRaum.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tfRaumActionPerformed(evt);
				NeueKlasseGUI.this.dispose(); // damit Fenster wieder verschwindet
			}
		});
		add(new JLabel("Bitte geben Sie die folgenden Daten ein:"), BorderLayout.NORTH);
		setSize(400, 200);
		setLocation(0, 400);
		setVisible(true);
	}

	private void tfRaumActionPerformed(ActionEvent evt)
	{
		// zusätzlich könnte vorher noch geprüft werden, ob der Benutzer - wie aufgefordert -
		// alle Angaben gemacht hat
		neueKlasse = new Klasse(tfKlBez.getText(), tfKlLehrer.getText(), tfRaum.getText());
		if (ADV.hinzufügenKlasse(neueKlasse))
			System.out.println ("Klasse " + tfKlBez.getText() + " wurde neu angelegt");
		else System.out.println ("Klasse " + tfKlBez.getText() + " existiert bereits");
		// Fenster soll stehen bleiben, um evtl. weitere Klassen hinzuzufügen
	}
}
