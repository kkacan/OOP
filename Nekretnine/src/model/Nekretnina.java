package model;

import java.io.Serializable;


/**
 * Klasa koja predstavlja objekt tipa Nekretnina 
 * koja implementira serijalizaciju zbog spremanja 
 * u datoteku. Sadrži sve parametre nekretnine i njihove getterse i setterse.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class Nekretnina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String vrstaNekretnine;
	private String mjesto;
	private String ulica;
	private String cijena;
	private String vrstaPonude;
	private boolean ponuda;
	private String imeStranke;
	private int id;
	
	public Nekretnina (int id, String vrstaNekretnine, String mjesto, String ulica, String cijena, String vrstaPonude, boolean ponuda, String imeStranke) {
		
		this.vrstaNekretnine=vrstaNekretnine;
		this.mjesto=mjesto;
		this.ulica=ulica;
		this.cijena=cijena;
		this.vrstaPonude=vrstaPonude;
		this.ponuda=ponuda;
		this.imeStranke=imeStranke;
		this.id=id;
		
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
