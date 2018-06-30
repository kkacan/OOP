package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controller.Controller;
import model.Nekretnina;
import model.Stranka;

/**
 * Dialog za izmjenu podataka nekretnine.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class NekretninaDialog extends JDialog {

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
	
	private DefaultComboBoxModel comboModelStranka;
	private DefaultComboBoxModel comboModel;
	private DefaultComboBoxModel comboPonModel;
	
	private JButton btnCancel;
	private JButton btnSpremi;
	private NekretninaDialogListener diListener;
	
	private int index;
	
	/**
	 * Konstruktor kreira dialog, postavlja velièinu i aktivira njegove komponente.
	 * @param parent klasa iz koje je pozvan dialog
	 */
	public NekretninaDialog(JFrame parent) {
		super(parent, "Izmjena nekretnine", false);
		createComp();
		layoutComp();
		activateDialog();
		setSize(500, 300);
		setLocationRelativeTo(null);
	}

	/**
	 * Metoda koja inicijalizira sve komponente dialoga.
	 */
	private void createComp() {

		
		btnCancel = new JButton("Odustani");
		btnSpremi = new JButton("Spremi");
		lblStranka = new JLabel("Stranka: ");
		lblVrsta = new JLabel("Vrsta nekretnine: ");
		lblMjesto = new JLabel("Mjesto: ");
		lblUlica = new JLabel("Ulica i kuæni broj: ");
		lblCijena = new JLabel("Cijena nekretnine: ");
		lblVrstaPon = new JLabel("Vrsta Ponude: ");
 
		mjestoField = new JTextField(10);
		ulicaField = new JTextField(10);
		cijenaField = new JTextField(10);
		
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
		add(lblStranka, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(strankaCombo, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblVrsta, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(vrstaCombo, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblVrstaPon, gbc);
		
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(vrstaPonCombo, gbc);		
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblMjesto, gbc);
		
		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(mjestoField, gbc);
		
		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblUlica, gbc);
		
		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(ulicaField, gbc);
		
		///////////////////// Fourth Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblCijena, gbc);
		
		gbc.gridx = 3;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(cijenaField, gbc);
		
		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnSpremi, gbc);
		
		gbc.gridx = 3;
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
				
				if (diListener != null) {
					
					diListener.nekretninaDialogEventOccured(lfe, index);

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
	 * Metoda koja postavlja NekretninaDialogListener.
	 * @param lst NekretninaDialogListener
	 */
	public void setDialogListener(NekretninaDialogListener lst) {
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
	 * Metoda koja uèitava podatke o odabranoj nekretnini.
	 * @param cntrl kontroler za komunikaciju sa bazom podataka
	 * @param id id odabrane nekretnine
	 */
	public void setDialogData(Controller cntrl, int id) {
		
		Nekretnina nekretnina = null;

		for (int i = 0; i < cntrl.getDataNekretnine().size(); i++) {
			if (cntrl.getDataNekretnine().get(i).getId() == id) {
				nekretnina = cntrl.getDataNekretnine().get(i);
				this.index = i;
			}
		}
		
		updateStrankeCombo(cntrl.getDataStranke());

		if (nekretnina!=null) {
			vrstaCombo.setSelectedItem(nekretnina.getVrstaNekretnine());
			strankaCombo.setSelectedItem(nekretnina.getImeStranke());
			vrstaPonCombo.setSelectedItem(nekretnina.getVrstaPonude());
			mjestoField.setText(nekretnina.getMjesto());
			ulicaField.setText(nekretnina.getUlica());
			cijenaField.setText(nekretnina.getCijena());
		}
		
	}
	
	/**
	 * Metoda koja uèitava podatke stranaka u ComboBox.
	 * @param stranke ArrayList stranke
	 */
	private void updateStrankeCombo(List<Stranka> stranke) {
		
		for (int i=0; i<stranke.size();i++) {
			comboModelStranka.addElement(stranke.get(i).getImePrezime());
		}
	}

	
}



