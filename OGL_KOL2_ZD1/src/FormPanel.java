import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class FormPanel extends JPanel{
	
	private JLabel vessLbl;
	private JLabel nameLbl;
	private JLabel ageCategory;
	private JTextField vessField;
	private JTextField nameField;
	private JList ageList;
	private DefaultListModel ageModel;
	private JButton confirmBtn;
	private JPanel panel;
	private FormListener lst;
	
	public FormPanel() {
		
		setLayout(new BorderLayout());
		createComp();
		activateComp();
		setVisible(true);
		add(panel,BorderLayout.NORTH);
		add(confirmBtn, BorderLayout.SOUTH);
		
		
	}
	
	private void createComp() {
		vessLbl= new JLabel("VesselType: ");
		nameLbl= new JLabel("Vesselname: ");
		ageCategory= new JLabel("VesselAgeCat: ");
		vessField = new JTextField(10);
		nameField = new JTextField(10);
		ageList= new JList();
		
		ageModel= new DefaultListModel();
		ageList.setModel(ageModelList());
		ageList.setBorder(BorderFactory.createEtchedBorder());
	    ageList.setVisibleRowCount(3);
	    ageList.setSelectedIndex(0);

		
		confirmBtn = new JButton("confirm");
		panel = new JPanel();
		
		panel.setLayout(new FlowLayout());
		
		panel.add(vessLbl);
		panel.add(vessField);
		panel.add(nameLbl);
		panel.add(nameField);
		panel.add(ageCategory);
		panel.add(new JScrollPane(ageList, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
		
		
		
		
		
		
		
	}
	
	private DefaultListModel ageModelList() {
		
		
		ageModel.add(0, "0 to 10 years");
		ageModel.add(1, "11 to 30 years");
		ageModel.add(2, "31 to 50 years");


		return ageModel;
		
	}
	
	private void activateComp() {
		confirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				FormEvent fe = new FormEvent(this);
                fe.setVessName(nameField.getText());
                fe.setVessType(vessField.getText());
                fe.setAgeCat(ageList.getSelectedIndex());
				
				if (lst!=null) {
					lst.formEventOccured(fe);
					resetForm();
				}
			}
			
		});
	}

	public void setFormListener(FormListener lst) {
		this.lst=lst;
	}
	
	public void resetForm() {
		
		nameField.setText("");
		vessField.setText("");
		ageList.setSelectedIndex(0);
	}
}
