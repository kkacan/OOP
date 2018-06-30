package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Stranka;

/**
 * Glavni panel za unos podataka.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */

public class FormPanel extends JPanel {

	private FormListener formLst;
	private JButton btnSpremi;
	
	private JPanel left;
	private JPanel right;
	
	private JLabel lblIme;
	private JLabel lblAdresa;
	private JLabel lblTel;
	private JLabel lblEmail;

	private JTextField imeField;
	private JTextField adresaField;
	private JTextField telField;
	private JTextField emailField;

	private JButton btnSpremiStranku;
	
	private JLabel lblStranka;
	private JLabel lblVrsta;
	private JLabel lblMjesto;
	private JLabel lblUlica;
	private JLabel lblCijena;
	private JLabel lblVrstaPon;
	
	private JComboBox strankaCombo;
	private JComboBox vrstaCombo;
	private JComboBox vrstaPonCombo;
		
	
	private JTextField mjestoField;
	private JTextField ulicaField;
	private JTextField cijenaField;
	private JTextField vrstaPonField;
	
	private DefaultComboBoxModel comboModelStranka;
	private DefaultComboBoxModel comboModel;
	private DefaultComboBoxModel comboPonModel;
	
	private boolean ponuda=true;
	

	public FormPanel() {

		setFormLayout();
		createFormComp();
		leftPanel();
		rightPanel();
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.CENTER);
		layoutComponentsLeft();
		layoutComponentsRight();
		activateLeftForm();
		activateRightForm();
		
	}

	/**
	 * Metoda kojom se kreira suèelje desnog panela.
	 */
	private void layoutComponentsRight() {
		right.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		right.add(lblIme, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(imeField, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		right.add(lblAdresa, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(adresaField, gbc);		
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		right.add(lblTel, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(telField, gbc);

		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		right.add(lblEmail, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(emailField, gbc);
		


		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(btnSpremiStranku, gbc);
		
	}
	/**
	 * Metoda kojom se kreira suèelje lijevog panela.
	 */
	private void layoutComponentsLeft() {
		
		left.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblStranka, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(strankaCombo, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblVrsta, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(vrstaCombo, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblVrstaPon, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(vrstaPonCombo, gbc);		
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblMjesto, gbc);

		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(mjestoField, gbc);

		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblUlica, gbc);

		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(ulicaField, gbc);
		
		///////////////////// Fourth Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(lblCijena, gbc);

		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(cijenaField, gbc);

		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(btnSpremi, gbc);
		
	}
	
	/**
	 * Metoda koja postavlja obrub i dimenzije lijevog panela.
	 */
	private void leftPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Nova nekretnina");
		left.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = getPreferredSize();
		dim.width = 500;
		left.setPreferredSize(dim);
	}

	/**
	 * Metoda koja postavlja obrub i dimenzije desnog panela.
	 */
	private void rightPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Nova stranka");
		right.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = left.getPreferredSize();
		dim.width = 500;
		right.setPreferredSize(dim);
	}

	/**
	 * Metoda koja postavlja layout i dimenzije panela.
	 */
	private void setFormLayout() {

		setLayout(new BorderLayout());
		Dimension dim = getPreferredSize();
		dim.height = 240;
		setPreferredSize(dim);
	}

	/**
	 * Metoda koja inicijalizira sve elemente panela.
	 */
	private void createFormComp() {

				
		left = new JPanel();
		right = new JPanel();
		
		lblStranka = new JLabel("Stranka: ");
		lblVrsta = new JLabel("Vrsta nekretnine: ");
		lblMjesto = new JLabel("Mjesto: ");
		lblUlica = new JLabel("Ulica i kuæni broj: ");
		lblCijena = new JLabel("Cijena nekretnine: ");
		lblVrstaPon = new JLabel("Vrsta Ponude: ");
 
		mjestoField = new JTextField(10);
		ulicaField = new JTextField(10);
		cijenaField = new JTextField(10);
		btnSpremi = new JButton("Spremi");
		
		
		strankaCombo = new JComboBox();
		comboModelStranka = new DefaultComboBoxModel();
		comboModelStranka.addElement("          ");
		strankaCombo.setModel(comboModelStranka);
		strankaCombo.setSelectedIndex(0);
		
		
		
		vrstaCombo = new JComboBox();
		comboModel = new DefaultComboBoxModel();
		comboModel.addElement("Kuæa");
		comboModel.addElement("Stan");
		comboModel.addElement("Apartman");
		comboModel.addElement("Poslovni prostor");
		comboModel.addElement("Zemljište");
		vrstaCombo.setModel(comboModel);
		vrstaCombo.setSelectedIndex(0);
		
		vrstaPonCombo = new JComboBox();
		comboPonModel = new DefaultComboBoxModel();
		comboPonModel.addElement("Prodaja");
		comboPonModel.addElement("Zamjena");
		comboPonModel.addElement("Najam");
		vrstaPonCombo.setModel(comboPonModel);
		vrstaPonCombo.setSelectedIndex(0);
		
		lblIme = new JLabel("Ime i prezime: ");
		lblAdresa = new JLabel("Adresa: ");
		lblTel = new JLabel("Telefon: ");
		lblEmail = new JLabel("Email: ");
		
 
		imeField = new JTextField(10);
		adresaField = new JTextField(10);
		telField = new JTextField(10);
		emailField = new JTextField(10);
		btnSpremi = new JButton("Spremi");
		
		btnSpremiStranku = new JButton("Spremi stranku");
		
	}

	/**
	 * Metoda koja postavlja FormListener.
	 * @param listener FormListener
	 */
	public void setFormListener(FormListener listener) {

		this.formLst = listener;
	}
	
	/**
	 * Metoda koja postavlja listener na botun lijevog panela.
	 */
	private void activateLeftForm() {

		btnSpremi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String vrsta = (String) vrstaCombo.getSelectedItem();
				String mjesto = mjestoField.getText();
				String ulica = ulicaField.getText();
				String cijena = cijenaField.getText();
				String vrstaPon = (String) vrstaPonCombo.getSelectedItem();
				String imeStranke = (String) strankaCombo.getSelectedItem();
				
				if (vrsta.equals("") | mjesto.equals("") | ulica.equals("") | cijena.equals("") | vrstaPon.equals("") | imeStranke.equals("          ")) {
					
					showDialog();
					return;
				}

				LeftFormEvent lfe = new LeftFormEvent(this);
				
				lfe.setVrstaNekretnine(vrsta);
				lfe.setMjesto(mjesto);
				lfe.setUlica(ulica);
				lfe.setCijena(cijena);
				lfe.setVrstaPonude(vrstaPon);
				lfe.setImeStranke(imeStranke);
				lfe.setPonuda(ponuda);
				

				if (formLst != null) {
				
					formLst.leftPanelEventOccured(lfe);

				}
				
				resetLeftForm();
				

			}
		});
	}
	
	/**
	 * Metoda koja postavlja listener na botun desnog panela.
	 */
	private void activateRightForm() {
		btnSpremiStranku.addActionListener(new ActionListener() {

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
				


				if (formLst != null) {

					formLst.rightPanelEventOccured(rfe);

				}
				
				resetRightForm();

			}
		});
		
	}
	
	/**
	 * Metoda koja resetira sva polja desnog panela.
	 */
	private void resetRightForm() {
		
		imeField.setText("");
		adresaField.setText("");
		telField.setText("");
		emailField.setText("");
		
	}
	
	/**
	 * Metoda koja resetira sva polja lijevog panela.
	 */
	private void resetLeftForm() {
		
		vrstaCombo.setSelectedIndex(0);
		mjestoField.setText("");
		ulicaField.setText("");
		cijenaField.setText("");
		vrstaPonCombo.setSelectedIndex(0);
		strankaCombo.setSelectedIndex(0);
	}
	
	/**
	 * Metoda koja ažurira vrste ponuda u zavisnosti o tipu ponude.
	 * @param ponuda definira da li je tip ponuda ili potražnja
	 */
	public void updateVrstaCombo(boolean ponuda) {
		
		this.ponuda=ponuda;
		
		if (ponuda) {
			comboPonModel = new DefaultComboBoxModel();
			comboPonModel.addElement("Prodaja");
			comboPonModel.addElement("Zamjena");
			comboPonModel.addElement("Najam");
			vrstaPonCombo.setModel(comboPonModel);
			vrstaPonCombo.setSelectedIndex(0);
		} else {
			comboPonModel = new DefaultComboBoxModel();
			comboPonModel.addElement("Kupnja");
			comboPonModel.addElement("Zamjena");
			comboPonModel.addElement("Najam");
			vrstaPonCombo.setModel(comboPonModel);
			vrstaPonCombo.setSelectedIndex(0);
		}
		
		
	}
	
	/**
	 * Metoda koja ažurira listu stranaka u ComboBoxu.
	 * @param stranke ArrayList stranke
	 */
	public void updateStrankeCombo(List<Stranka> stranke) {
		
		comboModelStranka.removeAllElements();
		for (int i=0; i<stranke.size();i++) {
			comboModelStranka.addElement(stranke.get(i).getImePrezime());
		}
	}

	/**
	 * Metoda koja onemoguæuje spremanje nove nekretnine u zavisnosti od položaja prikaza tablice.
	 * Ako je prikaz tablice na strankama onda je unos nove nekretnine onemoguæen.
	 */
	public void disableSpremiBtn() {
		
		btnSpremi.setEnabled(false);
	}
	/**
	 * Metoda koja omoguæuje spremanje nove nekretnine u zavisnosti od položaja prikaza tablice.
	 * Ako je prikaz tablice na nekretninama onda je unos nove nekretnine omoguæen.
	 */
	public void enableSpremiBtn() {
		
		btnSpremi.setEnabled(true);
	}
	
	/**
	 * Metoda koja prikazuje dialog ako nisu uneseni svi potrebni podaci.
	 */
	private void showDialog() {
		
		int dialogButton = JOptionPane.INFORMATION_MESSAGE;
		JOptionPane.showMessageDialog(this, "Nisu uneseni svi podaci!", "Nekretnine", dialogButton);

	}
	



}