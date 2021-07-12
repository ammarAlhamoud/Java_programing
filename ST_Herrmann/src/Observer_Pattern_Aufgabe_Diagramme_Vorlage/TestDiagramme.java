package Observer_Pattern_Aufgabe_Diagramme_Vorlage;

public class TestDiagramme
{
    public static void main(String[] args)
    {
    // zu beobachtendes Objekt - Anfangszustand
    Daten  modell = new Daten (35, 35, 20, 10);

    // Observer
    DatenView1 view1 = new DatenView1("Balken-Diagramm");
    view1.setSize(400,200);
    view1.setLocation(50,400);
    view1.setVisible(true);

    DatenView2 view2 = new DatenView2("Kreis-Diagramm");
    view2.setSize(400,200);
    view2.setLocation(500,400);
    view2.setVisible(true);

    // für Daten-Objekt beide Observer registrieren
    modell.addObserver (view1);
    modell.addObserver (view2);


    // Test: Datenänderung
    for (int i=0; i < 5; i++)
        {
        modell.aendernDaten(20, 30, 40, 10);
        warten2Sekunden();
        modell.aendernDaten(25, 35, 30, 10);
        warten2Sekunden();
        modell.aendernDaten(30, 20, 50, 0);
        warten2Sekunden();
        modell.aendernDaten(25, 25, 40, 10);
        warten2Sekunden();
        modell.aendernDaten(50, 20, 10, 20);
        warten2Sekunden();
        }
    }

    public static void warten2Sekunden()
    {
    try
        {
        Thread.sleep(200);
        }
    catch (Exception e) {}
    }

}
