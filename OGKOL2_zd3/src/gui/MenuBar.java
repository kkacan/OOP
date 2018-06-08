package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Customer;

public class MenuBar {
	
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fileMenu = new JMenu("File");
	private JMenu viewMenu = new JMenu("View");
	private MainFrame mainFrame;
	private JFileChooser fileChooser = new JFileChooser();
	
	// for fileMenu
	private JMenuItem open = new JMenuItem("Open...");
	private JMenuItem save = new JMenuItem("Save as...");
	private JMenuItem exit = new JMenuItem("Exit");
	
	FileFilter filter1 = new FileNameExtensionFilter("Customers files", "cust");
	FileFilter filter2 = new FileNameExtensionFilter("Naruđbe files", "nar");
	//FileFilter filter3 = new FileNameExtensionFilter("HTML files", "html");
	//FileFilter filter4 = new FileNameExtensionFilter("Word files", new String[] {"doc", "docx"});
	private MenuBarListener mListener;
	
	
	
	public MenuBar() {
		
		createMenuBar();
		activateMenuBar();
	}
	
	
	private void createMenuBar() {
		
		menuBar.add(fileMenu);
		menuBar.add(viewMenu);
		
		fileMenu.add(open);
		fileMenu.add(save);
		fileMenu.addSeparator();
		fileMenu.add(exit);
		fileChooser.addChoosableFileFilter(filter1);
		fileChooser.addChoosableFileFilter(filter2);
		//fileChooser.addChoosableFileFilter(filter3);
		//fileChooser.addChoosableFileFilter(filter4);
		fileChooser.setFileFilter(filter1);
		fileChooser.setAcceptAllFileFilterUsed(true);
		
	}
	
	public JMenuBar getJMenuBar() {
		return menuBar;
	}
	
	public void activateMenuBar() {
		
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int val = fileChooser.showOpenDialog(mainFrame);
				
				if(val == JFileChooser.APPROVE_OPTION) {
					
					readCustFromFile(fileChooser.getSelectedFile());
				} else {
					JOptionPane.showMessageDialog(mainFrame, "Canceled by user");
				}
				
			}
		});
		
		
		
		
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int val = JOptionPane.showConfirmDialog(mainFrame, "Really, you want to exit!?", 
						"Exit confirmation", JOptionPane.OK_CANCEL_OPTION);
				
				if(val == JOptionPane.OK_OPTION) {
					System.exit(0);
				} else {
					
					
					JOptionPane.showMessageDialog(mainFrame, "Canceled by user");
					// System.out.println("Canceled by user");
				}
				
			}
		});
		
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fileChooser.showSaveDialog(mainFrame) == JFileChooser.APPROVE_OPTION) {
					saveCustToFile(fileChooser.getSelectedFile());
				}
				
			}
		});
		
	}
	
	public void setMainFrame(MainFrame mf) {
		this.mainFrame = mf;
	}
	
	private void saveCustToFile(File file){
		
		try (FileOutputStream fos = new FileOutputStream(file)){
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				System.out.println("Size0"+mListener.getCustomersData().size());
				for (int i=0; i <mListener.getCustomersData().size(); i++) {
					oos.writeObject(mListener.getCustomersData().get(i));
				}
				oos. close () ;
				} catch (FileNotFoundException e) {
				// TODO Auto􀀀generated catch block
				e. printStackTrace () ;
				} catch (IOException e) {
				// TODO Auto􀀀generated catch block
				e. printStackTrace () ;
				}
	}
	
	public void setMenuBarListener(MenuBarListener lst) {
		this.mListener = lst;
	}
	
	private void readCustFromFile(File file) {
		
		try (FileInputStream fis = new FileInputStream(file)) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				String text = "///////////////////// Customer //////////////////////"+"\n";
				
				while ( fis . available () > 0) {
					Customer cst;
					cst = (Customer) ois .readObject() ;
					text+=cst.getName() + " : " + cst.getCity() + " : " + cst.getMail()+"\n";
				
				}
					ois . close () ;
					mListener.setTextFromFile(text);
					System.out. println ("text"+text);
					
				} catch (FileNotFoundException e) {
					// TODO Auto􀀀generated catch block
					e. printStackTrace () ;
				} catch (IOException e) {
					// TODO Auto􀀀generated catch block
					e. printStackTrace () ;
				} catch (ClassNotFoundException e) {
					// TODO Auto􀀀generated catch block
					e. printStackTrace () ;
				} finally {

				}
	}
	

}
