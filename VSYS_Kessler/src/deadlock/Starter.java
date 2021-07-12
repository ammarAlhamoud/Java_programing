package deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Starter {

	public static void main(String[] args) {
		ReentrantLock	R1 = new ReentrantLock();
		ReentrantLock	R2 = new ReentrantLock();
		Deadlock		D1 = new Deadlock("Erster", R1, "R1", R2, "R2");
		Deadlock		D2 = new Deadlock("Zweiter", R2, "R2", R1, "R1");
		Thread			T1 = new Thread(D1);
		Thread			T2 = new Thread(D2);
		T1.start();
		T2.start();
	}

}
