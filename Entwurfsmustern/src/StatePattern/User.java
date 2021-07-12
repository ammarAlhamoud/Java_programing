package StatePattern;

import java.util.concurrent.ThreadLocalRandom;

public class User {

	public static void main(String[] args) {
		
		Song S1 = new Song("Monkey dance");
		
		for(int i=0; i<10; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			switch (randomNum){
				case 1: S1.play(); break;
				case 2: S1.stop(); break;
				case 3: S1.pause(); break;
				default: S1.stop();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
		
	}

}
