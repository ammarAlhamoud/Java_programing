package advVerwaltung_kallenberg;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends javax.swing.JFrame {
    // unidirektionale Assoziationen zu den anderen GUI-Klassen
    ADVDatenGUI advDatenGUI;
    AlleSchuelerGUI alleSchuelerGUI;
    AnzahlGUI anzahlGUI;
    NeueKlasseGUI neueKlasseGUI;
    SchuelerGUI schuelerGUI;
    SchuelerLoeschGUI schuelerLoeschGUI;

    private JMenuBar menueLeiste;
    private JMenu advInf;
    private JMenu klassse;
    private JMenu schueler;
    // Menüpunkte zu ADV-Informationen
    private JMenuItem daten;
    private JMenuItem anzahl;
    // Menüpunkte zu Klasse
    private JMenuItem alleSchueler;
    private JMenuItem neu;
    // Menüpunkte zu Klasse
    private JMenuItem anzeigen;
    private JMenuItem neuAufnahme;
    private JMenuItem loeschen;

    public Menu() {
        // Bei Auswahl eines Menüpunktes werden jeweils Objekte der entsprechenden
        // GUI-Klassen erzeugt
        super("Akademie für Datenverarbeitung, Böblingen");
        // Schliessen des Menü-Fensters soll auch gleichzeitig das Programm beenden
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());
        JMenuBar menueLeiste = new JMenuBar();
        setJMenuBar(menueLeiste);
        advInf = new JMenu("ADV-Informationen");
        menueLeiste.add(advInf);
        daten = new JMenuItem("Daten anzeigen");
        advInf.add(daten);

        // wg. wenig umfangreicher Implementierung bei dieser Aufgabe: INLINE-methods für event-handling
        daten.addActionListener(evt -> advDatenGUI = new ADVDatenGUI());
        anzahl = new JMenuItem("Anzahl Klassen/Schüler");
        advInf.add(anzahl);
        anzahl.addActionListener(evt -> anzahlGUI = new AnzahlGUI());
        klassse = new JMenu("Klasse");
        menueLeiste.add(klassse);
        alleSchueler = new JMenuItem("alle Schüler");
        klassse.add(alleSchueler);
        alleSchueler.addActionListener(evt -> alleSchuelerGUI = new AlleSchuelerGUI());
        neu = new JMenuItem("neue Klasse");
        klassse.add(neu);
        neu.addActionListener(evt -> {
            neueKlasseGUI = new NeueKlasseGUI();
        });
        schueler = new JMenu("Schüler");
        menueLeiste.add(schueler);
        anzeigen = new JMenuItem("Schülerdaten anzeigen");
        schueler.add(anzeigen);
        anzeigen.addActionListener(evt -> schuelerGUI = new SchuelerGUI());
        neuAufnahme = new JMenuItem("neu aufnehmen");
        schueler.add(neuAufnahme);
        neuAufnahme.addActionListener(evt -> schuelerGUI = new SchuelerGUI());
        loeschen = new JMenuItem("löschen");
        schueler.add(loeschen);
        loeschen.addActionListener(evt -> schuelerLoeschGUI = new SchuelerLoeschGUI());
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setSize(400, 300);
        menu.setVisible(true);
    }
}
