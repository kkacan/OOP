package gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RightPanel extends JPanel {
	
	
	/*private JLabel lblIme;
	private JLabel lblAdresa;
	private JLabel lblTel;
	private JLabel lblEmail;

	private JTextField imeField;
	private JTextField adresaField;
	private JTextField telField;
	private JTextField emailField;

	private JButton btnSpremi;
	
	private FormListener rightFormLst;
	
	public RightPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 500;
		setPreferredSize(dim);
		setBorders();
		createLeftComp();
		layoutLeft();
		activateForm();
	}
	
	private void setBorders() {

		Border inner = BorderFactory.createTitledBorder("Podaci o stranci:");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}
	
	private void createLeftComp() {

		lblIme = new JLabel("Ime i prezime: ");
		lblAdresa = new JLabel("Adresa: ");
		lblTel = new JLabel("Telefon: ");
		lblEmail = new JLabel("Email: ");
		
 
		imeField = new JTextField(10);
		adresaField = new JTextField(10);
		telField = new JTextField(10);
		emailField = new JTextField(10);
		btnSpremi = new JButton("Spremi");
		
		
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
	}
	
	private void activateForm() {

		btnSpremi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				String ime = imeField.getText();
				String adresa = adresaField.getText();
				String tel = telField.getText();
				String email = emailField.getText();
				

				RightFormEvent rfe = new RightFormEvent(this);
				
				rfe.setIme(ime);
				rfe.setAdresa(adresa);
				rfe.setTel(tel);
				rfe.setEmail(email);
				

				if (rightFormLst != null) {

					rightFormLst.rightPanelEventOccured(rfe);

				}
				
				//reset
				

			}
		});
	}

	public void setRightFormListener(FormListener listener) {

		this.rightFormLst= listener;
		
	}

	public void actionRightPerformed() {
		
		String ime = imeField.getText();
		String adresa = adresaField.getText();
		String tel = telField.getText();
		String email = emailField.getText();
		

		RightFormEvent rfe = new RightFormEvent(this);
		
		rfe.setIme(ime);
		rfe.setAdresa(adresa);
		rfe.setTel(tel);
		rfe.setEmail(email);
		

		if (rightFormLst != null) {

			rightFormLst.rightPanelEventOccured(rfe);

		}
	}
	*/


	
}
