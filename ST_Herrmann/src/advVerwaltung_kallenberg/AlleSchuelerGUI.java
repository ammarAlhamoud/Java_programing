package advVerwaltung_kallenberg;


import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class AlleSchuelerGUI extends javax.swing.JFrame {
    // unidirektionale Beziehung zu Klasse
    Klasse klasse;

    private JTextField tfKlBez;
    private JTextArea schuelerTA;
    // Scrollpane für TextArea definieren, damit alle Schüler sichtbar gemacht
    // werden können


    public AlleSchuelerGUI() {
        super("Alle Schüler einer Klasse anzeigen");
        // Layout?
        this.setLayout(new BorderLayout());

        Panel p = new Panel(new FlowLayout(FlowLayout.CENTER));
        p.add(new JLabel("Geben Sie die Klassenbezeichnung ein:"));
        p.add(tfKlBez = new JTextField(4));

        this.add(p, BorderLayout.NORTH);

        tfKlBez.addActionListener(evt -> tfKlBezActionPerformed(evt));
        schuelerTA = new JTextArea();
        schuelerTA.setEditable(false);
        // ScrollPane integrieren
        this.add(new JScrollPane(schuelerTA), BorderLayout.CENTER);

        setSize(400, 300);
        setLocation(500, 400);
        setVisible(true);
    }

    private void tfKlBezActionPerformed(ActionEvent evt) {
        schuelerTA.setText("");

        Klasse klasse = ADV.suchenKlasse(tfKlBez.getText());
        if (klasse == null) {
            System.out.println("Klasse " + tfKlBez.getText() + " ex. nicht");
            return;
        }

        String[] alleSchueler = klasse.getAlleSchuelerFormat();

        for (String s : alleSchueler) {
            schuelerTA.append(s + "\n");
        }
    }
}
