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

public class ADVDatenGUI extends javax.swing.JFrame
{
	private JTextField tfEmail;
	private JTextField tfTel;
	private JTextField tfAdresse;
	private JTextField tfBez;
	// JLabel-Objekte müssen nicht Attribute der Klasse sein, da sie keine
	// relevante Bedeutung
	// für die Anwendung haben
	
	public ADVDatenGUI()
	{
		super("ADV Böblingen - Informationen");
		setLayout(new GridLayout(4, 2));
		add(new JLabel("Bezeichnung:"));
		add(tfBez = new JTextField(ADV.getBezeichnung()));
		add(new JLabel("Adresse"));
		add(tfAdresse = new JTextField(ADV.getAdresse()));
		add(new JLabel("Tel.:"));
		add(tfTel = new JTextField(ADV.getTelNr()));
		add(new JLabel("email-Adresse:"));
		add(tfEmail = new JTextField(ADV.getEmail()));
		setSize(400, 200);
		setLocation(500, 400);
		setVisible(true);
	}
}
