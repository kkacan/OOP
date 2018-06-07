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
import javax.swing.JTextField;

public class FormPanel extends JPanel implements FormListener{
	
	private JLabel vessLbl;
	private JTextField vessField;
	private JLabel nameLbl;
	private JTextField nameField;
	private JLabel ageCategory;
	private JList ageList;
	private DefaultListModel ageModel;
	private JButton confirmBtn;
	private JPanel panel;
	private FormListener formLst;
	
	public FormPanel() {
		
		setLayout(new FlowLayout());
        Dimension dim = getPreferredSize();
        dim.height = 240;
        setPreferredSize(dim);
        createComp();
        ageModelList();
        
 
        add(vessLbl, FlowLayout.LEFT);
        add(ageList, FlowLayout.CENTER);
        add(ageCategory, FlowLayout.CENTER);
 
        add(nameField, FlowLayout.CENTER);
        add(nameLbl, FlowLayout.CENTER);
        add(vessField, FlowLayout.CENTER);
 
        add(confirmBtn, BorderLayout.SOUTH);
 
        activateComp();
		
		
		
	}
	
	private void createComp() {
		
		vessLbl = new JLabel("Vessel: ");
		nameLbl = new JLabel("Name: ");
		ageCategory = new JLabel("Category: ");
		ageModel = new DefaultListModel();
		
		ageList = new JList(ageModel);
		
		vessField = new JTextField(10);
		nameField = new JTextField(10);
		confirmBtn= new JButton("confirm");
		panel= new JPanel();
		panel.setLayout(new FlowLayout());
		
	}
	
	private DefaultListModel ageModelList() {
		
		DefaultListModel ageModel = new DefaultListModel();
        ageModel.add(0, "0 to 10 Years");
        ageModel.add(1, "11 to 30 Years");
        ageModel.add(2, "31 to 50 Years");
        ageList.setModel(ageModel);
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setVisibleRowCount(3);
        ageList.setSelectedIndex(1); // Select first category by default
		
		return ageModel;
		
	}
	private void activateComp() {
		
		 confirmBtn.addActionListener(new ActionListener() {
			 
	            @Override
	            public void actionPerformed(ActionEvent e) {
	 
	                String name = nameField.getText();
	                String type = vessField.getText();
	                int ageCat = ageList.getSelectedIndex();
	                 
	                FormEvent fe = new FormEvent(this);
	                fe.setName(name);
	                fe.setType(type);
	                fe.setAgeCat(ageCat);
	             
	                if(formLst != null) {
	                     
	                    formLst.formEventOccured(fe);
	                     
	                }
	                 
	                 
	                resetForm();
	 
	            }
	 
	        });
		
	}
	
	public void setFormListener(FormListener lst) {
		this.formLst=lst;
	}
	
	public void resetForm() {
		
		vessField.setText("");
        nameField.setText("");
        ageList.setSelectedIndex(1);
	}

	@Override
	public void formEventOccured(FormEvent evnt) {
		
		
	}

	

}
