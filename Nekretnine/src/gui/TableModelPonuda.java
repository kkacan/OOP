package gui;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.Controller;
import model.Nekretnina;

/**
 * Klasa koja pro�iruje AbstractTableModel i koristi nam za manipulaciju podacima tablice nekretnina tipa ponuda.
 * @author Kristijan Ka�an
 * @since lipanj, 2018.
 */
public class TableModelPonuda extends AbstractTableModel {

	private String[] colNames = { "ID", "Vrsta nekretnine", "Vrsta ponude", "Mjesto", "Ulica i k. broj", "Cijena", "Stranka"};
	
	private List<Nekretnina> nekretninePon;
	private List<Nekretnina> nekretninePot;
	private Controller controller;
	
	public TableModelPonuda() {

	}
	
	/**
	 * Metoda koja u�itava nekretnine i razvrstava ih prema tipu.
	 * @param nekretnine ArrayList nekretnine
	 */
	public void setTableData(List<Nekretnina> nekretnine) {

		this.nekretninePon = new ArrayList<Nekretnina>();
		this.nekretninePot = new ArrayList<Nekretnina>();
		
		for (int i=0; i<nekretnine.size();i++) {
			if (nekretnine.get(i).isPonuda()) {
				this.nekretninePon.add(nekretnine.get(i));
			} else {
				this.nekretninePot.add(nekretnine.get(i));
			}
		}


	}

	@Override
	public int getColumnCount() {

		return colNames.length;
	} 

	@Override
	public int getRowCount() {

		if (nekretninePon!=null) {
			return  nekretninePon.size();
		} else {
			return 0;
		}
	}

	/**
	 * Metoda koja popunjava tablicu.
	 * @param row red tablice
	 * @param col kolona tablice
	 */
	@Override
	public Object getValueAt(int row, int col) {

		Nekretnina nekretnina = nekretninePon.get(row);
		
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
			 }
		return null;
		 
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	/**
	 * Metoda koja bri�e nekretninu koja se nalazi u odre�enom redu u tablici i a�urira bazu podataka.
	 * @param row red tablice
	 */
	public void removeRow(int row) {
		
		this.nekretninePon.remove(row);
		
		List<Nekretnina> nekretnine= new ArrayList();
		
		nekretnine.addAll(nekretninePon);
		nekretnine.addAll(nekretninePot);
		
		controller.refreshDataNekretnine(nekretnine);
    }
	
	/**
	 * Metoda koja postavlja controlller.
	 * @param cntrl objekt tipa Controller
	 */
	public void setController(Controller cntrl) {
		this.controller = cntrl;
	}

}
