package streams;

public class Item implements Comparable<Item>, Cloneable {
	private String name;  // null
	private double price; // 0.0
	
	public Item() {
		this("not set", 1.0);
	}
	
	public Item(String name, double price) {
		setName(name);
		setPrice(price);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return getName() + ", costing " + getPrice();
	}
	
	// overloaded equals method
	public boolean equals(Item obj) {
		return this.getName().equalsIgnoreCase(
			obj.getName());
	}
	
	@Override   
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Item)) {
			return false;
		}
		return this.getName().equalsIgnoreCase(
			((Item) obj).getName());
		/*	
		Item other = (Item) obj;
		if (this.getName().equalsIgnoreCase(other.getName()))
			return true;
		else 
			return false;
		*/
	}

	public int compareTo(Item rhs) {
		//return this.getName().compareToIgnoreCase(rhs.getName());
		return Double.compare(this.getPrice(), rhs.getPrice());
	}
	
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException cnse) {
			return null;
		}
	}
}