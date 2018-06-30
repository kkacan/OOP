package gui;

import javax.swing.SwingUtilities;

import gui.MainFrame;

/**
 * Glavna klasa koja pokreæe aplikaciju i otvara MainFrame.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class App {

	public static void main(String[] args) {
		
			SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				new MainFrame();
			}
		});
	}

}
