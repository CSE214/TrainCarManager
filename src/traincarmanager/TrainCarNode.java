package traincarmanager;

/**
* The <code>TrainCarNode</code> is a wrapper node for <code>TrainCar</node> for implementation in
* <code>TrainLinkedList</code>.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class TrainCarNode {
	private TrainCarNode prev; // reference to previous node
	private TrainCarNode next; // reference to next node
	private TrainCar car; // TrainCar the node is wrapping
	
	/**
	 * @return 
	 *	The previous node for this instance
	 */
	public TrainCarNode getPrev() {
		return prev;
	}
	/**
	 * @param prev 
	 * 	The new previous node to set
	 */
	public void setPrev(TrainCarNode prev) {
		this.prev = prev;
	}
	/**
	 * @return 
	 *	The next node for this instance
	 */
	public TrainCarNode getNext() {
		return next;
	}
	/**
	 * @param next 
	 * 	The new next node to set
	 */
	public void setNext(TrainCarNode next) {
		this.next = next;
	}
	/**
	 * @return 
	 *	The car of this instance
	 */
	public TrainCar getCar() {
		return car;
	}
	/**
	 * @param car 
	 * 	The new car to set
	 */
	public void setCar(TrainCar car) {
		this.car = car;
	}
	
	/**
	 * Returns an instance of <code>TrainCarNode</code> with no car data
	 */
	public TrainCarNode() {
	}	
	/**
	 * Returns an instance of <code>TrainCarNode</code>
	 * 
	 * @param car
	 * 	The <code>TrainCar</code> that this node is wrapping
	 */
	public TrainCarNode(TrainCar car) {
		this.car = car;
	}
	
	
}
