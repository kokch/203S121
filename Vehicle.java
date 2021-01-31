package reuse;

public abstract class Vehicle extends Object {
	private String regNo; // = null;
	private String owner; // = null;
	
	public Vehicle() {
		this("not set", "not set");
		// setOwner("not set");
		// setRegNo("not set");
	}
	
	public Vehicle(String owner, String regNo) {
		setOwner(owner); // this.owner = owner;
		setRegNo(regNo);
	}
	
	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String toString() {
		return getRegNo() + " owned by " + getOwner();
	}
}
