package gui;

import java.util.EventObject;

/**
 * Klasa koja proširuje EventObject i služi za prijenos podataka sa desnog panela i dialoga za izmjenu stranke.
 * Sadrži sve parametre stranke i njihove getterse i setterse.
 * @author Kristijan Kaèan
 * @since lipanj, 2018.
 */
public class RightFormEvent extends EventObject {
	
	private String ime;
	private String adresa;
	private String tel;
	private String email;

	public RightFormEvent(Object arg0) {
		super(arg0);
		
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
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



}
