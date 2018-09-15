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
		this.isDangerous=false;
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
		private double totalLength;
		private double totalValue; 
		private double totalWeight;
		this.cursor.setCar(car);
	}
	
	public void updateNumberData(TrainCar car, String mode) {
		if (mode == "-") {
			carCount -= 1;
			totalLength -= car.getLength();
			totalValue -= car.getLoad().getValue();
			totalWeight -= car.getWeight() + car.getLoad().getWeight(); 
		} else if (mode == "+") {
			carCount += 1;
			totalLength += car.getLength();
			totalValue += car.getLoad().getValue();
			totalWeight += car.getWeight() + car.getLoad().getWeight(); 
		}
	}
	
	public void updateDangerStatus 
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
		
		newCarNode.setNext(cursor.getNext());
		cursor.getNext().setPrev(newCarNode);
		
		newCarNode.setPrev(cursor);
		cursor.setNext(newCarNode);
		
		carCount += 1;
	}
	public TrainCar removeCursor() {
		
	}
	
	public int size() {
		
	}
	public double getLength() {
		
	}
	public double getValue() {
		
	}
	public double getWeight() {
		
	}
	public double isDangerous() {
		
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
