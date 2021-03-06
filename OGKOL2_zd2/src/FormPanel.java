import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {

	private JComboBox playersCombo;
	private JLabel numLabel;
	private JTextField numField;
	private JButton btnPlay;
	private JLabel usrNameLbl;
	private JTextField usrField;
	private JLabel ageLbl;
	private JTextField ageField;
	private JButton newPlyBtn;
	private DefaultComboBoxModel cmbBoxPlyModel;
	private JPanel left;
	private JPanel right;
	private FormListener formLst;
	private JButton newGame;

	public FormPanel() {

		setLayout(new BorderLayout());
		createComp();
		leftPanel();
		rightPanel();
		add(left, BorderLayout.WEST);
		add(right, BorderLayout.CENTER);
		layoutComponentsLeft();
		layoutComponentsRight();
		activateComp();

	}

	private void createComp() {

		cmbBoxPlyModel = createComboModel();
		playersCombo = new JComboBox(cmbBoxPlyModel);
		numLabel = new JLabel("Number:");
		numField = new JTextField(4);
		usrField = new JTextField(10);
		btnPlay = new JButton("play");
		usrNameLbl = new JLabel("User name:");
		ageLbl = new JLabel("Your age:");
		ageField = new JTextField(10);
		newPlyBtn = new JButton("Create profile");
		newGame = new JButton("New Game");

		left = new JPanel();
		right = new JPanel();
	}

	private DefaultComboBoxModel createComboModel() {

		DefaultComboBoxModel cmbBoxPlyModel = new DefaultComboBoxModel();

		cmbBoxPlyModel.addElement("player 1");
		cmbBoxPlyModel.addElement("player 2");
		cmbBoxPlyModel.addElement("player 3");

		return cmbBoxPlyModel;
	}

	private void layoutComponentsLeft() {

		left.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(numLabel, gbc);
		///////////////////// Second Row /////////////////////
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(5, 0, 0, 15);

		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(playersCombo, gbc);

		gbc.weightx = 1;

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		left.add(numField, gbc);
		///////////////////// Third Row /////////////////////
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.weighty = 1;
		gbc.insets = new Insets(25, 0, 0, 0);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		left.add(btnPlay, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.anchor = GridBagConstraints.LINE_END;
		left.add(newGame, gbc);

	}

	private void layoutComponentsRight() {

		right.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		///////////////////// First Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		right.add(usrNameLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		right.add(usrField, gbc);
		///////////////////// Second Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.25;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;
		right.add(ageLbl, gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(20, 10, 0, 10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		right.add(ageField, gbc);
		///////////////////// Last Row /////////////////////
		gbc.weightx = 1;
		gbc.weighty =2;

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		right.add(newPlyBtn, gbc);
		
		

	}

	private void leftPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Play game");
		left.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = left.getPreferredSize();
		dim.width = 350;
		left.setPreferredSize(dim);
	}

	private void rightPanel() {

		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border inner = BorderFactory.createTitledBorder("Add new player");
		right.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		Dimension dim = left.getPreferredSize();
		dim.width = 200;
		left.setPreferredSize(dim);
	}
	
	private void activateComp() {
		
		newPlyBtn.addActionListener(new ActionListener() {
			 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	 
	                String name = usrField.getText();
	                String age = ageField.getText();
	                
	                 
	                FormEvent fe = new FormEvent(this);
	                fe.setName(name);
	                fe.setAge(age);
	                
	             
	                if(formLst != null) {
	                     
	                    formLst.formEventOccured(fe);
	                    
	                    Player player = new Player(name, age);
	                    
	                    cmbBoxPlyModel.addElement("player "+player.getId());
	                     
	                }
	                 
	                 
	                resetForm();
	 
	            }
	 
	        });
		
		btnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				 String name = cmbBoxPlyModel.getSelectedItem().toString();
				 String broj= numField.getText();
				 
				  FormPlayEvent fe = new FormPlayEvent(this);
	                fe.setName(name);
	                fe.setBroj(broj);

	                if(formLst != null) {
	                     
	                    formLst.formPlayEventOccured(fe);
	                    playersCombo.setEnabled(false);

	                     
	                }
				 
			}

			
		});
		
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				FormNewGameEvent fe = new FormNewGameEvent(this);
				if(formLst != null) {
                    
                    formLst.formNewGameEventOccured(fe);
                    playersCombo.setEnabled(true);

                     
                }
				
				
			}
			
		});
		
	}
	
	public void resetForm() {
		
		usrField.setText("");
		ageField.setText("");
       
	}
	
	public void setFormListener(FormListener lst) {
		this.formLst=lst;
	}
	



}
