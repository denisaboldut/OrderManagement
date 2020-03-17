package model;

public class Produs {
  
	int id_produs;
    String denumire;
    int cantitate_disponibila;
    int pret;
    
    public Produs(int id_produs, String denumire, int cantitate_disponibila, int pret) {
  		super();
  		this.id_produs = id_produs;
  		this.denumire = denumire;
  		this.cantitate_disponibila = cantitate_disponibila;
  		this.pret = pret;
  	}

	public Produs(Produs p) {
		// TODO Auto-generated constructor stub
	  id_produs=p.id_produs;
	  denumire=p.denumire;
	  cantitate_disponibila=p.cantitate_disponibila;
	  pret=p.pret;
	}

	public int getId_produs() {
	
		return id_produs;
	}

	public void setId_produs(int id_produs) {
	
		this.id_produs = id_produs;
	}

	public String getDenumire() {
		
		return denumire;
	}

	public void setDenumire(String denumire) {
		
		this.denumire = denumire;
	}

	public int getCantitate_disponibila() {
		
		return cantitate_disponibila;
	}

	public void setCantitate_disponibila(int cantitate_disponibila) {
		
		this.cantitate_disponibila = cantitate_disponibila;
	}

	public int getPret() {
		
		return pret;
	}

	public void setPret(int pret) {
		
		this.pret = pret;
	}
    
    
}
