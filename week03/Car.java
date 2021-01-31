package reuse;

public class Car extends Vehicle {
	private int seatCapacity; // = 0;

	public Car() {
		this("not set", "not set", 0);
		
		//super();
		//setSeatCapacity(0);
	}
	
	public Car(String owner, String regNo, int seatCapacity) {
		super(owner, regNo);
		//setOwner(owner);
		//setRegNo(regNo);
		setSeatCapacity(seatCapacity);
	}
	
	/**
	 * @return the seatCapacity
	 */
	public int getSeatCapacity() {
		return seatCapacity;
	}

	/**
	 * @param seatCapacity the seatCapacity to set
	 */
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	
	public String toString() {
		return "Car " + super.toString() + 
			" with seat capacity " + getSeatCapacity();
	}
	

}
