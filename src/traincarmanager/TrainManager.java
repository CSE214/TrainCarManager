package traincarmanager;

/**
* The main method runs a menu driven application which first creates an empty <code>TrainLinkedList</code> object. 
* The program prompts the user for a command to execute an operation. Once a command has been chosen, 
* the program may ask the user for additional information if necessary, and performs the operation.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class TrainManager {

	public static void main(String[] args) {
		String header = String.format("%25s%15s%15s%15s", "Name", "Weight (t)", "Value ($)", "Dangerous");
		String border = "=========================================================================================";
		String test = ProductLoad.toTableString("Corn", 100, 15440, true);
		System.out.println(header);
		System.out.println(border);
		System.out.println(test);

	}

}
