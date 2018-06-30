package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.BorderFactory;
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
import controller.Controller;
import model.Nekretnina;
import model.Stranka;

/**
 * Klasa koja sadrži sve grafièke elemente aplikacije (GUI).
 * 
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class MainFrame extends JFrame {
	
	private FormPanel fPanel;
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
	private JTabbedPane tabbedPane;
	private NekretninaDialog nekretninaDialog;
	private StrankaDialog strankaDialog;
	private MenuBar menuBar;
	
	private boolean ponuda=true;

	/**
	 * Konstruktor dodaje glavni panel, tablicu za prikaz podataka i meni.
	 * Postavlja dimenzije glavnog ekrana i uèitava podatke.
	 */
	public MainFrame() {
		super("Nekretnine");
		setLayout(new BorderLayout());

		createCompMainFrame();
		add(tabbedPane,BorderLayout.NORTH);
		add(fPanel, BorderLayout.CENTER);
		setJMenuBar(menuBar);
		setSize(1000, 700);
		Dimension mins = new Dimension(900, 650);
		setMinimumSize(mins);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		initData();
		
	}
	
	/**
	 * Metoda koja inicijalizira sve komponente glavnog ekrana i
	 * postavlja sve listenere.
	 */
	private void createCompMainFrame() {
		
		cntrl = new Controller();
		fPanel = new FormPanel();

		menuBar = new MenuBar();

		fPanel.updateStrankeCombo(cntrl.getDataStranke());
		
		tablePanelPon = new JPanel();
		tablePanelPot = new JPanel();
		tablePanelStr = new JPanel();
		tableModelPon = new TableModelPonuda();
		tableModelPot = new TableModelPotraznja();
		tableModelStr = new TableModelStranke();
		
		nekretninaDialog = new NekretninaDialog(this);
		strankaDialog = new StrankaDialog(this);
		
		tableModelPon.setController(cntrl);
		tableModelPot.setController(cntrl);
		tableModelStr.setController(cntrl);
		
		tablePon = new JTable(tableModelPon);
		tablePot = new JTable(tableModelPot);
		tableStr = new JTable(tableModelStr);
		
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
					    		break;						    	
					    	
					      	case "Izmjeni nekretninu":
					      		nekretninaDialog.setVisible(true);
					      		int column = 0;
					      		int row = tablePon.getSelectedRow();
					      		int id = (int) tableModelPon.getValueAt(row, column);
					      		nekretninaDialog.setDialogData(cntrl, id);
					    		break;						    	
					    	}

					     }
					};
					
					JMenuItem item;
					JMenuItem item2;
				    popup.add(item = new JMenuItem("Obriši nekretninu"));
				    popup.add(item2 = new JMenuItem("Izmjeni nekretninu"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item2.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    item2.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
				if(SwingUtilities.isLeftMouseButton(e) == true){
					
					if (e.getClickCount() == 2 && tablePon.getSelectedRow() != -1) {
						nekretninaDialog.setVisible(true);
			      		int column = 0;
			      		int row = tablePon.getSelectedRow();
			      		int id = (int) tableModelPon.getValueAt(row, column);
			      		nekretninaDialog.setDialogData(cntrl, id);
			        }
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
					    		break;
					    		
					    	case "Izmjeni nekretninu":
					      		nekretninaDialog.setVisible(true);
					      		int column = 0;
					      		int row = tablePot.getSelectedRow();
					      		int id = (int) tableModelPot.getValueAt(row, column);
					      		nekretninaDialog.setDialogData(cntrl, id);
					    		break;						    	
					    						    	
					    	}

					     }
					};
					
					JMenuItem item;
					JMenuItem item2;
				    popup.add(item = new JMenuItem("Obriši nekretninu"));
				    popup.add(item2 = new JMenuItem("Izmjeni nekretninu"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item2.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    item2.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
				if(SwingUtilities.isLeftMouseButton(e) == true){
					
					if (e.getClickCount() == 2 && tablePot.getSelectedRow() != -1) {
						nekretninaDialog.setVisible(true);
			      		int column = 0;
			      		int row = tablePot.getSelectedRow();
			      		int id = (int) tableModelPot.getValueAt(row, column);
			      		nekretninaDialog.setDialogData(cntrl, id);
			        }
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
					    		break;
					    		
					    	case "Izmjeni stranku":
					    		strankaDialog.setVisible(true);
					      		int column = 0;
					      		int row = tableStr.getSelectedRow();
					      		int id = (int) tableModelStr.getValueAt(row, column);
					      		strankaDialog.setDialogData(cntrl, id);	
					    		break;
					    	}

					     }
					};
					
					JMenuItem item;
					JMenuItem item2;
				    popup.add(item = new JMenuItem("Obriši stranku"));
				    popup.add(item2 = new JMenuItem("Izmjeni stranku"));
				    item.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item2.setHorizontalTextPosition(JMenuItem.RIGHT);
				    item.addActionListener(menuListener);
				    item2.addActionListener(menuListener);
				    popup.setBorder(new BevelBorder(BevelBorder.RAISED));
				    popup.setVisible(true);
				    popup.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
				if(SwingUtilities.isLeftMouseButton(e) == true){
					
					if (e.getClickCount() == 2 && tableStr.getSelectedRow() != -1) {
						strankaDialog.setVisible(true);
			      		int column = 0;
			      		int row = tableStr.getSelectedRow();
			      		int id = (int) tableModelStr.getValueAt(row, column);
			      		strankaDialog.setDialogData(cntrl, id);	
			        }
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
	    
	    nekretninaDialog.setDialogListener(new NekretninaDialogListener() {

			@Override
			public void nekretninaDialogEventOccured(LeftFormEvent ndev, int index) {
				
				cntrl.editNekretninaData(ndev, index);
				setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				refreshTable();
	    		
			}


			
		});
	    
	    strankaDialog.setDialogListener(new StrankaDialogListener() {

			@Override
			public void strankaDialogEventOccured(RightFormEvent sdev, int index) {
				
				cntrl.editStrankaData(sdev, index);
				setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				refreshTable();
			}
			
		});


	
		fPanel.setFormListener(new FormListener() {

			@Override
			public void leftPanelEventOccured(LeftFormEvent lfe) {

				cntrl.addNekretninaData(lfe);
				setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				refreshTable();

			}

			@Override
			public void rightPanelEventOccured(RightFormEvent rfe) {
				
				cntrl.addStrankeData(rfe);
				tableModelStr.fireTableDataChanged();
				tableModelStr.setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
				
				fPanel.updateStrankeCombo(cntrl.getDataStranke());
				
			}
		});

	}
	
	/**
	 * Metoda koja osvježava tablice.
	 */
	public void refreshTable() {
		tableModelPon.fireTableDataChanged();
		tableModelPot.fireTableDataChanged();
		tableModelStr.fireTableDataChanged();

	}
	
	/**
	 * Metoda koja daje podatke tablicama.
	 * @param stranke ArrayList stranake
	 * @param nekretnine ArrayList nekretnine
	 */
	public void setTableData(List<Stranka> stranke, List<Nekretnina> nekretnine) {
		tableModelPon.setTableData(nekretnine);
		tableModelPot.setTableData(nekretnine);
		tableModelStr.setTableData(stranke, nekretnine);
		
	}
	
	/**
	 * Metoda koja uèitava podatke iz datoteke u bazu podataka, dodaje i osvježava podatke u tablicama.
	 */
	private void initData() {
		cntrl.readDataFromFile();
		setTableData(cntrl.getDataStranke(),cntrl.getDataNekretnine());
		refreshTable();
	}
	
	/**
	 * Dialog kod brisanja nekretnine tipa ponuda.
	 */
	private void showDeletePonudaDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Želiš li obrisati nekretninu?", "Nekretnine",dialogButton);
		
		if(dialogResult == 0) {
			
			tableModelPon.removeRow(tablePon.getSelectedRow());
    		refreshTable();
		} 
	}
	
	/**
	 * Dialog kod brisanja nekretnine tipa potražnja.
	 */
	private void showDeletePotraznjaDialog() {
		int dialogButton = JOptionPane.YES_NO_OPTION;
		int dialogResult = JOptionPane.showConfirmDialog(this, "Želiš li obrisati nekretninu?", "Nekretnine",dialogButton);
		
		if(dialogResult == 0) {
			
			tableModelPot.removeRow(tablePot.getSelectedRow());
    		refreshTable();
		} 
	}
	
	/**
	 * Dialog kod brisanja stranke.
	 */
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
