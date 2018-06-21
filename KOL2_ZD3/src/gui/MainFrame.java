package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controller.Controller;
import model.User;




public class MainFrame extends JFrame{
	
	private JPanel txtPanel;
	private JPanel formPanel;
	private JPanel left;
	private JPanel right;
	private JTextArea usr1TxtAr;
	private JTextArea usr2TxtAr;
	private JTextArea comunicationTxt;
	private JButton btnSend1;
	private JButton btnSend2;
	private JButton btnNewUser;
	private UserDialog usrDialog;
	private Controller cntr = new Controller();
	private MenuBar menuBar;
	private MenuBarListener mListener;
	
	
	public MainFrame() {
		setLayout(new BorderLayout());
		setSize(550, 700);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		createComp();
		layoutComp();
		setBorders();
		activateAll();
		setJMenuBar(menuBar.getJMenuBar());
		menuBar.setMainFrame(MainFrame.this);
		menuBar.setMenuBarListener(mListener);
		menuBar.setController(cntr);
	}
	
	private void createComp() {
		
		txtPanel= new JPanel();
		formPanel = new JPanel();
		left = new JPanel();
		right = new JPanel();
		usr1TxtAr = new JTextArea();
		usr2TxtAr = new JTextArea();
		comunicationTxt = new JTextArea();
		btnSend1= new JButton("Send1");
		btnSend2= new JButton("Send2");
		btnNewUser= new JButton("New User");
		usrDialog = new UserDialog(this);
		menuBar = new MenuBar();
		
		//user1= new User("Jure", 1);
		//user2= new User("Mate", 2);
		
		 		
		
		add(txtPanel,BorderLayout.NORTH);
		add(formPanel, BorderLayout.CENTER);
		
	}
	
	private void layoutComp() {
		
		txtPanel.setLayout(new BorderLayout());
		txtPanel.setPreferredSize(new Dimension(500,350));
		comunicationTxt.setPreferredSize(new Dimension(500,320));
		txtPanel.add(new JScrollPane(comunicationTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),
				BorderLayout.NORTH);
		
		txtPanel.add(btnNewUser, BorderLayout.SOUTH);
		
		formPanel.setLayout(new BorderLayout());
		formPanel.setPreferredSize(new Dimension(500,350));
		usr1TxtAr.setPreferredSize(new Dimension(200,150));
		usr2TxtAr.setPreferredSize(new Dimension(200,150));

		
		left.setLayout(new BorderLayout());
		left.setPreferredSize(new Dimension(240,350));
		left.add(usr1TxtAr, BorderLayout.NORTH);
		left.add(btnSend1, BorderLayout.SOUTH);
		
		right.setLayout(new BorderLayout());
		right.setPreferredSize(new Dimension(240,350));
		right.add(usr2TxtAr, BorderLayout.NORTH);
		right.add(btnSend2, BorderLayout.SOUTH);
		
		formPanel.add(left, BorderLayout.WEST);
		formPanel.add(right, BorderLayout.EAST);
		
		
	}
	
	private void setBorders() {
		Border inner = BorderFactory.createTitledBorder("Komunikacija");
		Border outer = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		formPanel.setBorder(BorderFactory.createCompoundBorder(outer, inner));
	}
	
	private void activateAll() {
		
		btnNewUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				usrDialog.setVisible(true);
				
			}
			
		});
		
		btnSend1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//usr1TxtAr.setText("");
				if (cntr.getDbs().getUsers().size()>0) {
					User user1=cntr.getDbs().getUsers().get(0);
					comunicationTxt.append(user1.getUserName()+": "+usr1TxtAr.getText()+"\n");
					comunicationTxt.append("/////////////////"+"\n");
					usr1TxtAr.setText("");
				}
				
				
				
				
			}
			
		});
		
		btnSend2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (cntr.getDbs().getUsers().size()>1) {
					User user2=cntr.getDbs().getUsers().get(1);
					comunicationTxt.append(user2.getUserName()+": "+usr2TxtAr.getText()+"\n");
					comunicationTxt.append("/////////////////"+"\n");
					usr2TxtAr.setText("");
				}
			}
			
		});
		
		usrDialog.setDialogListener(new DialogListener() {

			@Override
			public void dialogEventOccured(DialogEvent dev) {
				
				String userName= dev.getUserName();
				int id= dev.getId();
				
				User user= new User(userName, id);
				
				cntr.getDbs().addUser(user);
				
				
			}
			
		});
		
		mListener = new MenuBarListener() {

			@Override
			public void setTextFromFile(String text) {
				
				comunicationTxt.setText(text);
			}

			@Override
			public List<User> getUsersData() {
				// TODO Auto-generated method stub
				return cntr.getDbs().getUsers();
			}
		
		
		};
	}

	

}
