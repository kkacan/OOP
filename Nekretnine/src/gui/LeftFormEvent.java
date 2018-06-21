package gui;

import java.util.EventObject;

public class LeftFormEvent extends EventObject {
	
	private String vrstaNekretnine;
	private String mjesto;
	private String ulica;
	private String cijena;
	private String vrstaPonude;
	private boolean ponuda;
	private String imeStranke;

	public LeftFormEvent(Object arg0) {
		super(arg0);
		
	}

	public String getVrstaNekretnine() {
		return vrstaNekretnine;
	}

	public void setVrstaNekretnine(String vrstaNekretnine) {
		this.vrstaNekretnine = vrstaNekretnine;
	}

	public String getMjesto() {
		return mjesto;
	}

	public void setMjesto(String mjesto) {
		this.mjesto = mjesto;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getCijena() {
		return cijena;
	}

	public void setCijena(String cijena) {
		this.cijena = cijena;
	}

	public String getVrstaPonude() {
		return vrstaPonude;
	}

	public void setVrstaPonude(String vrstaPonude) {
		this.vrstaPonude = vrstaPonude;
	}

	public boolean isPonuda() {
		return ponuda;
	}

	public void setPonuda(boolean ponuda) {
		this.ponuda = ponuda;
	}

	public String getImeStranke() {
		return imeStranke;
	}

	public void setImeStranke(String imeStranke) {
		this.imeStranke = imeStranke;
	}
	
	

}
