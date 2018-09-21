package traincarmanager;

/**
* The <code>ProductLoad</code> class implements a model for a product load.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class ProductLoad {
	private String name; // name of load
	private double weight; // weight of load in tons
	private double value; // value of load in dollars
	private boolean isDangerous; // danger status of load
	
	/**
	 * @return 
	 *	The name of this instance
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name 
	 * 	The new name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return 
	 *	The weight of this instance
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight 
	 * 	The new weight to set. Should be at least 0.
	 * 
	 * @throws NotPositiveNumberException
	 * 	If the weight parameter is not positive.
	 */
	public void setWeight(double weight) throws NotPositiveNumberException {
		if (weight <= 0) {
			throw new NotPositiveNumberException("Weight should be positive.");
		}
		this.weight = weight;
	}
	/**
	 * @return 
	 *	The value of this instance
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value 
	 * 	The new value to set. Should be at least 0.
	 * 
	 * @throws NotPositiveNumber Exception
	 * 	If the value parameter is not positive.
	 */
	public void setValue(double value) throws NotPositiveNumberException {
		if (value <= 0) {
			throw new NotPositiveNumberException("Value should be positive.");
		}
		this.value = value;
	}
	/**
	 * @return 
	 *	The isDangerous status of this instance
	 */
	public boolean isDangerous() {
		return isDangerous;
	}
	/**
	 * @param isDangerous 
	 * 	The new isDangerous status to set
	 */
	public void setDangerous(boolean isDangerous) {
		this.isDangerous = isDangerous;
	}
	
	/**
	 * Forms a header for tables containing <code>ProductLoad</code> information
	 * 
	 * @return
	 * 	A header for table containing <code>ProductLoad</code> information
	 */
	public static String makeTableHeader() {
		return String.format("%-25s%-15s%-15s%-15s", "Name", "Weight (t)", "Value ($)", "Dangerous");
	}
	
	/**
	 * Forms a string using product data that can be used to print tables.
	 * 
	 * @param name
	 * 	name of the product(s)
	 * @param weight
	 * 	weight of the product(s)
	 * @param value
	 * 	value of the product(s)
	 * @param isDangerous
	 * 	danger status of product(s)
	 * 
	 * @return
	 * 	a table-friendly string representation of the product(s)
	 */
	public static String toTableString(String name, double weight, double value, boolean isDangerous) {
		return String.format("%-25s%-15s%-15s%-10s", name, weight, String.format("%.2f", value), isDangerous ? "YES" : "NO");
	}
	
	/**
	 * Returns an instance of <code>ProductLoad</code>
	 * 
	 * @param name
	 * 	The name of the new instance.
	 * @param weight
	 * 	The weight of the new instance.
	 * @param value
	 * 	The value of the new instance.
	 * @param isDangerous
	 * 	The danger status of the new instance.
	 * 
	 * @throws NotPositiveNumberException
	 * 	If the weight or value parameter is not positive.
	 */
	public ProductLoad(String name, double weight, double value, boolean isDangerous) throws NotPositiveNumberException {
		if (weight <= 0) {
			throw new NotPositiveNumberException("Weight should be positive.");
		} else if (value <= 0) {
			throw new NotPositiveNumberException("Value should be positive.");
		}
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	
	
	
}
