package CommandPattern;

public class PräsedintTische {
	
	public void Grüßen() {
		System.out.println("Ich grüße Ihnen, Herr Präsident");
	}
	
	public void servieren() {
		System.out.println("Zum Essen haben wir für Sie Spezielle Tisch vorbereitet."
				+ "\nAuf dem Tisch werden folgende Gerichte serviert");
		System.out.println("\tRussische Salad\n\tPommis\n\tLasagna\n\tGrill Fleich\n\tHommus\n\tCherey Bier");
	}
	
	public void verabschieden() {
		System.out.println("Danke Herr Präsident für Ihre Besuch, wir hoofen, dass Sie mit unserem Service zufrieden sind");
	}

}
