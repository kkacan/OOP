package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Controller;
import model.Stranka;

/**
 * Dialog za izmjenu podataka stranke.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class StrankaDialog extends JDialog {

	private JLabel lblIme;
	private JLabel lblAdresa;
	private JLabel lblTel;
	private JLabel lblEmail;

	private JTextField imeField;
	private JTextField adresaField;
	private JTextField telField;
	private JTextField emailField;
	
	private JButton btnCancel;
	private JButton btnSpremi;
	private StrankaDialogListener diListener;
	private int index;
	
	/**
	 * Konstruktor kreira dialog, postavlja velièinu i aktivira njegove komponente.
	 * @param parent klasa iz koje je pozvan dialog
	 */
	public StrankaDialog(JFrame parent) {
		super(parent, "Izmjena stranke", false);
		createComp();
		layoutComp();
		activateDialog();
		setSize(400, 300);
		setLocationRelativeTo(null);
	}

	/**
	 * Metoda koja inicijalizira sve komponente dialoga.
	 */
	private void createComp() {
		
		btnCancel = new JButton("Odustani");
		btnSpremi = new JButton("Spremi");
		
		lblIme = new JLabel("Ime i prezime: ");
		lblAdresa = new JLabel("Adresa: ");
		lblTel = new JLabel("Telefon: ");
		lblEmail = new JLabel("Email: ");

		imeField = new JTextField(10);
		adresaField = new JTextField(10);
		telField = new JTextField(10);
		emailField = new JTextField(10);

	}

	/**
	 * Metoda kojom se kreira suèelje dialoga.
	 */
	private void layoutComp() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblIme, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(imeField, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblAdresa, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(adresaField, gbc);		
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblTel, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(telField, gbc);
		
		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblEmail, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(emailField, gbc);
		
		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnSpremi, gbc);
		
		gbc.gridx = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnCancel, gbc);
	}

	/**
	 * Metoda koja postavlja listenere na komponente dialoga.
	 */
	private void activateDialog() {

		btnSpremi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ime = imeField.getText();
				String adresa = adresaField.getText();
				String tel = telField.getText();
				String email = emailField.getText();
				
				if (ime.equals("") | adresa.equals("") | tel.equals("") | email.equals("")) {
					
					showDialog();
					return;
				}
				

				RightFormEvent rfe = new RightFormEvent(this);
				
				rfe.setIme(ime);
				rfe.setAdresa(adresa);
				rfe.setTel(tel);
				rfe.setEmail(email);

				if (diListener != null) {
					
					diListener.strankaDialogEventOccured(rfe, index);

				}
				setVisible(false);

			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
	}

	/**
	 * Metoda koja postavlja StrankaDialogListener.
	 * @param lst StrankaDialogListener
	 */
	public void setDialogListener(StrankaDialogListener lst) {
		this.diListener = lst;
	}
	
	/**
	 * Metoda za prikaz dialoga ako nisu uneseni svi potrebni podaci.
	 */
	private void showDialog() {
		
		int dialogButton = JOptionPane.INFORMATION_MESSAGE;
		JOptionPane.showMessageDialog(this, "Nisu uneseni svi podaci!", "Nekretnine", dialogButton);

	}

	/**
	 * Metoda koja uèitava podatke o odabranoj stranci.
	 * @param cntrl kontroler za komunikaciju sa bazom podataka
	 * @param id id odabrane stranke
	 */
	public void setDialogData(Controller cntrl, int id) {
		
		Stranka stranka = null;

		for (int i = 0; i < cntrl.getDataStranke().size(); i++) {
			if (cntrl.getDataStranke().get(i).getId() == id) {
				stranka = cntrl.getDataStranke().get(i);
				this.index = i;
			}
		}


		if (stranka!=null) {

			imeField.setText(stranka.getImePrezime());
			adresaField.setText(stranka.getAdresaStanovanja());
			telField.setText(stranka.getTel());
			emailField.setText(stranka.getEmail());
			
		}
		
	}
	

	
}



