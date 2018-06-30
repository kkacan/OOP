package gui;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import controller.Controller;
import model.Nekretnina;
import model.Stranka;

/**
 * Klasa koja proširuje AbstractTableModel i koristi nam za manipulaciju podacima tablice stranaka.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class TableModelStranke extends AbstractTableModel {

	private String[] colNames = { "ID", "Ime i Prezime", "Adresa", "Telefon", "Email", "Opis ponude"};
	private List<Stranka> stranke;
	private List<Nekretnina> nekretnine;
	private Controller controller;

	/**
	 * Metoda koja uèitava nekretnine i stranke.
	 * @param stranke ArrayList stranke
	 * @param nekretnine ArrayList nekretnine
	 */
	public void setTableData(List<Stranka> stranke, List<Nekretnina> nekretnine) {

		this.stranke = stranke;
		this.nekretnine=nekretnine;

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
			return stranke.size();
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

		 Stranka stranka = stranke.get(row);
		 
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
		return null;
		 
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}
	
	/**
	 * Metoda koja briše stranku koja se nalazi u odreðenom redu u tablici i ažurira bazu podataka.
	 * @param row red tablice
	 */
	public void removeRow(int row) {
		
		this.stranke.remove(row);
		controller.refreshDataStranke(stranke);
    }
	
	/**
	 * Metoda koja postavlja controlller.
	 * @param cntrl objekt tipa Controller
	 */
	public void setController(Controller cntrl) {
		this.controller = cntrl;
	}

}
