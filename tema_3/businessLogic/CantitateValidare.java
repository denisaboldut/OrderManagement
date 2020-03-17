package businessLogic;

import model.Produs;

public class CantitateValidare implements InterfataValidare <Produs>{

	@Override
	public void conditieValidare(Produs obiect,int comparator)  throws Exception {
		// TODO Auto-generated method stub
		if(obiect.getCantitate_disponibila()<comparator) {
			throw new Exception ("Cantitate indisponibila");
		}
	}

}
