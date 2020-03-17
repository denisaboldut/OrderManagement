package presentation;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;


import businessLogic.CantitateValidare;
import businessLogic.CreditValidare;
import dataAccess.DataAccess;
import model.Client;
import model.Produs;

public class Controller  {
	private View view;
	private DataAccess date=new DataAccess();
	private Client client;
	private Produs produs;
	CantitateValidare cv=new CantitateValidare();
	CreditValidare crv=new CreditValidare();
	
	public Controller(View v) {
		view=v;
		view.addClientiListener(new ClientiListener());
		view.addProduseListener(new ProduseListener());
		view.addComandaListener(new VerificareComanda());
		view.adaugareClientListener(new AdaugareClient());
		view.adaugareProdusListener(new AdaugareProdus());
		
		view.table.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	DefaultTableModel modelTabel=(DefaultTableModel)view.table.getModel();
				int randSelectat=view.table.getSelectedRow();
				System.out.println(modelTabel.getValueAt(randSelectat, 0).toString());
				System.out.println(modelTabel.getValueAt(randSelectat, 1).toString());
				System.out.println(modelTabel.getValueAt(randSelectat, 2).toString());
				//System.out.println(modelTabel.getValueAt(randSelectat, 3).toString());
                view.setidClient(modelTabel.getValueAt(randSelectat, 0).toString());
                view.setNumeClient(modelTabel.getValueAt(randSelectat, 1).toString());
                client=new Client(Integer.parseInt(modelTabel.getValueAt(randSelectat, 0).toString()),
                		modelTabel.getValueAt(randSelectat, 1).toString(),
                		Integer.parseInt(modelTabel.getValueAt(randSelectat, 2).toString()));
               // view.showError("as");
                view.editareClientListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						date.setClient(client);
						date.modificare(0,client.getCredit());
						date.incarcaDateClienti();
						
					}    	
                });
                view.stergereClientListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						date.setClient(client);
						date.modificare(2,client.getCredit());
						date.incarcaDateClienti();
					}
                	
                });
             
		        }
		
});
		view.table2.addMouseListener(new java.awt.event.MouseAdapter() {
		    @Override
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		    	DefaultTableModel modelTabel=(DefaultTableModel)view.table2.getModel();
				int randSelectat=view.table2.getSelectedRow();
				System.out.println(modelTabel.getValueAt(randSelectat, 0).toString());
				System.out.println(modelTabel.getValueAt(randSelectat, 1).toString());
				System.out.println(modelTabel.getValueAt(randSelectat, 2).toString());
				System.out.println(modelTabel.getValueAt(randSelectat, 3).toString());
				view.setidProdus(modelTabel.getValueAt(randSelectat, 0).toString());
                view.setCantitate(modelTabel.getValueAt(randSelectat, 2).toString());
                produs=new Produs(Integer.parseInt(modelTabel.getValueAt(randSelectat, 0).toString()),
                		                  modelTabel.getValueAt(randSelectat, 1).toString(),
                		                  Integer.parseInt(modelTabel.getValueAt(randSelectat, 2).toString()),
                		                  Integer.parseInt(modelTabel.getValueAt(randSelectat, 3).toString()));
                  view.editareProdusListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						date.setProdus(produs);
						date.modificare(1,produs.getCantitate_disponibila());
						date.incarcaDateProduse();
						
					}
                	  
                  });
                  view.stergereProdusListener(new ActionListener() {

  					@Override
  					public void actionPerformed(ActionEvent arg0) {
  						// TODO Auto-generated method stub
  						date.setProdus(produs);
  						date.modificare(3,produs.getCantitate_disponibila());
  						date.incarcaDateProduse();
  					}            	
                  });
		        }
		
             });
	}
	public class ClientiListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new SwingWorker<Void,Void>(){
				@Override
			protected Void doInBackground() throws Exception {
					date.incarcaDateClienti();
					return null;
				}			
			}.execute();
		}
		
	}	
	public class ProduseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new SwingWorker<Void,Void>(){
				@Override
				protected Void doInBackground() throws Exception {
					date.incarcaDateProduse();
					return null;
				}
				
			}.execute();
		}	
	}
    public Client getClient() {
		return client;
	}
	public Produs getProdus() {
		return produs;
	}
	
	public class VerificareComanda implements ActionListener {
		int valid = 1;		
               @Override
         public void actionPerformed(ActionEvent arg0) {
	               try {
	         	cv.conditieValidare(produs, view.getCantitateDorita());         	
	          } catch (Exception e) {
	        	  valid=0;
		view.showError(e.getMessage());
	          }
		try {
		  int  cost=produs.getPret()*view.getCantitateDorita();	
         	crv.conditieValidare(client,cost);     	
          } catch (Exception e1) {
        	  valid=0;
	         view.showError(e1.getMessage());
            } 
         date.setIdClient(view.getIdClient());
         date.setIdProdus(view.getIdProdus());
         date.setCantitate_comandata(view.getCantitateDorita());
         date.setIdComanda(view.getIdClient()+view.getIdProdus());
         date.setClient(client);
         date.setProdus(produs);
         date.incarcaComanda();
         int nouCredit=client.getCredit()-(produs.getPret()*view.getCantitateDorita());
         int nouCantitate=produs.getCantitate_disponibila()-view.getCantitateDorita();
         date.modificare(0,nouCredit );
         date.modificare(1, nouCantitate);
         date.incarcaDateClienti();
         date.incarcaDateProduse();
         view.setCantitate(String.valueOf(nouCantitate));
         try {
        	 PrintWriter writer = new PrintWriter("factura"+client.getId_client()+".txt", "UTF-8");
        	 writer.println("----FACTURA----");
        	 writer.println("CLIENTUL CU ID-UL= "+client.getId_client()+", NUME=" +client.getNume()+
        			 " a solicitat "+produs.getDenumire()+" in cantitate de: "+view.getCantitateDorita());
        	 writer.println("COSTUL TRANZACTIEI ESTE DE: "+produs.getPret()*view.getCantitateDorita());
        	 writer.println("IN DEPOZIT AU MAI RAMAS: "+nouCantitate+" "+produs.getDenumire());
        	 writer.println("Din creditul clientului in valoare de: "+client.getCredit()+", a mai ramas: "+nouCredit);
        	 writer.close();
         }catch(Exception e){
        System.out.println("Nu s-a putut crea factura");	 
         }         
		}              
   	}
	
	public class AdaugareClient implements ActionListener {
     	@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Client c=new Client(view.getIdClientdeIntrodus(),view.getNumedeIntrodus(),view.getCreditdeIntrodus());
			date.setClient(c);
			date.adauga(0);
			date.incarcaDateClienti();
		}
		
	}
	public class AdaugareProdus implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Produs p=new Produs(view.getIdProdusdeIntrodus(),view.getDenimiredeIntrodus(),view.getProdCantitateIntrodus(),view.getPretIntrodus());
			date.setProdus(p);
			date.adauga(1);
			date.incarcaDateProduse();			
		}	
	}	
}



