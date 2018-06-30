package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Glavni meni aplikacije.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class MenuBar extends JMenuBar {

	private JMenu fileMenu;
	private JMenuItem oMnuItm;
	private JMenuItem exit;

	/**
	 * Konstruktor kreira meni i aktivira njegove komponente.
	 */
	public MenuBar() {

		createMenuBar();
		activateMenuBar();

	}
	/**
	 * Metoda koja kreira sve komponente menia.
	 */
	private void createMenuBar() {
		fileMenu = new JMenu("File");
		add(fileMenu);
		oMnuItm = new JMenuItem("O aplikaciji...");
		exit = new JMenuItem("Exit");
		fileMenu.add(oMnuItm);
		fileMenu.addSeparator();
		fileMenu.add(exit);

	}

	/**
	 * Metoda koja postavlja listenere na komponente menia.
	 */
	private void activateMenuBar() {

		oMnuItm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				showDialog();
			}
		});


		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				System.exit(0);

			}
		});
	}
	
	/**
	 * Metoda za prikaz dialoga o aplikaciji.
	 */
	private void showDialog() {
		
		int dialogButton = JOptionPane.INFORMATION_MESSAGE;
		JOptionPane.showMessageDialog(this, "Autor: Kristijan Kaèan"+"\n"+"Sveuèilište u Zadru - Odjel za informacijske znanosti"+"\n"+
		"Kolegij: Osnove objektnog programiranja"+"\n"+"Nastavnik: dr.sc. Ante Panjkota", "Nekretnine", dialogButton);

	}


}
