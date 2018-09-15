package traincarmanager;

/**
* <code>CursorBoundsException</code> is thrown when one attempt to move the cursor forward
* or backward while the cursor is at the tail or head respectively.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/

public class CursorBoundsException extends Exception {
	private static final long serialVersionUID = -8347564979435460669L;

	/**
	 * Returns an instance of <code>CursorBoundsException</code>.
	 */
	public CursorBoundsException() {
		super();
	}
	
	/**
	 * Returns an instance of <code>CursorBoundsException</code> along with the specified message.
	 * 
	 * @param message 
	 * 	The message that accompanies the error.
	 */
	public CursorBoundsException(String message) {
		super(message);
	}
}
