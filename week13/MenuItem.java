package restaurantapp;

public class MenuItem {
    private static int nextNo = 100; 	// to autogenerate
    private int itemNo;
    private String description;
    private double price;
    
    public MenuItem(String description, double price) {
    	setItemNo(nextNo++);
    	setDescription(description);
    	setPrice(price);
    }
	/**
	 * @return the nextNo
	 */
	public static int getNextNo() {
		return nextNo;
	}
	/**
	 * @param nextNo the nextNo to set
	 */
	public static void setNextNo(int nextNo) {
		MenuItem.nextNo = nextNo;
	}
	/**
	 * @return the itemNo
	 */
	public int getItemNo() {
		return itemNo;
	}
	/**
	 * @param itemNo the itemNo to set
	 */
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

}
