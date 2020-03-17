package tema3;





import presentation.Controller;
import presentation.View;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		View v = new View();
		Controller c = new Controller(v);
		

		v.setVisible(true);
	
	}

}
