package ObserverPattern;

public class Client {
	
	public static void main(String[] args) { 
        FAZVerlag verlag = new FAZVerlag(); 
        verlag.aboHinzufuegen(new FamilieFischer()); 
        verlag.aboHinzufuegen(new FamilieMeier()); 
        FirmaXY firma = new FirmaXY(); 
        verlag.aboHinzufuegen(firma); 

        verlag.setAktuelleZeitung(new Zeitung("Skandal!")); 

        verlag.aboEntfernen(firma); 
        verlag.setAktuelleZeitung(new Zeitung("Doch alles halb so wild!")); 
    } 

}
