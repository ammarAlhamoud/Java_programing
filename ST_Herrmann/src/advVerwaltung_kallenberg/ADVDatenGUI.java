package advVerwaltung_kallenberg;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;

public class ADVDatenGUI extends javax.swing.JFrame {
    private JTextField tfEmail;
    private JTextField tfTel;
    private JTextField tfAdresse;
    private JTextField tfBez;
    // JLabel-Objekte müssen NICHT Attribute der Klasse sein, da sie keine
    // relevante Bedeutung für die Anwendung haben

    public ADVDatenGUI() {
        super("ADV Böblingen - Informationen");
        // Layout?
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
