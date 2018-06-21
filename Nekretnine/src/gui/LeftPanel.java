package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LeftPanel extends JPanel {
	
	/*private JLabel lblVrsta;
	private JLabel lblMjesto;
	private JLabel lblUlica;
	private JLabel lblCijena;
	private JLabel lblVrstaPon;
	
	
	private JComboBox vrstaCombo;
	private JComboBox vrstaPonCombo;
		
	
	private JTextField mjestoField;
	private JTextField ulicaField;
	private JTextField cijenaField;
	private JTextField vrstaPonField;
	

	private JButton btnSpremi;
	
	private FormListener leftFormLst;
	
	public LeftPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		setBorders();
		createLeftComp();
		layoutLeft();
		activateForm();
	}
	
	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Podaci o nekretnini:");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}
	
	private void createLeftComp() {

		lblVrsta = new JLabel("Vrsta nekretnine: ");
		lblMjesto = new JLabel("Mjesto: ");
		lblUlica = new JLabel("Ulica i kuæni broj: ");
		lblCijena = new JLabel("Cijena nekretnine: ");
		lblVrstaPon = new JLabel("Vrsta Ponude: ");
 
		mjestoField = new JTextField(10);
		ulicaField = new JTextField(10);
		cijenaField = new JTextField(10);
		btnSpremi = new JButton("Spremi");
		
		vrstaCombo = new JComboBox();
		DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
		comboModel.addElement("Kuæa");
		comboModel.addElement("Stan");
		comboModel.addElement("Apartman");
		comboModel.addElement("Poslovni prostor");
		comboModel.addElement("Zemljište");
		vrstaCombo.setModel(comboModel);
		vrstaCombo.setSelectedIndex(0);
		
		vrstaPonCombo = new JComboBox();
		DefaultComboBoxModel comboPonModel = new DefaultComboBoxModel();
		comboPonModel.addElement("Prodaja");
		comboPonModel.addElement("Zamjena");
		comboPonModel.addElement("Najam");
		vrstaPonCombo.setModel(comboPonModel);
		vrstaPonCombo.setSelectedIndex(0);
		
		//txtFields= new ArrayList<JTextField>();

	}
	
	private void layoutLeft() {

		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblVrsta, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(vrstaCombo, gbc);
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblVrstaPon, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(vrstaPonCombo, gbc);		
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblMjesto, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(mjestoField, gbc);

		///////////////////// Third Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblUlica, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(ulicaField, gbc);
		
		///////////////////// Fourth Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(lblCijena, gbc);

		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(cijenaField, gbc);

		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(btnSpremi, gbc);
	}
	
	private void activateForm() {

		btnSpremi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				String vrsta = (String) vrstaCombo.getSelectedItem();
				String mjesto = mjestoField.getText();
				String ulica = ulicaField.getText();
				String cijena = cijenaField.getText();
				String vrstaPon = (String) vrstaPonCombo.getSelectedItem();

				LeftFormEvent lfe = new LeftFormEvent(this);
				
				lfe.setVrstaNekretnine(vrsta);
				lfe.setMjesto(mjesto);
				lfe.setUlica(ulica);
				lfe.setCijena(cijena);
				lfe.setVrstaPonude(vrstaPon);

				if (leftFormLst != null) {

					leftFormLst.leftPanelEventOccured(lfe);

				}
				
				//reset
				

			}
		});
	}

	public void setLeftFormList(FormListener formLst) {
		
		this.leftFormLst=formLst;
		
	}
	
	public void actionLeftPerformed() {
		
		String vrsta = (String) vrstaCombo.getSelectedItem();
		String mjesto = mjestoField.getText();
		String ulica = ulicaField.getText();
		String cijena = cijenaField.getText();
		String vrstaPon = (String) vrstaPonCombo.getSelectedItem();

		LeftFormEvent lfe = new LeftFormEvent(this);
		
		lfe.setVrstaNekretnine(vrsta);
		lfe.setMjesto(mjesto);
		lfe.setUlica(ulica);
		lfe.setCijena(cijena);
		lfe.setVrstaPonude(vrstaPon);

		if (leftFormLst != null) {

			leftFormLst.leftPanelEventOccured(lfe);

		}
	}*/

}
