package traincarmanager;

/**
* <code>EmptyListException</code> is thrown when an invalid operation is performed on
* an empty list.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class EmptyListException extends Exception {
	
	private static final long serialVersionUID = -2916450956076028447L;

	/**
	 * Returns an instance of <code>EmptyListException</code>.
	 */
	public EmptyListException() {
		super();
	}
	
	/**
	 * Returns an instance of <code>NegativeNumberException</code> along with the specified message.
	 * 
	 * @param message 
	 * 	The message that accompanies the error.
	 */
	public EmptyListException(String message) {
		super(message);
	}
}
