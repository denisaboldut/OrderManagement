package businessLogic;

import model.Client;


public class CreditValidare implements InterfataValidare <Client>{

	@Override
	public void conditieValidare(Client obiect,int comparator)  throws Exception {
		// TODO Auto-generated method stub
		if(obiect.getCredit()<comparator) {
			throw new Exception ("Creditul este insuficient. Ne pare rau");
		}
	}


}
