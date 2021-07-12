package sperren;

import java.io.File;
import java.io.IOException;

public class SperreLoesung implements Runnable {

	private static String	Inhalt = "leer";

	/* GLEICHE Sperrdatei f�r alle Threads;
	 * wichtig: auch mit gleichem Objekt f�r alle ("static") */
	private static File	Datei = new File("sperre");

	private String	Name;

	public SperreLoesung(String N) {
		this.Name = N;
	}

	public static void arbeiten() {
		try { Thread.sleep(1000); } catch (InterruptedException e) { }
	}

	/* Problem dieser L�sung:
	 * Das Pr�fen ("test") und Setzen ("set") der Sperre l�uft nicht atomar ab;
	 * d.h. zwischen "exists" und "createNewFile" k�nnte ein
	 * weiterer Thread ebenfalls pr�fen und sperren! */
	public void run1() {
		System.out.println(this.Name + " gestartet");
		arbeiten();
		/* Hier sperren */
		/* In einer Schleife pr�fen, ob die Sperrdatei (noch) existiert */
		while (Datei.exists())
			arbeiten();
		/* Nach Verlassen der Schleife wird Sperrdatei angelegt */
		try {
			Datei.createNewFile();
		} catch (IOException e) { }
		System.out.println(this.Name + " schreibt: " + this.Name);
		SperreLoesung.Inhalt = this.Name;
		arbeiten();
		System.out.println(this.Name + " liest: " + SperreLoesung.Inhalt);
		/* Hier entsperren */
		/* Sperrdatei wird wieder gel�scht */
		Datei.delete();
	}

	/* Bei dieser L�sung mit direktem "createNewFile" ist "test" und
	 * "set" zwar atomar, aber nur innerhalb der Java-VM!
	 * Je nach darunterliegendem Betriebssystem kann es trotzdem
	 * Unregelm��igkeiten geben! */
	public void run2() {
		System.out.println(this.Name + " gestartet");
		arbeiten();
		/* Hier sperren */
		/* In einer Schleife versuchen die Sperrdatei anzulegen;
		 * wenn es nicht klappt (weil ein anderer schon gesperrt
		 * hat): warten und nochmal probieren; ansonsten ist gesperrt */
		try {
			while (Datei.createNewFile() != true)
				arbeiten();
		} catch (IOException e) { }
		System.out.println(this.Name + " schreibt: " + this.Name);
		SperreLoesung.Inhalt = this.Name;
		arbeiten();
		System.out.println(this.Name + " liest: " + SperreLoesung.Inhalt);
		/* Hier entsperren */
		/* Sperrdatei wird wieder gel�scht */
		Datei.delete();
	}

	public void run() {
		this.run1();
	}
}
