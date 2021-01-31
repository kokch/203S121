package reuse;

public class Bus extends Vehicle{
	private int sittingCapacity;
	private int standingCapacity;
	
	public Bus(String regNo, String owner, int sittingCapacity, 
		int	standingCapacity) { 
		super(regNo, owner);
		setSittingCapacity(sittingCapacity); 
		setStandingCapacity(standingCapacity);
	}
	
	public int getSittingCapacity() {
		return sittingCapacity;
	}
	
	public void setSittingCapacity(int sittingCapacity) {
		this.sittingCapacity = sittingCapacity; 
	}
	
	public int getStandingCapacity() {
		return standingCapacity;
	}
	
	public void setStandingCapacity(int standingCapacity) {
		this.standingCapacity = standingCapacity;
	}
	
	public String toString() {
		return "Bus " + super.toString() + "with sitting capacity: " + 
			getSittingCapacity() + " and standing capacity: " +
			getStandingCapacity();
	} 
}
