package model;

public class Buy {

	private String delivery;
	private String gcText;
	private int decPckg;
	private String gCard;
	private boolean nLetters;
	private String payment;
	private String category;
	private int id;
	private static int cnt=1;
	
	public Buy(String delivery,String gcText,int decPckg,String gCard,boolean nLetters,String payment,String category) {
		this.delivery=delivery;
		this.gcText=gcText;
		this.decPckg=decPckg;
		this.gCard=gCard;
		this.nLetters=nLetters;
		this.payment=payment;
		this.category=category;
		this.id=cnt;
		cnt++;
		
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	public String getGcText() {
		return gcText;
	}

	public void setGcText(String gcText) {
		this.gcText = gcText;
	}

	public int isDecPckg() {
		return decPckg;
	}

	public void setDecPckg(int decPckg) {
		this.decPckg = decPckg;
	}

	public String getgCard() {
		return gCard;
	}

	public void setgCard(String gCard) {
		this.gCard = gCard;
	}

	public boolean isnLetters() {
		return nLetters;
	}

	public void setnLetters(boolean nLetters) {
		this.nLetters = nLetters;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
