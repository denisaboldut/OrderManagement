package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.Client;
import model.Produs;
import presentation.View;

public class DataAccess {
	private String mesajEroare;
	private int idComanda;
	private int idClient;
	private int idProdus;
	private int cantitate_comandata;
	private Client client;
	private Produs produs;
	
public void incarcaDateClienti() {	
		try(Connection con = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost/tema3tp?user=root&password=boldutdenisateodora05021998");
		 Statement stmt = (Statement) con.createStatement()){
			System.out.println("dsad");
			ResultSet rs=stmt.executeQuery("select * from clienti");
			ResultSetMetaData metaData=rs.getMetaData();			
			//Nume de coloana aici
			Vector<String> numeColoana = new Vector<String>();
			int nrColoane = metaData.getColumnCount();
			for(int i=1;i<=nrColoane;i++) {
				numeColoana.add(metaData.getColumnName(i));
			}	
			//Date din tabel
			Vector<Vector<Object>> data =new Vector<Vector<Object>>();
			while (rs.next()) {
				Vector<Object> vector =new Vector<Object>();
				for(int i =1; i<=nrColoane;i++) {
					vector.add(rs.getObject(i));
				}
				data.add(vector);
			}		
		View.tableModel.setDataVector(data, numeColoana);
		rs.close();
		stmt.close();
		con.close();
		}catch(Exception e) {
			System.out.println("Eroare preluare date despre clienti");
			mesajEroare="Eroare preluare date despre clienti";	}	}
		
    public void incarcaDateProduse(){
	   try(Connection con = (Connection) DriverManager
			.getConnection("jdbc:mysql://localhost/tema3tp?user=root&password=boldutdenisateodora05021998");
	   Statement stmt = (Statement) con.createStatement()){
		ResultSet rs=stmt.executeQuery("select * from produse");
		ResultSetMetaData metaData=rs.getMetaData();		
		//Nume de coloana aici
		Vector<String> numeColoana = new Vector<String>();
		int nrColoane = metaData.getColumnCount();
		for(int i=1;i<=nrColoane;i++) {
			numeColoana.add(metaData.getColumnName(i));
		}	
		//Date din tabel
		Vector<Vector<Object>> data =new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector =new Vector<Object>();
			for(int i =1; i<=nrColoane;i++) {
				vector.add(rs.getObject(i));	}
			data.add(vector);
			}
		
	View.tableModel2.setDataVector(data, numeColoana);
	rs.close();
	stmt.close();
	con.close();
	}catch(Exception e) {
		System.out.println("no");
		mesajEroare="Eroare preluare date despre produse";
	}	
}

public void incarcaComanda(){
	Connection con = null;
	PreparedStatement in = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception ex) {
		System.err.println("Eroare la conectare");
		ex.printStackTrace(System.err);	}
	try {
		con = (Connection) DriverManager
				.getConnection("jdbc:mysql://localhost/tema3TP?user=root&password=boldutdenisateodora05021998");
		in = con.prepareStatement(
				"INSERT INTO comenzi (idcomanda, idclient, idprodus, cantitate_comandata) VALUES  (?,?,?,?)");
		in.setInt(1, idComanda);
		in.setInt(2, idClient);
		in.setInt(3, idProdus);
		in.setInt(4, cantitate_comandata);
		in.executeUpdate();
		in.close();	con.close();			
	} catch (SQLException e) {
		System.err.println("Eroare la inserare");    }
	finally {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {	}
		con = null;		}
		}
}

public void adauga(int individ) {
	Connection con = null;
	PreparedStatement in1 = null; 
    PreparedStatement in2 = null; 	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception ex) {
		System.err.println("Eroare la conectare");
		ex.printStackTrace(System.err);}	
	try {
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tema3TP?user=root&password=boldutdenisateodora05021998");
		if(individ==0) { //adica adaugam un client
		in1 = con.prepareStatement(
				"INSERT INTO clienti (idclient, nume,credit) VALUES  (?,?,?)");
		in1.setInt(1, client.getId_client());
		in1.setString(2, client.getNume());
		in1.setInt(3, client.getCredit());
		in1.executeUpdate();
		con.close();
		}
		if(individ==1) { //adica adaugam un produs
			in2 = con.prepareStatement(
					"INSERT INTO produse (idprodus,denumire,cantitate_disponibila,pret) VALUES  (?,?,?,?)");
			in2.setInt(1, produs.getId_produs());
			in2.setString(2, produs.getDenumire());
			in2.setInt(3, produs.getCantitate_disponibila());
			in2.setInt(4, produs.getPret());
			in2.executeUpdate();
			con.close();
		}
	} catch (SQLException e) {
		System.err.println("Eroare la inserare");}
	finally {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {		}
			con = null;
		}
	}
}

public void modificare(int individ,int modificare) {
	Connection con = null;
	PreparedStatement update1 = null;
	PreparedStatement update2 = null;
	PreparedStatement stergere1 = null;
	PreparedStatement stergere2 = null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception ex) {
		System.err.println("Eroare la conectare");
		ex.printStackTrace(System.err);
	}
	try {
		con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/tema3TP?user=root&password=boldutdenisateodora05021998");
			if(individ==0) { //adica modificam clientul
			update1 = con.prepareStatement("UPDATE clienti SET nume=?,credit=? where idclient="+client.getId_client());
		update1.setString(1, client.getNume());
		update1.setInt(2, modificare);
		update1.executeUpdate();
		con.close();
		}
		if(individ==1) {  //adica modificam produsul	
			update2 = con.prepareStatement(	"UPDATE produse SET denumire=?,cantitate_disponibila=?,pret=? where idprodus="+produs.getId_produs());
			update2.setString(1,produs.getDenumire());
			update2.setInt(2, modificare);
			update2.setInt(3, produs.getPret());
			update2.executeUpdate();
			}
		if(individ==2) { //adica stergem client
			con.setAutoCommit(true);
			stergere1= con.prepareStatement("DELETE from clienti WHERE idclient="+client.getId_client());
			stergere1.executeUpdate();	
			con.close();
		}
		if(individ==3) { //adica stergem produs		
			stergere2= con.prepareStatement("DELETE from produse WHERE idprodus="+produs.getId_produs());
			stergere2.executeUpdate();
		}	
	} catch (SQLException e) {
		System.err.println("Eroare la modificare");

	}
	finally {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {	}
			con = null;
		}
	}
}

public String getMesajEroare() {
	return mesajEroare;}
public int getIdComanda(  ) {
	return idComanda;	}
public void setIdComanda(int idComanda) {
	this.idComanda = idComanda;}
public int getIdClient(  ) {
	return idClient;}
public void setIdClient(int idClient) {
	this.idClient = idClient;}
public int getIdProdus() {	
	return idProdus;
}
public void setIdProdus(int idProdus) 
{
	this.idProdus = idProdus;
}

public int getCantitate_comandata()
{
	return cantitate_comandata;
}

public void setCantitate_comandata(int cantitate_comandata) {
	this.cantitate_comandata = cantitate_comandata;}
public void setClient(Client c) {
	client=new Client(c);
}
public void setProdus(Produs p) {
	produs=new Produs(p.getId_produs(),p.getDenumire(),p.getCantitate_disponibila(),p.getPret());
}
}
