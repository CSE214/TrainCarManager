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
	 * <dl>
	 * <dt>Preconditions</dt>
	 * <dd>Length or weight should be a positive number.</dd>
	 * </dl>
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
	
	/**
	 * Forms a header for tables containing <code>TrainCar</code> information
	 * 
	 * @return
	 * 	A header for table containing <code>TrainCar</code> information
	 */
	public static String makeTableHeader() {
		return String.format("%3s%15s%15s", "Num", "Length (m)", "Weight (t)");
	}
	
	/**
	 * Forms a string using car data that can be used to print tables.
	 * 
	 * @param num
	 * 	car position in train list (starts at 1)
	 * @param length
	 * 	length of car
	 * @param weight
	 * 	weight of car by itself
	 * 
	 * @return
	 * 	a table-friendly string representation of the car
	 */
	public static String toTableString(int num, double length, double weight) {
		return String.format("%3s%15s%15s", num, length, weight);
	}
	
}
