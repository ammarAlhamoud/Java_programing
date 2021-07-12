package advVerwaltung_sprecher;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class SchuelerLoeschGUI extends javax.swing.JFrame
{
	private JTextField tfSchuelerNr;

	public SchuelerLoeschGUI()
	{
		super();
		setLayout(new FlowLayout());
		add(new JLabel("Geben Sie die Sch�lerNr. des zu l�schenden Sch�lers ein:"));
		add(tfSchuelerNr = new JTextField(5));
		tfSchuelerNr.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tfSchuelerNrActionPerformed(evt);
			}
		});
		setSize(400, 150);
		setLocation(500, 400);
		setVisible(true);
	}

	private void tfSchuelerNrActionPerformed(ActionEvent evt)
	{
		String sch�lerNr = tfSchuelerNr.getText();
		Klasse klasse = ADV.suchenKlasse(sch�lerNr.substring(0, 3));
		if (klasse == null)
			System.out.println("Klasse " + sch�lerNr.substring(0, 3)+ " ex. nicht");
		else
		{
			if (klasse.l�schenSch�ler(sch�lerNr))
				System.out.println("Sch�ler mit Sch�lerNr. " + sch�lerNr + " gel�scht");
			else
				System.out.println("zu l�schender Sch�ler "	+ tfSchuelerNr.getText() + " ex. nicht");
		}
		tfSchuelerNr.setText("");
	}
}
