package deadlock;

import java.util.concurrent.locks.ReentrantLock;

public class Deadlock implements Runnable {

	private ReentrantLock	Sperre1;
	private ReentrantLock	Sperre2;
	private String			S1;
	private String			S2;
	private String			Text;
	public Deadlock(String T, ReentrantLock R1, String RS1,
			ReentrantLock R2, String RS2) {
		this.Text = T;
		this.Sperre1 = R1;
		this.Sperre2 = R2;
		this.S1 = RS1;
		this.S2 = RS2;
	}
	public void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}
	public void run() {
		System.out.println(this.Text + " ist gestartet");
		this.arbeiten();
		System.out.println(this.Text + " will " + this.S1);
		this.Sperre1.lock();
		System.out.println(this.Text + " hat " + this.S1);
		this.arbeiten();
		System.out.println(this.Text + " will " + this.S2);
		this.Sperre2.lock();
		System.out.println(this.Text + " hat " + this.S2);
		this.arbeiten();
		System.out.println(this.Text + " arbeitet");
		this.arbeiten();
		System.out.println(this.Text + " gibt " + this.S1 + " frei");
		this.Sperre1.unlock();
		System.out.println(this.Text + " gibt " + this.S2 + " frei");
		this.Sperre2.unlock();
		System.out.println(this.Text + " beendet sich");
	}
}
