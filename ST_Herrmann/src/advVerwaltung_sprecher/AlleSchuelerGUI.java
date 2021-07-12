package advVerwaltung_sprecher;


//import java.util.Vector;	// nur f�r Alternative
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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

public class AlleSchuelerGUI extends javax.swing.JFrame
{
	// unidirektionale Beziehung zu Klasse
	private Klasse klasse;
	
	private JTextField tfKlBez;
	private JTextArea schuelerTA;
	// Textarea mit Scrollpane versehen, damit alle Sch�ler sichtbar gemacht
	// werden k�nnen
	private JScrollPane scrollPane;

	public AlleSchuelerGUI()
	{
		super("Alle Sch�ler einer Klasse anzeigen");
		setLayout(new BorderLayout());
		JPanel north = new JPanel();
		add(north, BorderLayout.NORTH);
		north.add(new JLabel("Geben Sie die Klassenbezeichnung ein:"));
		north.add(tfKlBez = new JTextField(5));
		tfKlBez.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				tfKlBezActionPerformed(evt);
			}
		});
		schuelerTA = new JTextArea();
		schuelerTA.setEditable(false);
		scrollPane = new JScrollPane(schuelerTA);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 300);
		setLocation(500, 0);
		setVisible(true);
	}

	private void tfKlBezActionPerformed(ActionEvent evt)
	{
		klasse = ADV.suchenKlasse(tfKlBez.getText());
		if (klasse == null)
			System.out.println("Klasse " + tfKlBez.getText() + " ex. nicht");
		else
		{
			schuelerTA.setText("");
			String[] alleSch�ler = klasse.getAlleSch�ler();
			for (int i = 0; i < klasse.getAnzahlSch�ler(); i++)
			{
				schuelerTA.append("\n" + alleSch�ler[i]);
			}
		}
	}

//  f�r Alternative: Vector<Schueler> wurde zur�ckgegeben
//	private void tfKlBezActionPerformed(ActionEvent evt)
//	{
//		klasse = ADV.suchenKlasse(tfKlBez.getText());
//		if (klasse == null)
//			System.out.println("Klasse " + tfKlBez.getText() + " ex. nicht");
//		else
//		{
//			schuelerTA.setText("");
//			Vector<Schueler> alleSch�ler = klasse.getAlleSch�ler();
//			for (Schueler einSch�ler : alleSch�ler)
//			{
//				schuelerTA.append("\n" + einSch�ler.getSch�lerNr() + "\t"
//				+ einSch�ler.getName() + "\t" + einSch�ler.getAdresse());
//			}
//		}
//	}
}
