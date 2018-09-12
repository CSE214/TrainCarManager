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
	 * @throws NegativeNumberException
	 * 	If the weight parameter is negative.
	 */
	public void setWeight(double weight) throws NegativeNumberException {
		if (weight < 0) {
			throw new NegativeNumberException("Weight should not be negative.");
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
	 * @throws NegativeNumberException
	 * 	If the value parameter is negative.
	 */
	public void setValue(double value) throws NegativeNumberException {
		if (value < 0) {
			throw new NegativeNumberException("Value should not be negative.");
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
	 */
	public ProductLoad(String name, double weight, double value, boolean isDangerous) {
		this.name = name;
		this.weight = weight;
		this.value = value;
		this.isDangerous = isDangerous;
	}
	
	
	
}
