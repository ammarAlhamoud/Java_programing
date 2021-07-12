package advVerwaltung_kallenberg;


import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;

public class AnzahlGUI extends javax.swing.JFrame {
    private JTextField tfKlassen;
    private JTextField tfAnzSchueler;
    // Bem. bzgl. JLabels s. Klasse ADVDatenGUI

    public AnzahlGUI() {
        super("Klassen / Schüler");
        // Layout?
        this.setLayout(new GridLayout(2, 2));

        add(new JLabel("Anzahl Klassen:"));
        // für die Inhalte der Textfelder wird auf die Klassenmethoden der Klasse ADV
        // zugegriffen, um die Informationen zu beschaffen
        add(tfKlassen = new JTextField(String.valueOf(ADV.getAnzahlKlassen())));

        add(new JLabel("Anzahl Schüler:"));
        add(tfAnzSchueler = new JTextField(String.valueOf(ADV.getAnzahlSchüler())));

        setSize(400, 150);
        setLocation(500, 200);
        setVisible(true);
    }
}
