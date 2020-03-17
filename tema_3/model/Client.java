package model;

public class Client {

	int id_client;
	String nume;
	int credit;
	
	
	public Client(int id_client, String nume, int credit) {
		super();
		this.id_client = id_client;
		this.nume = nume;
		this.credit = credit;
	}
	
	
	public Client(Client c) {
		// TODO Auto-generated constructor stub
		id_client=c.id_client;
		nume=c.nume;
		credit=c.credit;
	}


	public int getId_client() {
		
		return id_client;
	}
	public void setId_client(int id_client) {
		
		this.id_client = id_client;
	}
	public String getNume() {
	
		return nume;
	}
	public void setNume(String nume) {
		
		this.nume = nume;
	}
	public int getCredit() {
		
		return credit;
	}
	public void setCredit(int credit) {
		
		this.credit = credit;
	}

}
