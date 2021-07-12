package advVerwaltung_kallenberg;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.concurrent.Flow;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NeueKlasseGUI extends javax.swing.JFrame {
    // unidirektionale Beziehung zu Klasse
    private Klasse neueKlasse;
    private JTextField tfKlLehrer;
    private JTextField tfKlBez;
    private JTextField tfRaum;

    public NeueKlasseGUI() {
        super("Anlegen einer neuen Klasse");
        // verschachteltes Layout definieren: BorderLayout mit Panel "center", das ein
        // GridLayout enthält
        this.setLayout(new BorderLayout());
        Panel center = new Panel();
        center.setLayout(new GridLayout(3, 2));

        center.add(new JLabel("Klassenbezeichnung:"));
        center.add(tfKlBez = new JTextField());
        center.add(new JLabel("Klassenlehrer(in):"));
        center.add(tfKlLehrer = new JTextField());
        center.add(new JLabel("Raum:"));
        center.add(tfRaum = new JTextField());
        tfRaum.addActionListener(evt -> {
            tfRaumActionPerformed(evt);
            NeueKlasseGUI.this.dispose(); // damit Fenster wieder verschwindet
        });

        this.add(new JLabel("Bitte geben Sie die folgenden Daten ein:"), BorderLayout.NORTH);
        this.add(BorderLayout.CENTER, center);
        this.setSize(400, 200);
        this.setLocation(0, 400);
        this.setVisible(true);
    }

    private void tfRaumActionPerformed(ActionEvent evt) {
        // zusätzlich könnte vorher noch geprüft werden, ob der Benutzer - wie
        // aufgefordert - alle Angaben gemacht hat
        String klassenBezeichnung = tfKlBez.getText();
        String klassenLehrer = tfKlLehrer.getText();
        String raum = tfRaum.getText();

        if (klassenBezeichnung == null || klassenLehrer == null || raum == null) {
            System.out.println("Alle Werte müssen gefüllt sein!");
        }

        neueKlasse = new Klasse(klassenBezeichnung, raum, klassenLehrer);

        ADV.hinzufügenKlasse(neueKlasse);
        // Fenster soll stehen bleiben, um evtl. weitere Klassen hinzuzufügen
    }
}
