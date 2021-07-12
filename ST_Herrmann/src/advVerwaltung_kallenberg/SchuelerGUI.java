package advVerwaltung_kallenberg;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SchuelerGUI extends javax.swing.JFrame {
    Schueler neuerSchueler;
    private JTextField tfSchuelerNr;
    private JTextField tfName;
    private JTextField tfAdresse;
    private JTextField tfKlasse;

    public SchuelerGUI() {
        super("ADV B�blingen - Sch�lerdaten");
        // verschachteltes Layout definieren: BorderLayout mit GridLayout auf "center"
        this.setLayout(new BorderLayout());

        Panel center = new Panel();
        center.setLayout(new GridLayout(4, 2));

        this.add(new JLabel("F�r einen neuen Sch�ler alle Daten eingeben - sonst nur die Sch�lerNr"),
                BorderLayout.NORTH);

        center.add(new JLabel("Sch�ler-Nr.:"));
        center.add(tfSchuelerNr = new JTextField());
        tfSchuelerNr.addActionListener(evt -> tfSchuelerNrActionPerformed(evt));
        center.add(new JLabel("Name, Vorname"));
        center.add(tfName = new JTextField());
        center.add(new JLabel("Adresse:"));
        center.add(tfAdresse = new JTextField());
        center.add(new JLabel("Klasse:"));
        center.add(tfKlasse = new JTextField());
        tfKlasse.addActionListener(evt -> tfKlasseActionPerformed(evt));

        this.add(center, BorderLayout.CENTER);

        setSize(400, 200);
        setLocation(500, 400);
        setVisible(true);
    }

    private void tfKlasseActionPerformed(ActionEvent evt) {
        // hier k�nnte zus�tzlich noch gepr�ft werden, ob es einen Sch�ler mit dieser
        // Sch�lerNr. schon gibt
        neuerSchueler = new Schueler(tfSchuelerNr.getText(), tfName.getText(), tfAdresse.getText());
        // feststellen, ob es die angegebene Klasse gibt, dann Sch�ler hinzuf�gen
        Klasse klasse = ADV.suchenKlasse(tfKlasse.getText());
        if (klasse == null)
            System.out.println("Klasse " + tfKlasse.getText() + " ex. nicht");
        else {
            neuerSchueler.zuordnenKlasse(klasse);
            klasse.hinzuf�genSch�ler(neuerSchueler);

            System.out.println("Sch�ler wurde neu angelegt");
        }
    }

    private void tfSchuelerNrActionPerformed(ActionEvent evt) {
        // angegebene Klasse suchen
        String klNr = tfKlasse.getText();
        Klasse klasse = ADV.suchenKlasse(tfKlasse.getText());

        if (klasse == null)
            System.out.println("Klasse " + tfKlasse.getText() + " ex. nicht");
        else {
            // wenn Klasse existiert, Sch�lerdaten anzeigen, falls sie existieren
            Schueler schueler = klasse.suchenSch�ler(tfSchuelerNr.getText());

            if (schueler == null)
                System.out.println("Sch�ler " + tfSchuelerNr.getText() + " ex. nicht");
            else {
                tfName.setText(schueler.getName());
                tfAdresse.setText(schueler.getAdresse());
                tfKlasse.setText(schueler.getKlasse());
            }
        }
    }
}
