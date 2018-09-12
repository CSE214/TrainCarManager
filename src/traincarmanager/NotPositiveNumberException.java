package traincarmanager;

/**
* <code>NotPositiveNumberException</code> is thrown when a non-positive number is 
* entered as input for a function that only takes positive values.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/

public class NotPositiveNumberException extends Exception {
	private static final long serialVersionUID = 7726779584681368687L;
	/**
	 * Returns an instance of <code>NotPositiveNumberException</code>.
	 */
	public NotPositiveNumberException() {
		super();
	}
	
	/**
	 * Returns an instance of <code>NotPositiveNumberException</code> along with the specified message.
	 * 
	 * @param message 
	 * 	The message that accompanies the error.
	 */
	public NotPositiveNumberException(String message) {
		super(message);
	}

}
