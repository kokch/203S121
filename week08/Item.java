package inputoutput;
//import java.io.Serializable;

public class Item implements java.io.Serializable {
	private String name;
	private double price;
	
	
	public Item(String name, double price) {
		setName(name);
		setPrice(price);
	}
	
	public String toString() {
		return String.format("%s costs $%1.2f", getName(), 
			getPrice());
	}
	
	public boolean equals(Item obj) {
		return getName().equalsIgnoreCase(obj.getName());
	}
	
	
	public boolean equals(Object obj) {
		if (obj instanceof Item)
			return getName().equalsIgnoreCase(
				((Item) obj).getName());
		return false;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
