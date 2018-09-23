package traincarmanager;

/**
* The <code>TrainlinkedList</code> class implements an abstract data 
* type for a Double-Linked List of train cars supporting some 
* common operations on such lists, as well as a few others.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class TrainLinkedList {
	private TrainCarNode head; // Head of the linked list
	private TrainCarNode tail; // Tail of the linked list
	private TrainCarNode cursor; // Node currently referenced by cursor
	
	private int carCount; // Number of cars in list
	private double totalLength; // Total length of all cars in list
	private double totalValue; // Total value of all cars in list
	private double totalWeight; // Total weight of all cars in list
	private int dangerCount; // Number of dangerous cars in list
	/**
	 * Returns an instance of <code>TrainLinkedList</code> 
	 * with no <code>TrainCarObjects</code> in it. 
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>This <code>TrainLinkedList</code> has been initialized
	 * to an empty linked list. Head, tail, and cursor are all
	 * set to null. </dd>
	 * </dl>
	 */
	public TrainLinkedList (){
		this.head=null;
		this.tail=null;
		this.cursor=null;
		
		this.carCount = 0;
		this.totalLength=0;
		this.totalValue=0;
		this.totalWeight=0;
		this.dangerCount=0;
	}
	/**
	 * Updates the data from either removing or setting a car.
	 * 
	 * @param car
	 * 	The car that is being set or removed.
	 * @param mode
	 * 	Tells the function whether the car is set or removed.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The data now accounts for the new/missing car.</dd>
	 * </dl>
	 * 
	 */
	public void updateNumberData(TrainCar car, String mode) {
		if (mode == "-") {
			carCount -= 1;
			totalLength -= car.getLength();
			totalWeight -= car.getWeight();
			if (car.getLoad() != null) {
				totalValue -= car.getLoad().getValue();
				totalWeight -= car.getLoad().getWeight();
				if(car.getLoad().isDangerous()) {
					dangerCount -= 1;
				}
			}
		} else if (mode == "+") {
			carCount += 1;
			totalLength += car.getLength();
			totalWeight += car.getWeight();
			if (car.getLoad() != null) {
				totalValue += car.getLoad().getValue();
				totalWeight += car.getLoad().getWeight();
				if(car.getLoad().isDangerous()) {
					dangerCount += 1;
				}
			}
		}
	}
	/**
	 * Returns a reference to the <code>TrainCar</code> at the node currently referenced by the cursor.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>The list is not empty (cursor is not null)</dd>
	 * </dl>
	 * 
	 * @return 
	 *	The reference to the TrainCar at the node currently referenced by the cursor.
	 *
	 * @throws IllegalArgumentException
	 * 	if the cursor is null
	 */
	public TrainCar getCursorData(){
		return cursor.getCar();
	}
	/**
	 * Places <code>car</code> in the node currently referenced by the cursor.
	 * 
	 * @param car
	 * 	The <code>TrainCar</code> to be set in the node.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>The list is not empty (cursor is not null)</dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The cursor node now contains a reference to <code>car</code> as its data.</dd>
	 * </dl>
	 * 
	 */
	public void setCursorData(TrainCar car) {
		updateNumberData(cursor.getCar(), "-");
		this.cursor.setCar(car);
		updateNumberData(cursor.getCar(), "+");
	}
	/**
	 * Moves the cursor to point at the next <code>TrainCarNode</code>.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>The list is not empty (cursor is not null) and cursor does not currently reference the tail of the list.</dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The cursor has been advanced to the next TrainCarNode, or has remained at the tail of the list.</dd>
	 * </dl>
	 * 
	 * @throws CursorBoundsException
	 * 	if the cursor is currently referencing the tail
	 */
	public void cursorForward() throws CursorBoundsException{
		if (cursor == tail) {
			throw new CursorBoundsException("The cursor is at the tail of the list.");
		}
		cursor = cursor.getNext();
	}
	/**
	 * Moves the cursor to point at the previous TrainCarNode.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>The list is not empty (cursor is not null) and the cursor does not currently reference the head of the list.</dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>The cursor has been moved back to the previous TrainCarNode, or has remained at the head of the list.</dd>
	 * </dl>
	 * 
	 * @throws CursorBoundsException
	 * 	if the cursor is currently referencing the tail
	 */
	public void cursorBackward() throws CursorBoundsException {
		if (cursor == head) {
			throw new CursorBoundsException("The cursor is at the tail of the list.");
		}
		cursor = cursor.getPrev();
	}
	
	/**
	 * Checks if the cursor is null
	 * 
	 * @return
	 * 	True if the cursor is null, false otherwise
	 */
	public boolean cursorIsNull() {
		return cursor == null;
	}
	/**
	 * Inserts <code>newCar</code> into the train after the cursor position.
	 * 
	 * @param newCar
	 * 	The new <code>TrainCar</code> to be inserted.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>This <code>TrainCar</code> object has been instantiated.</dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The new <code>TrainCar</code> has been inserted into the train after the position of the cursor.
	 * All <code>TrainCar</code> objects previously on the train are still on the train, and their order 
	 * has been preserved. The cursor now points to the inserted car.
	 * </dd>
	 * </dl>
	 * 
	 *
	 */
	public void insertAfterCursor(TrainCar newCar) {
		TrainCarNode newCarNode = new TrainCarNode(newCar);
		updateNumberData(newCar, "+");
		
		if (head == null) {
			head = newCarNode;
			tail = newCarNode;
		} else if (cursor.getNext() != null) {
			newCarNode.setNext(cursor.getNext());
			cursor.getNext().setPrev(newCarNode);
			
			newCarNode.setPrev(cursor);
			cursor.setNext(newCarNode);
		} else if (cursor.getNext() == null){
			newCarNode.setPrev(cursor);
			cursor.setNext(newCarNode);
			tail = newCarNode;
		}

		cursor = newCarNode;
		
	}
	/**
	 * Removes the <code>TrainCarNode</code> referenced by the cursor and returns the <code>TrainCar</code> contained 
	 * within the node.
	 * 
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>The cursor is not null.</dd>
	 * </dl>
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * The <code>TrainCarNode</code> referenced by the cursor has been removed from the train. The cursor now references the
	 * next node, or the previous node if the next node doesn't exist.
	 * </dd>
	 * </dl>
	 * 
	 * @return
	 * 	The removed node
	 * 
	 * @throws EmptyListException
	 * 	if the list is already empty
	 */
	public TrainCar removeCursor() throws EmptyListException{
		if (cursor == null) {
			throw new EmptyListException();
		}
		if (cursor.getPrev() != null) {
			cursor.getPrev().setNext(cursor.getNext());
		} else if (cursor.getPrev() == null) {
			head = cursor.getNext();
		}
		if (cursor.getNext() != null) {
			cursor.getNext().setPrev(cursor.getPrev());
		} else if (cursor.getNext() == null) {
			tail = cursor.getPrev();
		}
		TrainCarNode removedNode = cursor;
		try {
			cursorForward();
		} catch (CursorBoundsException e) {
			try {
				cursorBackward();
			} catch (CursorBoundsException e1) {
				cursor = null;
				System.out.println("The list is now empty.");
			}
		} 
		updateNumberData(removedNode.getCar(), "-");
		return removedNode.getCar();
	}
	/**
	 * Determines the number of <code>TrainCar</code> objects currently on the train.
	 * 
	 * @return
	 * 	The number of <code>TrainCar</code> objects on this train.
	 */
	public int size() {
		return carCount;
	}
	/**
	 * Determines the total length of the train in meters.
	 * 
	 * @return
	 * 	The sum of the lengths of the cars.
	 */
	public double getLength() {
		return totalLength;
	}
	/**
	 * Determines the total value of products on the train.
	 * 
	 * @return
	 * 	The sum of the values of each car on the train.
	 */
	public double getValue() {
		return totalValue;
	}
	/**
	 * Determines the total weight of the train. Note that the weight of the train 
	 * is the sum of the weights of each empty <code>TrainCar</code>, plus the weight of the 
	 * <code>ProductLoad</code> carried by that car.
	 * 
	 * @return
	 * 	The total weight of the train.
	 */
	public double getWeight() {
		return totalWeight;
	}
	/**
	 * Determines if there is a car on the train that carries a dangerous load.
	 * 
	 * @return
	 * 	True if there is a dangerous car, and false otherwise
	 */
	public boolean isDangerous() {
		return dangerCount > 0;
	}
	/**
	 * Searches the list for all <code>ProductLoad</code> objects with the indicated name and sums together their weight 
	 * and value (Also keeps track of whether the product is dangerous or not), then returns an array containing data
	 * about the product.
	 * 
	 * @name
	 * 	The name of the <code>ProductLoad</code> to find on the train.
	 * 
	 * @return
	 * 	An array of the form [totalWeight, totalValue, isDangerous]
	 */
	public int [] getProductData(String name) {
		int totalWeight = 0;
		int totalValue = 0;
		int isDangerous = 0; // Set 0 if false, 1 if true
		TrainCarNode currentCarNode = head;
		
		while (currentCarNode != null) {
			if (currentCarNode.getCar().getLoad() == null) {
				currentCarNode = currentCarNode.getNext();
				continue;
			}
			ProductLoad product = currentCarNode.getCar().getLoad();
			if (product.getName().toLowerCase().equals(name.toLowerCase())) {
				totalWeight += product.getWeight();
				totalValue += product.getValue();
				if (product.isDangerous()) isDangerous = 1;
			}
			currentCarNode = currentCarNode.getNext();
		}
		int[] productData = {totalWeight, totalValue, isDangerous};
		return productData;
	}
	/**
	 * Searches the list for all <code>ProductLoad</code> objects with the indicated name and sums together their weight 
	 * and value (Also keeps track of whether the product is dangerous or not), then prints a single 
	 * <code>ProductLoad</code> record to the console.
	 * 
	 * @name
	 * 	The name of the <code>ProductLoad</code> to find on the train.
	 */
	public void findProduct(String name) {
		int[] productData = getProductData(name);
		String header = "\n" + ProductLoad.makeTableHeader();
		String border = "=========================================================================================";
		String productString = ProductLoad.toTableString(name, productData[0], productData[1], productData[2] == 1);
		
		System.out.println(header);
		System.out.println(border);
		System.out.println(productString);
	}
	/**
	 * Prints a neatly formatted table of the car number, car length, car weight, load name, load weight, 
	 * load value, and load dangerousness for all of the car on the train.
	 */
	public void printManifest() {
		System.out.println("  " + String.format("%-38s%-65s", "CAR:", "LOAD:"));
		System.out.println("  " + TrainCar.makeTableHeader() + "  |  " + ProductLoad.makeTableHeader());
		System.out.println("  ===================================+======================================================================");
		
		TrainCarNode currentNode = head;
		int loopCounter = 1;
		while (currentNode != null){
			String currentNodeMarker = "  ";
			if(currentNode == cursor) currentNodeMarker = "->";
			if (currentNode.getCar().getLoad() == null) {
				String name = "Empty";
				double weight = 0;
				double value = 0;;
				boolean isDangerous = false;
				System.out.println(currentNodeMarker + TrainCar.toTableString(loopCounter, currentNode.getCar().getLength(), currentNode.getCar().getWeight()) + "  |  " + ProductLoad.toTableString(name, weight, value, isDangerous));
			} else {
				String name = currentNode.getCar().getLoad().getName();
				double weight = currentNode.getCar().getLoad().getWeight();
				double value = currentNode.getCar().getLoad().getValue();
				boolean isDangerous = currentNode.getCar().getLoad().isDangerous();
				System.out.println(currentNodeMarker + TrainCar.toTableString(loopCounter, currentNode.getCar().getLength(), currentNode.getCar().getWeight()) + "  |  " + ProductLoad.toTableString(name, weight, value, isDangerous));
			}
			currentNode = currentNode.getNext();
			loopCounter += 1;
		}
	}
	/**
	 * Removes all dangerous cars from the train, maintaining the order of the cars in the train.
	 * 
	 * <dl>
	 * <dt>Postconditions</dt>
	 * <dd>
	 * All dangerous cars have been removed from this train. Furthermore, the order of all non-dangerous cars must be maintained 
	 * upon the completion of this method. 
	 * </dd>
	 * </dl>
	 */
	public void removeDangerousCars() {
		TrainCarNode currentCarNode = head;
		
		while (currentCarNode != null) {
			if(currentCarNode.getCar().getLoad() != null && currentCarNode.getCar().getLoad().isDangerous()) {
				if (currentCarNode == head) head = head.getNext();
				if (currentCarNode == tail) tail = tail.getPrev();
				if (currentCarNode.getPrev() != null) currentCarNode.getPrev().setNext(currentCarNode.getNext());
				if (currentCarNode.getNext() != null) currentCarNode.getNext().setPrev(currentCarNode.getPrev());
				if (currentCarNode == cursor) {
					try {
						cursorForward();
					} catch (CursorBoundsException e) {
						try {
							cursorBackward();
						} catch (CursorBoundsException e1) {
							cursor = null;
						}
					}
				}
				updateNumberData(currentCarNode.getCar(), "-");
			} 
			currentCarNode = currentCarNode.getNext();
		}
	}
	/**
	 * Returns a neatly formatted String representation of the train.
	 * 
	 * @returns 
	 * 	A neatly formatted string containing information about the train, including it's size (number of cars), 
	 *  length in meters, weight in tons, value in dollars, and whether it is dangerous or not.
	 */
	@Override
	public String toString() {
		return "Train: " 
				+ carCount + " cars, " 
				+ totalLength + " meters, " 
				+ totalWeight + " tons, $" 
				+ String.format("%.2f", totalValue) + " value, " 
				+ (dangerCount > 0 ? " dangerous." : " not dangerous.");
	}
}
