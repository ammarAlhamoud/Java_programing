package abstractFacotry;

public class Klient {

	public static void main(String[] args) {
		EdlstahlFabrik edelstahl = new EdlstahlFabrik(7, 12, 20);
		edelstahl.ErzeugeBesteck(10);
		edelstahl.ErzeugeTassen(12);
		edelstahl.ErzeugeTeller(5);
		
		TitanFabrik titan = new TitanFabrik(5, 10 ,18);
		titan.ErzeugeBesteck(5);
		titan.ErzeugeTassen(7);
		titan.ErzeugeTeller(15);
		
		PlastikFabrik plastik = new PlastikFabrik(3, 8, 16);
		plastik.ErzeugeBesteck(5);
		plastik.ErzeugeTassen(7);
		plastik.ErzeugeTeller(15);
	}
	

}
