package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableRowSorter;

import controller.Controller;
import model.Nekretnina;
import model.Stranka;


public class MainFrame extends JFrame {
	
	private FormPanel fPanel;
	//private TableFrame tableFrame;
	private Controller cntrl;
	
	private JTable tablePon;
	private JTable tablePot;
	private JTable tableStr;
	private TableModelPonuda tableModelPon;
	private TableModelPotraznja tableModelPot;
	private TableModelStranke tableModelStr;
	private JPanel tablePanelPon;
	private JPanel tablePanelPot;
	private JPanel tablePanelStr;
	JTabbedPane tabbedPane;
	
	private boolean ponuda=true;
	

	
	public MainFrame() {
		super("Nekretnine");
		setLayout(new BorderLayout());

		createCompMainFrame();
		add(tabbedPane,BorderLayout.NORTH);
		add(fPanel, BorderLayout.CENTER);
				
		
		//add(tablePanel,BorderLayout.NORTH);
		

		//add(tableFrame, BorderLayout.CENTER);
		//add(tlbar, BorderLayout.NORTH);
		//tlbar.setToolBarListener(tListener);
		//setJMenuBar(menuBar.getJMenuBar());
		//menuBar.setMainFrame(MainFrame.this);
		//menuBar.setMenuBarListener(mListener);
		setSize(1000, 700);
		Dimension mins = new Dimension(900, 650);
		setMinimumSize(mins);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		initData();
		
	}
	
