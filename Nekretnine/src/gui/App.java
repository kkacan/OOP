package gui;

import javax.swing.SwingUtilities;

import gui.MainFrame;

/**
 * Glavna klasa koja pokre�e aplikaciju i otvara MainFrame.
 * @author Kristijan Ka�an
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
