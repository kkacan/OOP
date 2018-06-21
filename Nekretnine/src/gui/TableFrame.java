package gui;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import model.Nekretnina;
import model.Stranka;

public class TableFrame extends JFrame {
	
	/*private JTable table;
	private TableModelPonuda tableModel;
	private JPanel tablePanel;
	
	
	public TableFrame() {
		
		super("Nekretnine");
		tablePanel = new JPanel();
		setLayout(new BorderLayout());
		add(tablePanel,BorderLayout.CENTER);
		createComponents();
		setSize(500, 400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void createComponents() {
		
		tableModel = new TableModelPonuda();
		table = new JTable(tableModel);
		
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.addMouseListener(new MouseAdapter() {
			
		    @Override
			public void mouseClicked(MouseEvent e) {
		    	
		    	System.out.println("mouse");
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				
				if(SwingUtilities.isRightMouseButton(e) == true){
					int row = table.rowAtPoint(e.getPoint());

					table.clearSelection();
					table.addRowSelectionInterval(row,row);
					JPopupMenu contextMenu = new JPopupMenu();
				    contextMenu.setVisible(true);
				    contextMenu.show(e.getComponent(), e.getX(), e.getY());
					
				}
				
				
				if (e.isPopupTrigger()) {
					if (table.getSelectedRowCount() == 0) {
					      return;
					    }
						JPopupMenu contextMenu = new JPopupMenu();
					    contextMenu.setVisible(true);
					    contextMenu.show(e.getComponent(), e.getX(), e.getY());
				    }
			}

			@Override
		    public void mouseReleased(MouseEvent e) {
		    	
		        int r = table.rowAtPoint(e.getPoint());
		        if (r >= 0 && r < table.getRowCount()) {
		            table.setRowSelectionInterval(r, r);
		        } else {
		            table.clearSelection();
		        }

		        int rowindex = table.getSelectedRow();
		        if (rowindex < 0)
		            return;
		        if (e.isPopupTrigger() && e.getComponent() instanceof JTable ) {
		        	
		            JPopupMenu popup = new JPopupMenu();
		            popup.show(e.getComponent(), e.getX(), e.getY());
		        }
		    }
		});
		
	}
	
	public void refreshTable() {
		tableModel.fireTableDataChanged();
	}
	
	public void setTableData(List<Stranka> stranke,List<Nekretnina> nekretnine) {
		tableModel.setTableData(stranke, nekretnine);
	}
	*/
	
	

}
