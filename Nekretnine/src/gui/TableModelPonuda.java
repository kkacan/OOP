package gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Database;
import model.Nekretnina;
import model.Stranka;

public class TableModelPonuda extends AbstractTableModel {

	private String[] colNames = { "ID", "Vrsta nekretnine", "Vrsta ponude", "Mjesto", "Ulica i k. broj", "Cijena", "Stranka"};
	private List<Stranka> stranke;
	private List<Nekretnina> nekretnine;
	private Database dbs = new Database();

	public void setTableData(List<Stranka> stranke, List<Nekretnina> nekretnine) {

		this.stranke = stranke;
		//this.nekretnine=nekretnine;
		this.nekretnine = new ArrayList<Nekretnina>();
		for (int i=0; i<nekretnine.size();i++) {
			if (nekretnine.get(i).isPonuda()) this.nekretnine.add(nekretnine.get(i));
		}

	}

	public TableModelPonuda() {

	}

	@Override
	public int getColumnCount() {

		return colNames.length;
	} 

	@Override
	public int getRowCount() {

		if (nekretnine!=null) {
			return  nekretnine.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getValueAt(int row, int col) {

		 //Stranka stranka = stranke.get(row);
		 
		//if ( nekretnine.get(row).isPonuda()) return null;
		Nekretnina nekretnina = nekretnine.get(row);
		 
		
			 switch(col) {
			 case 0:
				 return nekretnina.getId();

			 case 1:
				 return nekretnina.getVrstaNekretnine();
		 
			 case 2:
				 return nekretnina.getVrstaPonude();
			 
			 case 3:
				 return nekretnina.getMjesto();
		 
			 case 4:
				 return nekretnina.getUlica();
			 case 5:
				 return nekretnina.getCijena();
			 case 6:
				return nekretnina.getImeStranke();	 
			 /*case 7:
					return nekretnina.isPonuda();	*/ 	 
			 
		 
			 }
		//}
		return null;
		 
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
	
	public void removeRow(int row) {
		this.nekretnine.remove(row);
		dbs.refreshData(stranke, nekretnine);
    }

}
