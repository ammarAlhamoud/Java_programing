package ObserverPattern;

public class FirmaXY implements Abonnent { 

    public void erhalteZeitung(Zeitung zeitung) { 
        System.out.println("Firma XY erhielt die aktuelle Zeitung: " + zeitung.getTitel()); 
    } 

}
