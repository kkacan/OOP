package model;

import java.io.Serializable;

public class Stranka implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imePrezime;
	private String adresaStanovanja;
	private String tel;
	private String email;
	private int id;
	//private static int cnt=1;

	
	public Stranka(int id, String imePrezime,String adresaStanovanja,String tel,String email) {
		
		this.imePrezime=imePrezime;
		this.adresaStanovanja=adresaStanovanja;
		this.tel=tel;
		this.email=email;
		this.id=id;
		//cnt++;
	}


	public String getImePrezime() {
		return imePrezime;
	}


	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}


	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}


	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


/*	public static int getCnt() {
		return cnt;
	}


	public static void setCnt(int cnt) {
		Stranka.cnt = cnt;
	}*/



	
}
