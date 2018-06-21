package gui;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class UserDialog extends JDialog {

	private JTextField usrNameField;
	private JTextField userIdField;
	private JButton okBtn;
	private JButton cancelBtn;
	private DialogListener diListener;
	
	
	

	public UserDialog(JFrame parent) {
		super(parent, "User data", false);
		setLayout(new GridBagLayout());
		createComp();
		layoutComp();
		activateDialog();
		
		setSize(265,145);
	}

	private void createComp() {

		okBtn = new JButton("OK");
		cancelBtn = new JButton("Cancel");
		usrNameField = new JTextField(10);
		userIdField = new JTextField(5);
		

	}

	private void layoutComp() {

		GridBagConstraints gbc = new GridBagConstraints();
		/////////////////// first row ////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 10, 0, 0);
		add(new JLabel("User name:"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(new JLabel("User id:"), gbc);
		/////////////////// second row ////////////////////
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0,10,0,0);
		add(usrNameField, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 0, 0, 0);
		add(userIdField, gbc);

		/////////////////// last row ////////////////////
		gbc.weightx = 1;
		gbc.weighty = 3;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.insets = new Insets(0, 20, 0, 10);
		gbc.ipadx = 10;
		add(okBtn, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(0, 0, 0, 25);
		gbc.ipadx = 20;
		add(cancelBtn, gbc);
	}

	private void activateDialog() {

		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				DialogEvent de = new DialogEvent(this);
				
				
				de.setUserName(usrNameField.getText());
				de.setId(Integer.parseInt(userIdField.getText()));
				
				
				if (diListener != null) {
					
					diListener.dialogEventOccured(de);

				}
				setVisible(false);

			}
		});

		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
	}

	public void setDialogListener(DialogListener lst) {
		this.diListener = lst;
	}

}