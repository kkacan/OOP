import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormPanel extends JPanel {
	
	private JTextField txtField;
	private JComboBox combo;
	private JRadioButton rbtnMnth;
	private JRadioButton rbtnQuart; 
	private JButton btnOK;
	private JButton btnList;
	private DefaultComboBoxModel comboModel;
	private JTextField txtGodina;
	private FormListener lst;
	private FormEvent fe;
	private ButtonGroup rBtngroup;
	
	public FormPanel() {
		
		setLayout(new GridBagLayout());

		createComp();
		layoutComponents();
		activateForm();
		
		
	}
	
	private void createComp() {
		
		comboModel = new DefaultComboBoxModel();

		comboModel.addElement("5");
		comboModel.addElement("6");
		comboModel.addElement("7");
		comboModel.addElement("8");
		comboModel.addElement("9");
		comboModel.addElement("10");
		comboModel.addElement("11");
		
		combo = new JComboBox(comboModel);
		txtField = new JTextField(10);
		txtGodina = new JTextField(10);
		btnOK = new JButton("Izraèunaj");
		btnList = new JButton("Prikaži");
		rbtnMnth = new JRadioButton("Mjeseèno plaæanje");
		rbtnQuart = new JRadioButton("Kvartalno plaæanje");
		rBtngroup = new ButtonGroup();
		rBtngroup.add(rbtnMnth);
		rBtngroup.add(rbtnQuart);
		rbtnMnth.setSelected(true);
		
	}
	
	public void layoutComponents() {

		GridBagConstraints gbc = new GridBagConstraints();

		///////////////// First Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Visina kredita"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtField, gbc);
		///////////////// Second Row ////////////////////////
		gbc.weightx = 0.5;
		gbc.weighty = 1;

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("GodinaOtplate"), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(txtGodina, gbc);

		///////////////// Second Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.2;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(new JLabel("Kamatna stopa"), gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.insets = new Insets(0, 5, 0, 5);
		gbc.anchor = GridBagConstraints.LINE_START;
		add(combo, gbc);

		///////////////// Third Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 0.1;

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnMnth, gbc);

		gbc.gridx = 1;
		gbc.gridy++;
		gbc.anchor = GridBagConstraints.LINE_START;
		add(rbtnQuart, gbc);
		///////////////// Last Row ////////////////////////
		gbc.weightx = 1;
		gbc.weighty = 2;

		gbc.gridx = 0;
		gbc.gridy++;
		gbc.insets = new Insets(0, 10, 0, 0);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnList, gbc);

		gbc.gridx = 1;

		gbc.insets = new Insets(0, 5, 0, 12);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(btnOK, gbc);

	}
	
	public void activateForm() {
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				int godina= Integer.parseInt(txtGodina.getText());
				float kreda = Float.parseFloat(txtField.getText());
				
				int nacin;
				
				if(rbtnMnth.isSelected()) {

					nacin=12;
				} else {
					nacin=4;
				}
				
				float kamata= Float.parseFloat((String)combo.getSelectedItem())/100f;
				
				fe= new FormEvent(this);
				
				setFormEvent(fe);
				
				fe.setGodina(godina);
				fe.setKreda(kreda);
				fe.setNacin(nacin);
				fe.setKamata(kamata);
				if (lst != null) {
					
					lst.calculateFormEventOccured(fe);

				}

			}
			
		});
		
		btnList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fe= new FormEvent(this);
				
				setFormEvent(fe);
				
				if (lst != null) {
					
					lst.listFormEventOccured(fe);

				}
			}
			
		});
	}
	
	private float getkamata() {
		
		return Float.parseFloat((String)combo.getSelectedItem())/100f;
		
	}
	
	public void setFormListener(FormListener lst) {
		this.lst=lst;
	}
	
	private void setFormEvent(FormEvent ev) {
		this.fe = ev;
	}

}
