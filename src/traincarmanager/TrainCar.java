package traincarmanager;

/**
* The <code>TrainCar</code> class implements a model for a train car. Each instance can 
* carry an instance of <code>ProductLoad</code>.
*    
*
* @author Sayan Sivakumaran
*    e-mail: sayan.sivakumaran@stonybrook.edu
*    Stony Brook ID: 110261379
**/
public class TrainCar {
	final private double length; // length of car
	final private double weight; // weight of car
	private ProductLoad load = null; // load of car
	
	/**
	 * @return 
	 *	The length of this instance
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length 
	 * 	The weight of this instance
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * @param weight 
	 * 	The <code>ProductLoad> of this instance
	 */
	public ProductLoad getLoad() {
		return load;
	}
	/**
	 * @param load 
	 * 	The new <code>ProductLoad</code> to set
	 */
	public void setLoad(ProductLoad load) {
		this.load = load;
	}
	
	/**
	 * Returns an instance of <code>TrainCar</code> with no product data
	 * 
	 * @param length
	 * 	The length of this instance
	 * @param weight
	 * 	The weight of this instance
	 * 
	 * @throws NotPositiveNumberException
	 * 	If the passed length or weight is not positive
	 */
	public TrainCar(double length, double weight) throws NotPositiveNumberException{
		if (length < 0) {
			throw new NotPositiveNumberException("Length should be positive.");
		} else if (weight < 0) {
			throw new NotPositiveNumberException("Weight should be positive.");
		}
		this.length = length;
		this.weight = weight;
	}
	
	/**
	 * Returns an instance of <code>TrainCar</code>
	 * 
	 * @param length
	 * 	The length of this instance
	 * @param weight
	 * 	The weight of this instance
	 * @param load
	 * 	The <code>ProductLoad</code> of this instance
	 * 
	 * @throws NotPositiveNumberException
	 * 	If the passed length or weight is not positive
	 */
	public TrainCar(double length, double weight, ProductLoad load) throws NotPositiveNumberException{
		if (length < 0) {
			throw new NotPositiveNumberException("Length should be positive.");
		} else if (weight < 0) {
			throw new NotPositiveNumberException("Weight should be positive.");
		}
		this.length = length;
		this.weight = weight;
		this.load = load;
	}
	
	/**
	 * Checks if this car instance is empty
	 * 
	 * @return
	 * 	True if the car is carrying a load, and false otherwise
	 */
	public boolean isEmpty() {
		return this.load == null;
	}
	
}