	private void createCompMainFrame() {

		//txtPanel = new TextPanel();
		//tlbar = new ToolBar();
		
		cntrl = new Controller();
		fPanel = new FormPanel();
		
		//menuBar = new MenuBar();

		fPanel.updateStrankeCombo(cntrl.getDataStranke());
		
		tablePanelPon = new JPanel();
		tablePanelPot = new JPanel();
		tablePanelStr = new JPanel();
		tableModelPon = new TableModelPonuda();
		tableModelPot = new TableModelPotraznja();
		tableModelStr = new TableModelStranke();
		
		//TableRowSorter sorter = new TableRowSorter<TableModelPonuda>(tableModelPon);
		
		tablePon = new JTable(tableModelPon);
		tablePot = new JTable(tableModelPot);
		tableStr = new JTable(tableModelStr);
		
		//tablePon.setRowSorter(sorter);

		
		tablePanelPon.setLayout(new BorderLayout());
		tablePanelPon.add(new JScrollPane(tablePon,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		
		tablePanelPot.setLayout(new BorderLayout());
		tablePanelPot.add(new JScrollPane(tablePot,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		
		tablePanelStr.setLayout(new BorderLayout());
		tablePanelStr.add(new JScrollPane(tableStr,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		
		tablePon.addMouseListener(new MouseAdapter() {
			
		    @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				if(SwingUtilities.isRightMouseButton(e) == true){
					int row = tablePon.rowAtPoint(e.getPoint());
					tablePon.clearSelection();
					tablePon.addRowSelectionInterval(row,row);
					JPopupMenu popup = new JPopupMenu();
					ActionListener menuListener = new ActionListener() {
					      public void actionPerformed(ActionEvent event) {
					    	  
					    	switch (event.getActionCommand()) {
					    	
					    	case "Obriši nekretninu":
					    		showDeletePonudaDialog();
					    							    	
					    	}

					     }
					};
					
					JMenuItem item;
				    popup.add(item = new JMenuItem("Obriši nekretninu"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
		    }

		});
		
		tablePot.addMouseListener(new MouseAdapter() {
			
		    @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				if(SwingUtilities.isRightMouseButton(e) == true){
					int row = tablePot.rowAtPoint(e.getPoint());
					tablePot.clearSelection();
					tablePot.addRowSelectionInterval(row,row);
					JPopupMenu popup = new JPopupMenu();
					ActionListener menuListener = new ActionListener() {
					      public void actionPerformed(ActionEvent event) {
					    	  
					    	switch (event.getActionCommand()) {
					    	
					    	case "Obriši nekretninu":
					    		showDeletePotraznjaDialog();
					    		
					    	
					    	}

					     }
					};
					
					JMenuItem item;
				    popup.add(item = new JMenuItem("Obriši nekretninu"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
		    }

		});		
		
		tableStr.addMouseListener(new MouseAdapter() {
			
		    @Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				if(SwingUtilities.isRightMouseButton(e) == true){
					int row = tableStr.rowAtPoint(e.getPoint());
					tableStr.clearSelection();
					tableStr.addRowSelectionInterval(row,row);
					JPopupMenu popup = new JPopupMenu();
					ActionListener menuListener = new ActionListener() {
					      public void actionPerformed(ActionEvent event) {
					    	  
					    	switch (event.getActionCommand()) {
					    	
					    	case "Obriši stranku":
					    		showDeleteStrankaDialog();
					    		
					    	}

					     }
					};
					
					JMenuItem item;
				    popup.add(item = new JMenuItem("Obriši stranku"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
		    }

		});		
		
		
		tabbedPane = new JTabbedPane();
		
		Border inner = BorderFactory.createTitledBorder("");
		Border outer = BorderFactory.createEmptyBorder(10, 10, 10, 10);
		tabbedPane.setBorder(BorderFactory.createCompoundBorder(outer, inner));
		
	    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    
	    tabbedPane.addTab("Ponuda", tablePanelPon);
	    tabbedPane.addTab("Potražnja", tablePanelPot);
	    tabbedPane.addTab("Imenik", tablePanelStr);
	    
	    tabbedPane.addChangeListener(new ChangeListener() {
	        public void stateChanged(ChangeEvent e) {

	            if (tabbedPane.getSelectedIndex()==0) {
	            	ponuda=true;
	            	fPanel.enableSpremiBtn();
	            	
	            } else if (tabbedPane.getSelectedIndex()==1){
	            	ponuda=false;
	            	fPanel.enableSpremiBtn();
	            	
	            } else if (tabbedPane.getSelectedIndex()==2) {
	            	fPanel.disableSpremiBtn();
	            }
	            fPanel.updateVrstaCombo(ponuda);
	            
	        }
	    });

		//TableFrame tableFrame = new TableFrame();
/*		tListener = new ToolBarListener() {

			@Override
			public void setTextFromFile(String text) {

				txtPanel.writeText(text);

			}

			@Override
			public void clearAllText() {

				txtPanel.clearTextArea();

			}

			@Override
			public void listAllCustomers() {
				cntrl.listAllCustomers();

			}
		};*/
		
		/*mListener = new MenuBarListener() {

			@Override
			public List<Customer> getCustomersData() {
				
				return cntrl.getData();
			}

			@Override
			public void setTextFromFile(String text) {
				
				txtPanel.writeText(text);
			}

						
				
			
			
		};*/

		fPanel.setFormListener(new FormListener() {

			@Override
			public void leftPanelEventOccured(LeftFormEvent lfe) {

				/*String imeStranke = lfe.getImeStranke();
				String vrsta = lfe.getVrstaNekretnine();
				String mjesto = lfe.getMjesto();
				String ulica = lfe.getUlica();
				String cijena =lfe.getCijena();*/
				
				//int counter = lfe.getNumClicked();

				//txtPanel.writeText(name + " : " + city + " : " + mail);
				cntrl.addNekretninaData(lfe);

				//if (counter == 1) {
					
					setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
					//setVisible(true);
					refreshTable();

				/*} else {
					
					tableFrame.setTableData(cntrl.getData());
					tableFrame.refreshTable();

				}*/

			}

			@Override
			public void rightPanelEventOccured(RightFormEvent rfe) {
				
				/*String ime = rfe.getIme();
				String adresa = rfe.getAdresa();
				String tel = rfe.getTel();
				String email = rfe.getEmail();*/
				
				cntrl.addStrankeData(rfe);
				
				tableModelStr.fireTableDataChanged();
				tableModelStr.setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				
				//dodaje stranku u dropdown listu
				fPanel.updateStrankeCombo(cntrl.getDataStranke());
				
				//setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				//refreshTable();
				
				
			}
		});

			/*@Override
			public void rightPanelEventOccured(RightFormEvent rfe) {

				int productCat = rfe.getProducrCat();
				boolean giftCard = rfe.isGiftCard();
				boolean decorativePack = rfe.isDecorativePack();
				boolean newLetter = rfe.isNewLetter();
				String paymentMet = rfe.getPaymentMet();
				String gcText = rfe.getGcText();
				String delivery = rfe.getDelivery();

				System.out.println("Kategorija proizvoda: " + productCat);
				System.out.println("Gift card: " + giftCard);
				System.out.println("Gift card short text: " + gcText);
				System.out.println("Decorative package: " + decorativePack);
				System.out.println("Send me newsletters: " + newLetter);
				System.out.println("Payment method: " + paymentMet + ", delivery: " + delivery);

			}
		});*/
		
		

	}
	
	public void refreshTable() {
		tableModelPon.fireTableDataChanged();
		tableModelPot.fireTableDataChanged();
		tableModelStr.fireTableDataChanged();
		
		
		/*for (int i = 0; i < tableModelPon.getRowCount(); i++) {
            if ((boolean) tableModelPon.getValueAt(i, 7)==false) {
            	System.out.println((boolean) tableModelPon.getValueAt(i, 7));
            	tableModelPon.removeRow(i);
            }
        }
		
		if(tablePon.getColumnModel().getColumnCount()==8) tablePon.removeColumn(tablePon.getColumnModel().getColumn(7));*/
	}
	
	public void setTableData(List<Stranka> stranke, List<Nekretnina> nekretnine) {
		tableModelPon.setTableData(stranke, nekretnine);
		tableModelPot.setTableData(stranke, nekretnine);
		tableModelStr.setTableData(stranke, nekretnine);
		
	}
	
	private void initData() {
		cntrl.readDataFromFile();
		setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
		refreshTable();
	}
	
	private void showDeletePonudaDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Želiš li obrisati nekretninu?", "Nekretnine",dialogButton);
		
		if(dialogResult == 0) {
			
			tableModelPon.removeRow(tablePon.getSelectedRow());
    		refreshTable();
		} 
	}
	
	private void showDeletePotraznjaDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Želiš li obrisati nekretninu?", "Nekretnine",dialogButton);
		
		if(dialogResult == 0) {
			
			tableModelPot.removeRow(tablePot.getSelectedRow());
    		refreshTable();
		} 
	}
	
	private void showDeleteStrankaDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Želiš li obrisati stranku?", "Nekretnine",dialogButton);
		
		if(dialogResult == 0) {
			
			tableModelStr.removeRow(tableStr.getSelectedRow());
    		refreshTable();
    		fPanel.updateStrankeCombo(cntrl.getDataStranke());

		} 
	}
	
	
}
