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
			totalValue -= car.getLoad().getValue();
			totalWeight -= car.getWeight() + car.getLoad().getWeight(); 
			if(car.getLoad().isDangerous()) {
				dangerCount -= 1;
			}
		} else if (mode == "+") {
			carCount += 1;
			totalLength += car.getLength();
			totalValue += car.getLoad().getValue();
			totalWeight += car.getWeight() + car.getLoad().getWeight();
			if(car.getLoad().isDangerous()) {
				dangerCount += 1;
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
		
		if (cursor.getNext() != null) {
			newCarNode.setNext(cursor.getNext());
			cursor.getNext().setPrev(newCarNode);
		}
		
		newCarNode.setPrev(cursor);
		cursor.setNext(newCarNode);

		try {
			cursorForward();
		} catch (CursorBoundsException e) {
			System.out.println("The cursor is out of bounds.");
		}
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
	 */
	public TrainCar removeCursor() {
		cursor.getPrev().setNext(cursor.getNext());
		cursor.getNext().setPrev(cursor.getPrev());
		TrainCarNode removedNode = cursor;
		try {
			cursorForward();
		} catch (CursorBoundsException e) {
			try {
				cursorBackward();
			} catch (CursorBoundsException e1) {
				System.out.println("The linked list is now empty.");
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
	public void findProduct() {
		
	}
	public void printManifest() {
		
	}
	public void removeDangerousCars() {
		
	}
	@Override
	public String toString() {
		
	}
}
