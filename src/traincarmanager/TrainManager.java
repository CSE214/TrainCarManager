package traincarmanager;

import java.util.Scanner;

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
	private static TrainLinkedList train = new TrainLinkedList(); // Stores the train data
	private static Scanner in = new Scanner(System.in); // Takes input from user
	
	/**
	 * Prints a list of commands for the user.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The list of commands has been printed.</dd>
	 * </dl>
	 * 
	 */
	public static void printMenu() {
		System.out.println("\n(F) Cursor Forward\r\n" + "(B) Cursor Backward\r\n" + "(I) Insert Car After Cursor\r\n"
				+ "(R) Remove car at cursor\r\n" + "(L) Set Product Load\r\n" + "(S) Search For Product\r\n"
				+ "(T) Display Train\r\n" + "(M) Display Manifest\r\n" + "(D) Remove Dangerous Cars\r\n"
				+ "(Q) Quit" + "\n");
	}

	/**
	 * Delegates which function to run depending on the command entered..
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The command has called the appropriate function.</dd>
	 * </dl>
	 */
	public static void commandManager() {
		System.out.print("Enter a selection: ");
		String command = in.nextLine().trim();
		System.out.println("");
		switch (command.toUpperCase()) {
		case "F": {
			cursorForward();
			break;
		}
		case "B": {
			cursorBackward();
			break;
		}
		case "I": {
			insertCar();
			break;
		}
		case "R": {
			removeCar();
			break;
		}
		case "L": {
			setProductLoad();
			break;
		}
//		case "S": {
//			searchForProduct();
//			break;
//		}
		case "T": {
			displayTrain();
			break;
		}
		case "M": {
			displayManifest();
			break;
		}
		case "D": {
			removeDangerousCars();
			break;
		}
		case "Q": {
			System.out.println("Program terminating successfully...");
			System.exit(0);
			break;
		}
		default: {
			System.out.println("That command is not valid. Please try again.\n");
			commandManager();
		}
		}
	}

	/**
	 * Attempts to move the cursor forward. The user is then shown the appropriate message.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The cursor tries to move forward, and the appropriate message is shown.
	 * The user returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	private static void cursorForward() {
		try {
			train.cursorForward();
			System.out.println("The cursor has been moved forward.");
		} catch (CursorBoundsException e) {
			System.out.println("No next car, cannot move cursor forward.");
		}
		printMenu();
		commandManager();
	}
	
	/**
	 * Attempts to move the cursor backward. The user is then shown the appropriate message.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The cursor tries to move backward, and the appropriate message is shown.
	 * The user returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	private static void cursorBackward() {
		try {
			train.cursorBackward();
			System.out.println("The cursor has been moved backward.");
		} catch (CursorBoundsException e) {
			System.out.println("No previous car, cannot move cursor backward.");
		}
		printMenu();
		commandManager();	
	}
	
	/**
	 * Inserts a new empty car after the cursor. If the cursor is null (i.e. the train is empty), 
	 * the car is set as the head of the train. After insertion, the cursor is set to the newly 
	 * inserted car.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The new car is inserted into the linked list with the cursor pointing to it. The user
	 * then returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	private static void insertCar() {
		System.out.print("Enter car length in meters: ");
		double length = Double.parseDouble(in.nextLine());
		System.out.print("Enter car weight in tons: ");
		double weight = Double.parseDouble(in.nextLine());
		
		try {
			TrainCar newTrainCar = new TrainCar(length, weight);
			train.insertAfterCursor(newTrainCar);
			System.out.println("New train car " + length + " meters " + weight + " tons inserted into train.");
			printMenu();
			commandManager();
		} catch (NotPositiveNumberException e) {
			System.out.println("Invalid length/weight. Inputs must be positive double values");
			printMenu();
			commandManager();
		}
	}
	
	/**
	 * Removes the car at current position of the cursor. After deletion, the cursor is set to 
	 * the next car in the list if one exists, otherwise the previous car. If there is no previous 
	 * car, the list is empty and the cursor is set to null.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The new car is inserted into the linked list with the cursor pointing to it. The user
	 * then returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	public static void removeCar() {
		try {
			train.removeCursor();
			System.out.println("The car at the cursor has been removed.");
		} catch (EmptyListException e) {
			System.out.println("The list is already empty.");
		}
		printMenu();
		commandManager();
	}
	/**
	 * Sets the product load at the current position in the list.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * Sets the product load at the current cursor, and returns the user to the main menu.
	 * </dd>
	 * </dl>
	 */
	public static void setProductLoad() {
		System.out.print("Enter product name: ");
		String name = in.nextLine();
		System.out.print("Enter product weight in tons: ");
		double weight = Double.parseDouble(in.nextLine());
		System.out.print("Enter product value in dollars: ");
		double value = Double.parseDouble(in.nextLine());
		System.out.print("Is the product dangerous? (y/n): ");
		String input = in.nextLine().toLowerCase();
		boolean isDangerous = false;
		if (input.equals("y")) {
			isDangerous = true;
		} else if (input.equals("n")) {
			isDangerous = false;
		} else {
			System.out.println("Please enter 'y' or 'n'.");
			printMenu();
			commandManager();
		}
		
		try {
			train.getCursorData().setLoad(new ProductLoad(name, weight, value, isDangerous));
			System.out.println(weight + " tons of " + name + " added to the current car.");
			printMenu();
			commandManager();
		} catch (NotPositiveNumberException e) {
			System.out.println("Weight and value must both be positive.");
			printMenu();
			commandManager();
		}
	}
	/**
	 * Searches the train for all the loads with the indicated name and prints out the total 
	 * weight and value, and whether the load is dangerous or not. If the product could not be 
	 * found, indicate to the user that the train does not contain the indicated product.
	 */
	public void searchForProduct() {
		System.out.print("Enter name of product");
		String productName = in.nextLine();
		train.findProduct(productName);
	}
	/**
	 * Prints the string representation of the <code>train</code>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The string representation of <code>train</code> is printed.
	 * The user returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	private static void displayTrain() {
		System.out.println(train.toString());
		printMenu();
		commandManager();
	}
	
	private static void displayManifest() {
		train.printManifest();
		printMenu();
		commandManager();
	}

	/**
	 * Removes all dangerous cars from <code>train</code>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * <code>train</code> has no dangerous cars.
	 * The user returns to the main menu.
	 * </dd>
	 * </dl>
	 * 
	 */
	private static void removeDangerousCars() {
		train.removeDangerousCars();
		System.out.println("Dangerous cars successfully removed from the train.");
		printMenu();
		commandManager();
	}

	/**
	 * Starts the program, and sends the user to the main menu.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The user enters the main menu.</dd>
	 * </dl>
	 * 
	 */
	public static void main(String[] args) {
		printMenu();
		commandManager();
	}

}
