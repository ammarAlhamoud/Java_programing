package advVerwaltung_kallenberg;



import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SchuelerLoeschGUI extends javax.swing.JFrame {
    private JTextField tfSchuelerNr;

    public SchuelerLoeschGUI() {
        super();
        setLayout(new FlowLayout());
        add(new JLabel("Geben Sie die SchülerNr. des zu löschenden Schülers ein:"));
        add(tfSchuelerNr = new JTextField(5));
        tfSchuelerNr.addActionListener(evt -> tfSchuelerNrActionPerformed(evt));
        setSize(400, 150);
        setLocation(500, 400);
        setVisible(true);
    }

    private void tfSchuelerNrActionPerformed(ActionEvent evt) {
        Vector<Klasse> klassen = ADV.getAlleKlassen();

        for (Klasse k : klassen) {
            for (Schueler s : k.getAlleSchueler()) {
                if (tfSchuelerNr.getText().equals(s.getSchuelerNr())) {
                    k.löschenSchüler(tfSchuelerNr.getText());
                    return;
                }
            }
        }
    }
}
