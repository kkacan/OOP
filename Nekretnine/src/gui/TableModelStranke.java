package gui;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Database;
import model.Nekretnina;
import model.Stranka;

public class TableModelStranke extends AbstractTableModel {

	private String[] colNames = { "ID", "Ime i Prezime", "Adresa", "Telefon", "Email", "Opis ponude"};
	private List<Stranka> stranke;
	private List<Nekretnina> nekretnine;
	private Database dbs = new Database();
	//private String opisPonude;
	

	public void setTableData(List<Stranka> stranke, List<Nekretnina> nekretnine) {

		this.stranke = stranke;
		this.nekretnine=nekretnine;
		
		
	
		//System.out.println("Size: " + nekretnine.size());
		
		for (Stranka stranka : stranke) {
			//System.out.println(stranke.getID() + " : " + stranke.getMail());
		}
	}

	public TableModelStranke() {

	}

	@Override
	public int getColumnCount() {

		return colNames.length;
	} 

	@Override
	public int getRowCount() {

		if (stranke!=null) {
			return  stranke.size();
		} else {
			return 0;
		}
	}

	@Override
	public Object getValueAt(int row, int col) {

		 Stranka stranka = stranke.get(row);
		 
		//if ( nekretnine.get(row).isPonuda()) return null;
		//Nekretnina nekretnina = nekretnine.get(row);
		 
		 String opisPonude = "";
		 
		 for (int i=0; i<nekretnine.size();i++) {
				if (nekretnine.get(i).getImeStranke().equals(stranka.getImePrezime()) & nekretnine.get(i).isPonuda()) {
					opisPonude="Prodaje";
				} else if (nekretnine.get(i).getImeStranke().equals(stranka.getImePrezime()) & !nekretnine.get(i).isPonuda()) {
					opisPonude="Kupuje";
				} 
			}
		
			 switch(col) {
			 case 0:
				 return stranka.getId();

			 case 1:
				return stranka.getImePrezime();
		 
			 case 2:
				 return stranka.getAdresaStanovanja();
			 
			 case 3:
				 return stranka.getTel();
		 
			 case 4:
				 return stranka.getEmail();
			 case 5:
				return opisPonude;

			 
		 
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
		
		this.stranke.remove(row);
		dbs.refreshData(stranke, nekretnine);
    }

}
