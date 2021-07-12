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

public class SchuelerGUI extends javax.swing.JFrame
{
	Schueler neuerSchueler;
	private JTextField tfSchuelerNr;
	private JTextField tfName;
	private JTextField tfAdresse;
	private JTextField tfKlasse;

	public SchuelerGUI()
	{
		super("ADV Böblingen - Schülerdaten");
		add(new JLabel("Für einen neuen Schüler alle Daten eingeben - sonst nur die SchülerNr."), BorderLayout.NORTH);
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new GridLayout(4, 2));
		add(jPanel1, BorderLayout.CENTER);
		jPanel1.add(new JLabel("Schüler-Nr.:"));
		jPanel1.add(tfSchuelerNr = new JTextField());
		tfSchuelerNr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tfSchuelerNrActionPerformed(evt);
			}
		});
		jPanel1.add(new JLabel("Name, Vorname"));
		jPanel1.add(tfName = new JTextField());
		jPanel1.add(new JLabel("Adresse:"));
		jPanel1.add(tfAdresse = new JTextField());
		jPanel1.add(new JLabel("Klasse:"));
		jPanel1.add(tfKlasse = new JTextField());
		tfKlasse.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tfKlasseActionPerformed(evt);
			}
		});
		setSize(400, 200);
		setLocation(500, 400);
		setVisible(true);
	}

	private void tfKlasseActionPerformed(ActionEvent evt)
	{
		// hier könnte zusätzlich noch geprüft werden, ob es einen Schüler mit dieser 
		// SchülerNr. schon gibt
		neuerSchueler = new Schueler(tfSchuelerNr.getText(), tfName.getText(), tfAdresse.getText());
		Klasse klasse = ADV.suchenKlasse(tfKlasse.getText());
		if (klasse == null)
			System.out.println("Klasse " + tfKlasse.getText() + " ex. nicht");
		else
		{
			klasse.hinzufügenSchüler(neuerSchueler);
			neuerSchueler.zuordnenKlasse(klasse);
			System.out.println("Schüler wurd neu angelegt");
		}
	}

	private void tfSchuelerNrActionPerformed(ActionEvent evt)
	{
		Klasse klasse = ADV.suchenKlasse(tfSchuelerNr.getText().substring(0, 3));
		if (klasse == null)
			System.out.println("Klasse " + tfKlasse.getText() + " ex. nicht");
		else
		{
			Schueler schueler = klasse.suchenSchüler(tfSchuelerNr.getText());
			if (schueler == null)
				System.out.println("Schüler " + tfSchuelerNr.getText()	+ " ex. nicht");
			else
			{
				tfName.setText(schueler.getName());
				tfAdresse.setText(schueler.getAdresse());
				tfKlasse.setText(tfSchuelerNr.getText().substring(0, 3));
			}
		}
	}
}
